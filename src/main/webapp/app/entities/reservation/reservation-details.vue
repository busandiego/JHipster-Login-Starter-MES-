<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="reservation">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.reservation.detail.title')">Reservation</span> {{reservation.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.orderUniqNum')">Order Uniq Num</span>
                    </dt>
                    <dd>
                        <span>{{reservation.orderUniqNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.orderUserName')">Order User Name</span>
                    </dt>
                    <dd>
                        <span>{{reservation.orderUserName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.orderUserNum')">Order User Num</span>
                    </dt>
                    <dd>
                        <span>{{reservation.orderUserNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.transportation')">Transportation</span>
                    </dt>
                    <dd>
                        <span>{{reservation.transportation}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.accommodationName')">Accommodation Name</span>
                    </dt>
                    <dd>
                        <span>{{reservation.accommodationName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.roomName')">Room Name</span>
                    </dt>
                    <dd>
                        <span>{{reservation.roomName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.reservationPrice')">Reservation Price</span>
                    </dt>
                    <dd>
                        <span>{{reservation.reservationPrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.roomDiscountPer')">Room Discount Per</span>
                    </dt>
                    <dd>
                        <span>{{reservation.roomDiscountPer}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.couponApply')">Coupon Apply</span>
                    </dt>
                    <dd>
                        <span>{{reservation.couponApply}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.couponName')">Coupon Name</span>
                    </dt>
                    <dd>
                        <span>{{reservation.couponName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.couponDiscountPrice')">Coupon Discount Price</span>
                    </dt>
                    <dd>
                        <span>{{reservation.couponDiscountPrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.couponType')">Coupon Type</span>
                    </dt>
                    <dd>
                        <span>{{reservation.couponType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.paymentPrice')">Payment Price</span>
                    </dt>
                    <dd>
                        <span>{{reservation.paymentPrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.paymentType')">Payment Type</span>
                    </dt>
                    <dd>
                        <span>{{reservation.paymentType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.affiliateCommission')">Affiliate Commission</span>
                    </dt>
                    <dd>
                        <span>{{reservation.affiliateCommission}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.managerCommission')">Manager Commission</span>
                    </dt>
                    <dd>
                        <span>{{reservation.managerCommission}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.investmentCommission')">Investment Commission</span>
                    </dt>
                    <dd>
                        <span>{{reservation.investmentCommission}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.useStartTime')">Use Start Time</span>
                    </dt>
                    <dd>
                        <span>{{reservation.useStartTime | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.useEndTime')">Use End Time</span>
                    </dt>
                    <dd>
                        <span>{{reservation.useEndTime | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.orderCreateDt')">Order Create Dt</span>
                    </dt>
                    <dd>
                        <span>{{reservation.orderCreateDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.checkInDt')">Check In Dt</span>
                    </dt>
                    <dd>
                        <span>{{reservation.checkInDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.checkOutDt')">Check Out Dt</span>
                    </dt>
                    <dd>
                        <span>{{reservation.checkOutDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.orderState')">Order State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.StateOrder.' + reservation.orderState)">{{reservation.orderState}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.hoMemberId')">Ho Member Id</span>
                    </dt>
                    <dd>
                        <span>{{reservation.hoMemberId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.managerId')">Manager Id</span>
                    </dt>
                    <dd>
                        <span>{{reservation.managerId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.affiliateId')">Affiliate Id</span>
                    </dt>
                    <dd>
                        <span>{{reservation.affiliateId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.reservation.accommodationId')">Accommodation Id</span>
                    </dt>
                    <dd>
                        <span>{{reservation.accommodationId}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="reservation.id" :to="{name: 'ReservationEdit', params: {reservationId: reservation.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./reservation-details.component.ts">
</script>
