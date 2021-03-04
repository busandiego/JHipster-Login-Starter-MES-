<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.reservation.home.title')" id="reservation-heading">Reservations</span>
            <router-link :to="{name: 'ReservationCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-reservation">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.reservation.home.createLabel')">
                    Create a new Reservation
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
        <div class="alert alert-warning" v-if="!isFetching && reservations && reservations.length === 0">
            <span v-text="$t('hotelgaServerApp.reservation.home.notFound')">No reservations found</span>
        </div>
        <div class="table-responsive" v-if="reservations && reservations.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('orderUniqNum')"><span v-text="$t('hotelgaServerApp.reservation.orderUniqNum')">Order Uniq Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('orderUserName')"><span v-text="$t('hotelgaServerApp.reservation.orderUserName')">Order User Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('orderUserNum')"><span v-text="$t('hotelgaServerApp.reservation.orderUserNum')">Order User Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('transportation')"><span v-text="$t('hotelgaServerApp.reservation.transportation')">Transportation</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('accommodationName')"><span v-text="$t('hotelgaServerApp.reservation.accommodationName')">Accommodation Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('roomName')"><span v-text="$t('hotelgaServerApp.reservation.roomName')">Room Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('reservationPrice')"><span v-text="$t('hotelgaServerApp.reservation.reservationPrice')">Reservation Price</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('roomDiscountPer')"><span v-text="$t('hotelgaServerApp.reservation.roomDiscountPer')">Room Discount Per</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponApply')"><span v-text="$t('hotelgaServerApp.reservation.couponApply')">Coupon Apply</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponName')"><span v-text="$t('hotelgaServerApp.reservation.couponName')">Coupon Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponDiscountPrice')"><span v-text="$t('hotelgaServerApp.reservation.couponDiscountPrice')">Coupon Discount Price</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponType')"><span v-text="$t('hotelgaServerApp.reservation.couponType')">Coupon Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('paymentPrice')"><span v-text="$t('hotelgaServerApp.reservation.paymentPrice')">Payment Price</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('paymentType')"><span v-text="$t('hotelgaServerApp.reservation.paymentType')">Payment Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateCommission')"><span v-text="$t('hotelgaServerApp.reservation.affiliateCommission')">Affiliate Commission</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('managerCommission')"><span v-text="$t('hotelgaServerApp.reservation.managerCommission')">Manager Commission</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('investmentCommission')"><span v-text="$t('hotelgaServerApp.reservation.investmentCommission')">Investment Commission</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('useStartTime')"><span v-text="$t('hotelgaServerApp.reservation.useStartTime')">Use Start Time</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('useEndTime')"><span v-text="$t('hotelgaServerApp.reservation.useEndTime')">Use End Time</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('orderCreateDt')"><span v-text="$t('hotelgaServerApp.reservation.orderCreateDt')">Order Create Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('checkInDt')"><span v-text="$t('hotelgaServerApp.reservation.checkInDt')">Check In Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('checkOutDt')"><span v-text="$t('hotelgaServerApp.reservation.checkOutDt')">Check Out Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('orderState')"><span v-text="$t('hotelgaServerApp.reservation.orderState')">Order State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('hoMemberId')"><span v-text="$t('hotelgaServerApp.reservation.hoMemberId')">Ho Member Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('managerId')"><span v-text="$t('hotelgaServerApp.reservation.managerId')">Manager Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateId')"><span v-text="$t('hotelgaServerApp.reservation.affiliateId')">Affiliate Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('accommodationId')"><span v-text="$t('hotelgaServerApp.reservation.accommodationId')">Accommodation Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="reservation in reservations"
                    :key="reservation.id">
                    <td>
                        <router-link :to="{name: 'ReservationView', params: {reservationId: reservation.id}}">{{reservation.id}}</router-link>
                    </td>
                    <td>{{reservation.orderUniqNum}}</td>
                    <td>{{reservation.orderUserName}}</td>
                    <td>{{reservation.orderUserNum}}</td>
                    <td>{{reservation.transportation}}</td>
                    <td>{{reservation.accommodationName}}</td>
                    <td>{{reservation.roomName}}</td>
                    <td>{{reservation.reservationPrice}}</td>
                    <td>{{reservation.roomDiscountPer}}</td>
                    <td>{{reservation.couponApply}}</td>
                    <td>{{reservation.couponName}}</td>
                    <td>{{reservation.couponDiscountPrice}}</td>
                    <td>{{reservation.couponType}}</td>
                    <td>{{reservation.paymentPrice}}</td>
                    <td>{{reservation.paymentType}}</td>
                    <td>{{reservation.affiliateCommission}}</td>
                    <td>{{reservation.managerCommission}}</td>
                    <td>{{reservation.investmentCommission}}</td>
                    <td>{{reservation.useStartTime | formatDate}}</td>
                    <td>{{reservation.useEndTime | formatDate}}</td>
                    <td>{{reservation.orderCreateDt | formatDate}}</td>
                    <td>{{reservation.checkInDt | formatDate}}</td>
                    <td>{{reservation.checkOutDt | formatDate}}</td>
                    <td v-text="$t('hotelgaServerApp.StateOrder.' + reservation.orderState)">{{reservation.orderState}}</td>
                    <td>{{reservation.hoMemberId}}</td>
                    <td>{{reservation.managerId}}</td>
                    <td>{{reservation.affiliateId}}</td>
                    <td>{{reservation.accommodationId}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'ReservationView', params: {reservationId: reservation.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'ReservationEdit', params: {reservationId: reservation.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(reservation)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.reservation.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-reservation-heading" v-bind:title="$t('hotelgaServerApp.reservation.delete.question')">Are you sure you want to delete this Reservation?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-reservation" v-text="$t('entity.action.delete')" v-on:click="removeReservation()">Delete</button>
            </div>
        </b-modal>
        <div v-show="reservations && reservations.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./reservation.component.ts">
</script>
