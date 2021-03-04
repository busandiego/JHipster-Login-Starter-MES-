<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.payment.home.createOrEditLabel" v-text="$t('hotelgaServerApp.payment.home.createOrEditLabel')">Create or edit a Payment</h2>
                <div>
                    <div class="form-group" v-if="payment.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="payment.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.sellingPrice')" for="payment-sellingPrice">Selling Price</label>
                        <input type="number" class="form-control" name="sellingPrice" id="payment-sellingPrice"
                            :class="{'valid': !$v.payment.sellingPrice.$invalid, 'invalid': $v.payment.sellingPrice.$invalid }" v-model.number="$v.payment.sellingPrice.$model"  required/>
                        <div v-if="$v.payment.sellingPrice.$anyDirty && $v.payment.sellingPrice.$invalid">
                            <small class="form-text text-danger" v-if="!$v.payment.sellingPrice.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.payment.sellingPrice.number" v-text="$t('entity.validation.number')">
                                This field should be a number.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.commission')" for="payment-commission">Commission</label>
                        <input type="number" class="form-control" name="commission" id="payment-commission"
                            :class="{'valid': !$v.payment.commission.$invalid, 'invalid': $v.payment.commission.$invalid }" v-model.number="$v.payment.commission.$model"  required/>
                        <div v-if="$v.payment.commission.$anyDirty && $v.payment.commission.$invalid">
                            <small class="form-text text-danger" v-if="!$v.payment.commission.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.payment.commission.number" v-text="$t('entity.validation.number')">
                                This field should be a number.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.paymentMoney')" for="payment-paymentMoney">Payment Money</label>
                        <input type="number" class="form-control" name="paymentMoney" id="payment-paymentMoney"
                            :class="{'valid': !$v.payment.paymentMoney.$invalid, 'invalid': $v.payment.paymentMoney.$invalid }" v-model.number="$v.payment.paymentMoney.$model"  required/>
                        <div v-if="$v.payment.paymentMoney.$anyDirty && $v.payment.paymentMoney.$invalid">
                            <small class="form-text text-danger" v-if="!$v.payment.paymentMoney.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.payment.paymentMoney.number" v-text="$t('entity.validation.number')">
                                This field should be a number.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.paymentType')" for="payment-paymentType">Payment Type</label>
                        <input type="text" class="form-control" name="paymentType" id="payment-paymentType"
                            :class="{'valid': !$v.payment.paymentType.$invalid, 'invalid': $v.payment.paymentType.$invalid }" v-model="$v.payment.paymentType.$model"  required/>
                        <div v-if="$v.payment.paymentType.$anyDirty && $v.payment.paymentType.$invalid">
                            <small class="form-text text-danger" v-if="!$v.payment.paymentType.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.paymentDt')" for="payment-paymentDt">Payment Dt</label>
                        <div class="d-flex">
                            <input id="payment-paymentDt" type="datetime-local" class="form-control" name="paymentDt" :class="{'valid': !$v.payment.paymentDt.$invalid, 'invalid': $v.payment.paymentDt.$invalid }"
                             required
                            :value="convertDateTimeFromServer($v.payment.paymentDt.$model)"
                            @change="updateZonedDateTimeField('paymentDt', $event)"/>
                        </div>
                        <div v-if="$v.payment.paymentDt.$anyDirty && $v.payment.paymentDt.$invalid">
                            <small class="form-text text-danger" v-if="!$v.payment.paymentDt.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.payment.paymentDt.ZonedDateTimelocal" v-text="$t('entity.validation.ZonedDateTimelocal')">
                                This field should be a date and time.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.couponDiscount')" for="payment-couponDiscount">Coupon Discount</label>
                        <input type="number" class="form-control" name="couponDiscount" id="payment-couponDiscount"
                            :class="{'valid': !$v.payment.couponDiscount.$invalid, 'invalid': $v.payment.couponDiscount.$invalid }" v-model.number="$v.payment.couponDiscount.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.transactionNum')" for="payment-transactionNum">Transaction Num</label>
                        <input type="text" class="form-control" name="transactionNum" id="payment-transactionNum"
                            :class="{'valid': !$v.payment.transactionNum.$invalid, 'invalid': $v.payment.transactionNum.$invalid }" v-model="$v.payment.transactionNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.paymentMethod')" for="payment-paymentMethod">Payment Method</label>
                        <input type="text" class="form-control" name="paymentMethod" id="payment-paymentMethod"
                            :class="{'valid': !$v.payment.paymentMethod.$invalid, 'invalid': $v.payment.paymentMethod.$invalid }" v-model="$v.payment.paymentMethod.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.remark')" for="payment-remark">Remark</label>
                        <input type="text" class="form-control" name="remark" id="payment-remark"
                            :class="{'valid': !$v.payment.remark.$invalid, 'invalid': $v.payment.remark.$invalid }" v-model="$v.payment.remark.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.reservationId')" for="payment-reservationId">Reservation Id</label>
                        <input type="number" class="form-control" name="reservationId" id="payment-reservationId"
                            :class="{'valid': !$v.payment.reservationId.$invalid, 'invalid': $v.payment.reservationId.$invalid }" v-model.number="$v.payment.reservationId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.payment.paymentState')" for="payment-paymentState">Payment State</label>
                        <select class="form-control" name="paymentState" :class="{'valid': !$v.payment.paymentState.$invalid, 'invalid': $v.payment.paymentState.$invalid }" v-model="$v.payment.paymentState.$model" id="payment-paymentState"  required>
                            <option value="NORMAL" v-bind:label="$t('hotelgaServerApp.StatePayment.NORMAL')">NORMAL</option>
                            <option value="ABNORMAL" v-bind:label="$t('hotelgaServerApp.StatePayment.ABNORMAL')">ABNORMAL</option>
                            <option value="DELETE" v-bind:label="$t('hotelgaServerApp.StatePayment.DELETE')">DELETE</option>
                        </select>
                        <div v-if="$v.payment.paymentState.$anyDirty && $v.payment.paymentState.$invalid">
                            <small class="form-text text-danger" v-if="!$v.payment.paymentState.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.payment.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./payment-update.component.ts">
</script>
