<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="payment">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.payment.detail.title')">Payment</span> {{payment.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.sellingPrice')">Selling Price</span>
                    </dt>
                    <dd>
                        <span>{{payment.sellingPrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.commission')">Commission</span>
                    </dt>
                    <dd>
                        <span>{{payment.commission}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.paymentMoney')">Payment Money</span>
                    </dt>
                    <dd>
                        <span>{{payment.paymentMoney}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.paymentType')">Payment Type</span>
                    </dt>
                    <dd>
                        <span>{{payment.paymentType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.paymentDt')">Payment Dt</span>
                    </dt>
                    <dd>
                        <span>{{payment.paymentDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.couponDiscount')">Coupon Discount</span>
                    </dt>
                    <dd>
                        <span>{{payment.couponDiscount}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.transactionNum')">Transaction Num</span>
                    </dt>
                    <dd>
                        <span>{{payment.transactionNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.paymentMethod')">Payment Method</span>
                    </dt>
                    <dd>
                        <span>{{payment.paymentMethod}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.remark')">Remark</span>
                    </dt>
                    <dd>
                        <span>{{payment.remark}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.reservationId')">Reservation Id</span>
                    </dt>
                    <dd>
                        <span>{{payment.reservationId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.payment.paymentState')">Payment State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.StatePayment.' + payment.paymentState)">{{payment.paymentState}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="payment.id" :to="{name: 'PaymentEdit', params: {paymentId: payment.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./payment-details.component.ts">
</script>
