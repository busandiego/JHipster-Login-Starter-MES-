<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.couponPublishedHistories.home.title')" id="coupon-published-histories-heading">Coupon Published Histories</span>
            <router-link :to="{name: 'CouponPublishedHistoriesCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-coupon-published-histories">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.couponPublishedHistories.home.createLabel')">
                    Create a new Coupon Published Histories
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
        <div class="alert alert-warning" v-if="!isFetching && couponPublishedHistories && couponPublishedHistories.length === 0">
            <span v-text="$t('hotelgaServerApp.couponPublishedHistories.home.notFound')">No couponPublishedHistories found</span>
        </div>
        <div class="table-responsive" v-if="couponPublishedHistories && couponPublishedHistories.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedName')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.publishedName')">Published Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('totalPublishedNum')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.totalPublishedNum')">Total Published Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('oneThousandNum')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.oneThousandNum')">One Thousand Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('threeThousandNum')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.threeThousandNum')">Three Thousand Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('fiveThousandNum')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.fiveThousandNum')">Five Thousand Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sevenThousandNum')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.sevenThousandNum')">Seven Thousand Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('tenThousandNum')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.tenThousandNum')">Ten Thousand Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('autoPublishedNum')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.autoPublishedNum')">Auto Published Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('totalPublishedPrice')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.totalPublishedPrice')">Total Published Price</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('publishedDt')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.publishedDt')">Published Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('expireDt')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.expireDt')">Expire Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('CouponPublishedHistoriesState')"><span v-text="$t('hotelgaServerApp.couponPublishedHistories.CouponPublishedHistoriesState')">Coupon Published Histories State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="couponPublishedHistories in couponPublishedHistories"
                    :key="couponPublishedHistories.id">
                    <td>
                        <router-link :to="{name: 'CouponPublishedHistoriesView', params: {couponPublishedHistoriesId: couponPublishedHistories.id}}">{{couponPublishedHistories.id}}</router-link>
                    </td>
                    <td>{{couponPublishedHistories.publishedName}}</td>
                    <td>{{couponPublishedHistories.totalPublishedNum}}</td>
                    <td>{{couponPublishedHistories.oneThousandNum}}</td>
                    <td>{{couponPublishedHistories.threeThousandNum}}</td>
                    <td>{{couponPublishedHistories.fiveThousandNum}}</td>
                    <td>{{couponPublishedHistories.sevenThousandNum}}</td>
                    <td>{{couponPublishedHistories.tenThousandNum}}</td>
                    <td>{{couponPublishedHistories.autoPublishedNum}}</td>
                    <td>{{couponPublishedHistories.totalPublishedPrice}}</td>
                    <td>{{couponPublishedHistories.publishedDt | formatDate}}</td>
                    <td>{{couponPublishedHistories.expireDt | formatDate}}</td>
                    <td v-text="$t('hotelgaServerApp.CouponPublishedHistoriesState.' + couponPublishedHistories.CouponPublishedHistoriesState)">{{couponPublishedHistories.CouponPublishedHistoriesState}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'CouponPublishedHistoriesView', params: {couponPublishedHistoriesId: couponPublishedHistories.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'CouponPublishedHistoriesEdit', params: {couponPublishedHistoriesId: couponPublishedHistories.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(couponPublishedHistories)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.couponPublishedHistories.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-couponPublishedHistories-heading" v-bind:title="$t('hotelgaServerApp.couponPublishedHistories.delete.question')">Are you sure you want to delete this Coupon Published Histories?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-couponPublishedHistories" v-text="$t('entity.action.delete')" v-on:click="removeCouponPublishedHistories()">Delete</button>
            </div>
        </b-modal>
        <div v-show="couponPublishedHistories && couponPublishedHistories.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./coupon-published-histories.component.ts">
</script>
