<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="coupon">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.coupon.detail.title')">Coupon</span> {{coupon.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponName')">Coupon Name</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponType')">Coupon Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponType.' + coupon.couponType)">{{coupon.couponType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponAllUse')">Coupon All Use</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponAllUse}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUseAffiliateId')">Coupon Use Affiliate Id</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponUseAffiliateId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponAmountType')">Coupon Amount Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponAmountType.' + coupon.couponAmountType)">{{coupon.couponAmountType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponDuplication')">Coupon Duplication</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponDuplication}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponAutoPublish')">Coupon Auto Publish</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponAutoPublish}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUseTypeLimit')">Coupon Use Type Limit</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponUseTypeLimit}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUseType')">Coupon Use Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponUseType.' + coupon.couponUseType)">{{coupon.couponUseType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUsePriceLimit')">Coupon Use Price Limit</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponUsePriceLimit}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUsePrice')">Coupon Use Price</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponUsePrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUseExpireLimit')">Coupon Use Expire Limit</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponUseExpireLimit}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUseExpireMonth')">Coupon Use Expire Month</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponUseExpireMonth}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponCreateDt')">Coupon Create Dt</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponCreateDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponUpdateDt')">Coupon Update Dt</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponUpdateDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponCurrentPublishedDt')">Coupon Current Published Dt</span>
                    </dt>
                    <dd>
                        <span>{{coupon.couponCurrentPublishedDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.coupon.couponState')">Coupon State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.StateCoupon.' + coupon.couponState)">{{coupon.couponState}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="coupon.id" :to="{name: 'CouponEdit', params: {couponId: coupon.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./coupon-details.component.ts">
</script>
