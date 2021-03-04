<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.roomSellDetails.home.title')" id="room-sell-details-heading">Room Sell Details</span>
            <router-link :to="{name: 'RoomSellDetailsCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-room-sell-details">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.roomSellDetails.home.createLabel')">
                    Create a new Room Sell Details
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && roomSellDetails && roomSellDetails.length === 0">
            <span v-text="$t('hotelgaServerApp.roomSellDetails.home.notFound')">No roomSellDetails found</span>
        </div>
        <div class="table-responsive" v-if="roomSellDetails && roomSellDetails.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellDt')"><span v-text="$t('hotelgaServerApp.roomSellDetails.sellDt')">Sell Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellAmount')"><span v-text="$t('hotelgaServerApp.roomSellDetails.sellAmount')">Sell Amount</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellSoldNum')"><span v-text="$t('hotelgaServerApp.roomSellDetails.sellSoldNum')">Sell Sold Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellStartTime')"><span v-text="$t('hotelgaServerApp.roomSellDetails.sellStartTime')">Sell Start Time</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellEndTime')"><span v-text="$t('hotelgaServerApp.roomSellDetails.sellEndTime')">Sell End Time</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellUseTime')"><span v-text="$t('hotelgaServerApp.roomSellDetails.sellUseTime')">Sell Use Time</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponBoolean')"><span v-text="$t('hotelgaServerApp.roomSellDetails.couponBoolean')">Coupon Boolean</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellState')"><span v-text="$t('hotelgaServerApp.roomSellDetails.sellState')">Sell State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="roomSellDetails in roomSellDetails"
                    :key="roomSellDetails.id">
                    <td>
                        <router-link :to="{name: 'RoomSellDetailsView', params: {roomSellDetailsId: roomSellDetails.id}}">{{roomSellDetails.id}}</router-link>
                    </td>
                    <td>{{roomSellDetails.sellDt | formatDate}}</td>
                    <td>{{roomSellDetails.sellAmount}}</td>
                    <td>{{roomSellDetails.sellSoldNum}}</td>
                    <td>{{roomSellDetails.sellStartTime}}</td>
                    <td>{{roomSellDetails.sellEndTime}}</td>
                    <td>{{roomSellDetails.sellUseTime}}</td>
                    <td>{{roomSellDetails.couponBoolean}}</td>
                    <td v-text="$t('hotelgaServerApp.SellState.' + roomSellDetails.sellState)">{{roomSellDetails.sellState}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'RoomSellDetailsView', params: {roomSellDetailsId: roomSellDetails.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'RoomSellDetailsEdit', params: {roomSellDetailsId: roomSellDetails.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(roomSellDetails)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
                                <font-awesome-icon icon="times"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                            </b-button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="hotelgaServerApp.roomSellDetails.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-roomSellDetails-heading" v-bind:title="$t('hotelgaServerApp.roomSellDetails.delete.question')">Are you sure you want to delete this Room Sell Details?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-roomSellDetails" v-text="$t('entity.action.delete')" v-on:click="removeRoomSellDetails()">Delete</button>
            </div>
        </b-modal>
        <div v-show="roomSellDetails && roomSellDetails.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./room-sell-details.component.ts">
</script>
