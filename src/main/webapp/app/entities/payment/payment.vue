<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.payment.home.title')" id="payment-heading">Payments</span>
            <router-link :to="{name: 'PaymentCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-payment">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.payment.home.createLabel')">
                    Create a new Payment
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
        <div class="alert alert-warning" v-if="!isFetching && payments && payments.length === 0">
            <span v-text="$t('hotelgaServerApp.payment.home.notFound')">No payments found</span>
        </div>
        <div class="table-responsive" v-if="payments && payments.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('sellingPrice')"><span v-text="$t('hotelgaServerApp.payment.sellingPrice')">Selling Price</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('commission')"><span v-text="$t('hotelgaServerApp.payment.commission')">Commission</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('paymentMoney')"><span v-text="$t('hotelgaServerApp.payment.paymentMoney')">Payment Money</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('paymentType')"><span v-text="$t('hotelgaServerApp.payment.paymentType')">Payment Type</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('paymentDt')"><span v-text="$t('hotelgaServerApp.payment.paymentDt')">Payment Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('couponDiscount')"><span v-text="$t('hotelgaServerApp.payment.couponDiscount')">Coupon Discount</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('transactionNum')"><span v-text="$t('hotelgaServerApp.payment.transactionNum')">Transaction Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('paymentMethod')"><span v-text="$t('hotelgaServerApp.payment.paymentMethod')">Payment Method</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('remark')"><span v-text="$t('hotelgaServerApp.payment.remark')">Remark</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('reservationId')"><span v-text="$t('hotelgaServerApp.payment.reservationId')">Reservation Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('paymentState')"><span v-text="$t('hotelgaServerApp.payment.paymentState')">Payment State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="payment in payments"
                    :key="payment.id">
                    <td>
                        <router-link :to="{name: 'PaymentView', params: {paymentId: payment.id}}">{{payment.id}}</router-link>
                    </td>
                    <td>{{payment.sellingPrice}}</td>
                    <td>{{payment.commission}}</td>
                    <td>{{payment.paymentMoney}}</td>
                    <td>{{payment.paymentType}}</td>
                    <td>{{payment.paymentDt | formatDate}}</td>
                    <td>{{payment.couponDiscount}}</td>
                    <td>{{payment.transactionNum}}</td>
                    <td>{{payment.paymentMethod}}</td>
                    <td>{{payment.remark}}</td>
                    <td>{{payment.reservationId}}</td>
                    <td v-text="$t('hotelgaServerApp.StatePayment.' + payment.paymentState)">{{payment.paymentState}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'PaymentView', params: {paymentId: payment.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'PaymentEdit', params: {paymentId: payment.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(payment)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.payment.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-payment-heading" v-bind:title="$t('hotelgaServerApp.payment.delete.question')">Are you sure you want to delete this Payment?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-payment" v-text="$t('entity.action.delete')" v-on:click="removePayment()">Delete</button>
            </div>
        </b-modal>
        <div v-show="payments && payments.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./payment.component.ts">
</script>
