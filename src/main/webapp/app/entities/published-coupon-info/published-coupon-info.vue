<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.publishedCouponInfo.home.title')" id="published-coupon-info-heading">Published Coupon Infos</span>
            <router-link :to="{name: 'PublishedCouponInfoCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-published-coupon-info">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.publishedCouponInfo.home.createLabel')">
                    Create a new Published Coupon Info
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
        <div class="alert alert-warning" v-if="!isFetching && publishedCouponInfos && publishedCouponInfos.length === 0">
            <span v-text="$t('hotelgaServerApp.publishedCouponInfo.home.notFound')">No publishedCouponInfos found</span>
        </div>
        <div class="table-responsive" v-if="publishedCouponInfos && publishedCouponInfos.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponName')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponName')">Published Coupon Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponType')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponType')">Published Coupon Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponAllUse')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAllUse')">Published Coupon All Use</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUseAffiliateId')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseAffiliateId')">Published Coupon Use Affiliate Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponAmountType')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAmountType')">Published Coupon Amount Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponDuplication')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponDuplication')">Published Coupon Duplication</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponAutoPublish')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAutoPublish')">Published Coupon Auto Publish</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUseTypeLimit')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseTypeLimit')">Published Coupon Use Type Limit</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUseType')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseType')">Published Coupon Use Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUsePriceLimit')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUsePriceLimit')">Published Coupon Use Price Limit</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUsePrice')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUsePrice')">Published Coupon Use Price</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUseExpireLimit')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseExpireLimit')">Published Coupon Use Expire Limit</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUseExpireMonth')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseExpireMonth')">Published Coupon Use Expire Month</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponCreateDt')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponCreateDt')">Published Coupon Create Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUpdateDt')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUpdateDt')">Published Coupon Update Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponCurrentPublishedDt')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponCurrentPublishedDt')">Published Coupon Current Published Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponAmountNum')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAmountNum')">Published Coupon Amount Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponSoldNum')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponSoldNum')">Published Coupon Sold Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponState')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.couponState')">Coupon State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponPublishedHistoriesId')"><span v-text="$t('hotelgaServerApp.publishedCouponInfo.couponPublishedHistoriesId')">Coupon Published Histories Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="publishedCouponInfo in publishedCouponInfos"
                    :key="publishedCouponInfo.id">
                    <td>
                        <router-link :to="{name: 'PublishedCouponInfoView', params: {publishedCouponInfoId: publishedCouponInfo.id}}">{{publishedCouponInfo.id}}</router-link>
                    </td>
                    <td>{{publishedCouponInfo.publishedCouponName}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponType.' + publishedCouponInfo.publishedCouponType)">{{publishedCouponInfo.publishedCouponType}}</td>
                    <td>{{publishedCouponInfo.publishedCouponAllUse}}</td>
                    <td>{{publishedCouponInfo.publishedCouponUseAffiliateId}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponAmountType.' + publishedCouponInfo.publishedCouponAmountType)">{{publishedCouponInfo.publishedCouponAmountType}}</td>
                    <td>{{publishedCouponInfo.publishedCouponDuplication}}</td>
                    <td>{{publishedCouponInfo.publishedCouponAutoPublish}}</td>
                    <td>{{publishedCouponInfo.publishedCouponUseTypeLimit}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponUseType.' + publishedCouponInfo.publishedCouponUseType)">{{publishedCouponInfo.publishedCouponUseType}}</td>
                    <td>{{publishedCouponInfo.publishedCouponUsePriceLimit}}</td>
                    <td>{{publishedCouponInfo.publishedCouponUsePrice}}</td>
                    <td>{{publishedCouponInfo.publishedCouponUseExpireLimit}}</td>
                    <td>{{publishedCouponInfo.publishedCouponUseExpireMonth}}</td>
                    <td>{{publishedCouponInfo.publishedCouponCreateDt | formatDate}}</td>
                    <td>{{publishedCouponInfo.publishedCouponUpdateDt | formatDate}}</td>
                    <td>{{publishedCouponInfo.publishedCouponCurrentPublishedDt | formatDate}}</td>
                    <td>{{publishedCouponInfo.publishedCouponAmountNum}}</td>
                    <td>{{publishedCouponInfo.publishedCouponSoldNum}}</td>
                    <td v-text="$t('hotelgaServerApp.StateCoupon.' + publishedCouponInfo.couponState)">{{publishedCouponInfo.couponState}}</td>
                    <td>{{publishedCouponInfo.couponPublishedHistoriesId}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'PublishedCouponInfoView', params: {publishedCouponInfoId: publishedCouponInfo.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'PublishedCouponInfoEdit', params: {publishedCouponInfoId: publishedCouponInfo.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(publishedCouponInfo)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.publishedCouponInfo.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-publishedCouponInfo-heading" v-bind:title="$t('hotelgaServerApp.publishedCouponInfo.delete.question')">Are you sure you want to delete this Published Coupon Info?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-publishedCouponInfo" v-text="$t('entity.action.delete')" v-on:click="removePublishedCouponInfo()">Delete</button>
            </div>
        </b-modal>
        <div v-show="publishedCouponInfos && publishedCouponInfos.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./published-coupon-info.component.ts">
</script>
