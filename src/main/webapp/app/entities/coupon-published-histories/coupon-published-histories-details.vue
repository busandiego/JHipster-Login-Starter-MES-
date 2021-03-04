<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="couponPublishedHistories">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.detail.title')">CouponPublishedHistories</span> {{couponPublishedHistories.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.publishedName')">Published Name</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.publishedName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.totalPublishedNum')">Total Published Num</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.totalPublishedNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.oneThousandNum')">One Thousand Num</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.oneThousandNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.threeThousandNum')">Three Thousand Num</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.threeThousandNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.fiveThousandNum')">Five Thousand Num</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.fiveThousandNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.sevenThousandNum')">Seven Thousand Num</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.sevenThousandNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.tenThousandNum')">Ten Thousand Num</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.tenThousandNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.autoPublishedNum')">Auto Published Num</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.autoPublishedNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.totalPublishedPrice')">Total Published Price</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.totalPublishedPrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.publishedDt')">Published Dt</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.publishedDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.expireDt')">Expire Dt</span>
                    </dt>
                    <dd>
                        <span>{{couponPublishedHistories.expireDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.couponPublishedHistories.CouponPublishedHistoriesState')">Coupon Published Histories State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.CouponPublishedHistoriesState.' + couponPublishedHistories.CouponPublishedHistoriesState)">{{couponPublishedHistories.CouponPublishedHistoriesState}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="couponPublishedHistories.id" :to="{name: 'CouponPublishedHistoriesEdit', params: {couponPublishedHistoriesId: couponPublishedHistories.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./coupon-published-histories-details.component.ts">
</script>
