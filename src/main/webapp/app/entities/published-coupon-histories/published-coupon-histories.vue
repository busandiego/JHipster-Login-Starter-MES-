<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.publishedCouponHistories.home.title')" id="published-coupon-histories-heading">Published Coupon Histories</span>
            <router-link :to="{name: 'PublishedCouponHistoriesCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-published-coupon-histories">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.publishedCouponHistories.home.createLabel')">
                    Create a new Published Coupon Histories
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
        <div class="alert alert-warning" v-if="!isFetching && publishedCouponHistories && publishedCouponHistories.length === 0">
            <span v-text="$t('hotelgaServerApp.publishedCouponHistories.home.notFound')">No publishedCouponHistories found</span>
        </div>
        <div class="table-responsive" v-if="publishedCouponHistories && publishedCouponHistories.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedUniqCode')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedUniqCode')">Published Uniq Code</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponAmountType')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponAmountType')">Published Coupon Amount Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('useDt')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.useDt')">Use Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponAllUse')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponAllUse')">Published Coupon All Use</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedCouponUseAffiliateId')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponUseAffiliateId')">Published Coupon Use Affiliate Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedDt')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedDt')">Published Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('useCheck')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.useCheck')">Use Check</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponPublishedHistoriesId')"><span v-text="$t('hotelgaServerApp.publishedCouponHistories.couponPublishedHistoriesId')">Coupon Published Histories Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="publishedCouponHistories in publishedCouponHistories"
                    :key="publishedCouponHistories.id">
                    <td>
                        <router-link :to="{name: 'PublishedCouponHistoriesView', params: {publishedCouponHistoriesId: publishedCouponHistories.id}}">{{publishedCouponHistories.id}}</router-link>
                    </td>
                    <td>{{publishedCouponHistories.publishedUniqCode}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponAmountType.' + publishedCouponHistories.publishedCouponAmountType)">{{publishedCouponHistories.publishedCouponAmountType}}</td>
                    <td>{{publishedCouponHistories.useDt | formatDate}}</td>
                    <td>{{publishedCouponHistories.publishedCouponAllUse}}</td>
                    <td>{{publishedCouponHistories.publishedCouponUseAffiliateId}}</td>
                    <td>{{publishedCouponHistories.publishedDt | formatDate}}</td>
                    <td>{{publishedCouponHistories.useCheck}}</td>
                    <td>{{publishedCouponHistories.couponPublishedHistoriesId}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'PublishedCouponHistoriesView', params: {publishedCouponHistoriesId: publishedCouponHistories.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'PublishedCouponHistoriesEdit', params: {publishedCouponHistoriesId: publishedCouponHistories.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(publishedCouponHistories)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.publishedCouponHistories.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-publishedCouponHistories-heading" v-bind:title="$t('hotelgaServerApp.publishedCouponHistories.delete.question')">Are you sure you want to delete this Published Coupon Histories?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-publishedCouponHistories" v-text="$t('entity.action.delete')" v-on:click="removePublishedCouponHistories()">Delete</button>
            </div>
        </b-modal>
        <div v-show="publishedCouponHistories && publishedCouponHistories.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./published-coupon-histories.component.ts">
</script>
