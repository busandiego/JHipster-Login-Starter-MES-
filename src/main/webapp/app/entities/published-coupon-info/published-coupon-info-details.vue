<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="publishedCouponInfo">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.detail.title')">PublishedCouponInfo</span> {{publishedCouponInfo.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponName')">Published Coupon Name</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponType')">Published Coupon Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponType.' + publishedCouponInfo.publishedCouponType)">{{publishedCouponInfo.publishedCouponType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAllUse')">Published Coupon All Use</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponAllUse}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseAffiliateId')">Published Coupon Use Affiliate Id</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponUseAffiliateId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAmountType')">Published Coupon Amount Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponAmountType.' + publishedCouponInfo.publishedCouponAmountType)">{{publishedCouponInfo.publishedCouponAmountType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponDuplication')">Published Coupon Duplication</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponDuplication}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAutoPublish')">Published Coupon Auto Publish</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponAutoPublish}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseTypeLimit')">Published Coupon Use Type Limit</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponUseTypeLimit}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseType')">Published Coupon Use Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponUseType.' + publishedCouponInfo.publishedCouponUseType)">{{publishedCouponInfo.publishedCouponUseType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUsePriceLimit')">Published Coupon Use Price Limit</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponUsePriceLimit}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUsePrice')">Published Coupon Use Price</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponUsePrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseExpireLimit')">Published Coupon Use Expire Limit</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponUseExpireLimit}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseExpireMonth')">Published Coupon Use Expire Month</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponUseExpireMonth}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponCreateDt')">Published Coupon Create Dt</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponCreateDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUpdateDt')">Published Coupon Update Dt</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponUpdateDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponCurrentPublishedDt')">Published Coupon Current Published Dt</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponCurrentPublishedDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAmountNum')">Published Coupon Amount Num</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponAmountNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponSoldNum')">Published Coupon Sold Num</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.publishedCouponSoldNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.couponState')">Coupon State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.StateCoupon.' + publishedCouponInfo.couponState)">{{publishedCouponInfo.couponState}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponInfo.couponPublishedHistoriesId')">Coupon Published Histories Id</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponInfo.couponPublishedHistoriesId}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="publishedCouponInfo.id" :to="{name: 'PublishedCouponInfoEdit', params: {publishedCouponInfoId: publishedCouponInfo.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./published-coupon-info-details.component.ts">
</script>
