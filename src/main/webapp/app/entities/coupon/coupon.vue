<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.coupon.home.title')" id="coupon-heading">Coupons</span>
            <router-link :to="{name: 'CouponCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-coupon">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.coupon.home.createLabel')">
                    Create a new Coupon
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
        <div class="alert alert-warning" v-if="!isFetching && coupons && coupons.length === 0">
            <span v-text="$t('hotelgaServerApp.coupon.home.notFound')">No coupons found</span>
        </div>
        <div class="table-responsive" v-if="coupons && coupons.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponName')"><span v-text="$t('hotelgaServerApp.coupon.couponName')">Coupon Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponType')"><span v-text="$t('hotelgaServerApp.coupon.couponType')">Coupon Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponAllUse')"><span v-text="$t('hotelgaServerApp.coupon.couponAllUse')">Coupon All Use</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUseAffiliateId')"><span v-text="$t('hotelgaServerApp.coupon.couponUseAffiliateId')">Coupon Use Affiliate Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponAmountType')"><span v-text="$t('hotelgaServerApp.coupon.couponAmountType')">Coupon Amount Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponDuplication')"><span v-text="$t('hotelgaServerApp.coupon.couponDuplication')">Coupon Duplication</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponAutoPublish')"><span v-text="$t('hotelgaServerApp.coupon.couponAutoPublish')">Coupon Auto Publish</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUseTypeLimit')"><span v-text="$t('hotelgaServerApp.coupon.couponUseTypeLimit')">Coupon Use Type Limit</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUseType')"><span v-text="$t('hotelgaServerApp.coupon.couponUseType')">Coupon Use Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUsePriceLimit')"><span v-text="$t('hotelgaServerApp.coupon.couponUsePriceLimit')">Coupon Use Price Limit</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUsePrice')"><span v-text="$t('hotelgaServerApp.coupon.couponUsePrice')">Coupon Use Price</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUseExpireLimit')"><span v-text="$t('hotelgaServerApp.coupon.couponUseExpireLimit')">Coupon Use Expire Limit</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUseExpireMonth')"><span v-text="$t('hotelgaServerApp.coupon.couponUseExpireMonth')">Coupon Use Expire Month</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponCreateDt')"><span v-text="$t('hotelgaServerApp.coupon.couponCreateDt')">Coupon Create Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponUpdateDt')"><span v-text="$t('hotelgaServerApp.coupon.couponUpdateDt')">Coupon Update Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponCurrentPublishedDt')"><span v-text="$t('hotelgaServerApp.coupon.couponCurrentPublishedDt')">Coupon Current Published Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponState')"><span v-text="$t('hotelgaServerApp.coupon.couponState')">Coupon State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="coupon in coupons"
                    :key="coupon.id">
                    <td>
                        <router-link :to="{name: 'CouponView', params: {couponId: coupon.id}}">{{coupon.id}}</router-link>
                    </td>
                    <td>{{coupon.couponName}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponType.' + coupon.couponType)">{{coupon.couponType}}</td>
                    <td>{{coupon.couponAllUse}}</td>
                    <td>{{coupon.couponUseAffiliateId}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponAmountType.' + coupon.couponAmountType)">{{coupon.couponAmountType}}</td>
                    <td>{{coupon.couponDuplication}}</td>
                    <td>{{coupon.couponAutoPublish}}</td>
                    <td>{{coupon.couponUseTypeLimit}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponUseType.' + coupon.couponUseType)">{{coupon.couponUseType}}</td>
                    <td>{{coupon.couponUsePriceLimit}}</td>
                    <td>{{coupon.couponUsePrice}}</td>
                    <td>{{coupon.couponUseExpireLimit}}</td>
                    <td>{{coupon.couponUseExpireMonth}}</td>
                    <td>{{coupon.couponCreateDt | formatDate}}</td>
                    <td>{{coupon.couponUpdateDt | formatDate}}</td>
                    <td>{{coupon.couponCurrentPublishedDt | formatDate}}</td>
                    <td v-text="$t('hotelgaServerApp.StateCoupon.' + coupon.couponState)">{{coupon.couponState}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'CouponView', params: {couponId: coupon.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'CouponEdit', params: {couponId: coupon.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(coupon)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.coupon.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-coupon-heading" v-bind:title="$t('hotelgaServerApp.coupon.delete.question')">Are you sure you want to delete this Coupon?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-coupon" v-text="$t('entity.action.delete')" v-on:click="removeCoupon()">Delete</button>
            </div>
        </b-modal>
        <div v-show="coupons && coupons.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./coupon.component.ts">
</script>
