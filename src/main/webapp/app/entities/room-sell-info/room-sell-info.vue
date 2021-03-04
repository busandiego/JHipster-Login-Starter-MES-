<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.roomSellInfo.home.title')" id="room-sell-info-heading">Room Sell Infos</span>
            <router-link :to="{name: 'RoomSellInfoCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-room-sell-info">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.roomSellInfo.home.createLabel')">
                    Create a new Room Sell Info
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
        <div class="alert alert-warning" v-if="!isFetching && roomSellInfos && roomSellInfos.length === 0">
            <span v-text="$t('hotelgaServerApp.roomSellInfo.home.notFound')">No roomSellInfos found</span>
        </div>
        <div class="table-responsive" v-if="roomSellInfos && roomSellInfos.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('roomSalesType')"><span v-text="$t('hotelgaServerApp.roomSellInfo.roomSalesType')">Room Sales Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('roomId')"><span v-text="$t('hotelgaServerApp.roomSellInfo.roomId')">Room Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="roomSellInfo in roomSellInfos"
                    :key="roomSellInfo.id">
                    <td>
                        <router-link :to="{name: 'RoomSellInfoView', params: {roomSellInfoId: roomSellInfo.id}}">{{roomSellInfo.id}}</router-link>
                    </td>
                    <td v-text="$t('hotelgaServerApp.RoomSalesType.' + roomSellInfo.roomSalesType)">{{roomSellInfo.roomSalesType}}</td>
                    <td>{{roomSellInfo.roomId}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'RoomSellInfoView', params: {roomSellInfoId: roomSellInfo.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'RoomSellInfoEdit', params: {roomSellInfoId: roomSellInfo.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(roomSellInfo)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.roomSellInfo.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-roomSellInfo-heading" v-bind:title="$t('hotelgaServerApp.roomSellInfo.delete.question')">Are you sure you want to delete this Room Sell Info?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-roomSellInfo" v-text="$t('entity.action.delete')" v-on:click="removeRoomSellInfo()">Delete</button>
            </div>
        </b-modal>
        <div v-show="roomSellInfos && roomSellInfos.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./room-sell-info.component.ts">
</script>
