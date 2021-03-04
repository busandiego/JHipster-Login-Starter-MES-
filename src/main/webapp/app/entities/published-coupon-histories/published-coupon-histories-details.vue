<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="publishedCouponHistories">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.detail.title')">PublishedCouponHistories</span> {{publishedCouponHistories.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedUniqCode')">Published Uniq Code</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponHistories.publishedUniqCode}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponAmountType')">Published Coupon Amount Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponAmountType.' + publishedCouponHistories.publishedCouponAmountType)">{{publishedCouponHistories.publishedCouponAmountType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.useDt')">Use Dt</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponHistories.useDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponAllUse')">Published Coupon All Use</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponHistories.publishedCouponAllUse}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponUseAffiliateId')">Published Coupon Use Affiliate Id</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponHistories.publishedCouponUseAffiliateId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedDt')">Published Dt</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponHistories.publishedDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.useCheck')">Use Check</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponHistories.useCheck}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.publishedCouponHistories.couponPublishedHistoriesId')">Coupon Published Histories Id</span>
                    </dt>
                    <dd>
                        <span>{{publishedCouponHistories.couponPublishedHistoriesId}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="publishedCouponHistories.id" :to="{name: 'PublishedCouponHistoriesEdit', params: {publishedCouponHistoriesId: publishedCouponHistories.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./published-coupon-histories-details.component.ts">
</script>
