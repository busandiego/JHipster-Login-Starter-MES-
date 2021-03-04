<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.coupon.home.createOrEditLabel" v-text="$t('hotelgaServerApp.coupon.home.createOrEditLabel')">Create or edit a Coupon</h2>
                <div>
                    <div class="form-group" v-if="coupon.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="coupon.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponName')" for="coupon-couponName">Coupon Name</label>
                        <input type="text" class="form-control" name="couponName" id="coupon-couponName"
                            :class="{'valid': !$v.coupon.couponName.$invalid, 'invalid': $v.coupon.couponName.$invalid }" v-model="$v.coupon.couponName.$model"  required/>
                        <div v-if="$v.coupon.couponName.$anyDirty && $v.coupon.couponName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.coupon.couponName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponType')" for="coupon-couponType">Coupon Type</label>
                        <select class="form-control" name="couponType" :class="{'valid': !$v.coupon.couponType.$invalid, 'invalid': $v.coupon.couponType.$invalid }" v-model="$v.coupon.couponType.$model" id="coupon-couponType"  required>
                            <option value="AFFILIATECOUPON" v-bind:label="$t('hotelgaServerApp.CouponType.AFFILIATECOUPON')">AFFILIATECOUPON</option>
                            <option value="ABSOLUTECOUPON" v-bind:label="$t('hotelgaServerApp.CouponType.ABSOLUTECOUPON')">ABSOLUTECOUPON</option>
                        </select>
                        <div v-if="$v.coupon.couponType.$anyDirty && $v.coupon.couponType.$invalid">
                            <small class="form-text text-danger" v-if="!$v.coupon.couponType.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponAllUse')" for="coupon-couponAllUse">Coupon All Use</label>
                        <input type="checkbox" class="form-check" name="couponAllUse" id="coupon-couponAllUse"
                            :class="{'valid': !$v.coupon.couponAllUse.$invalid, 'invalid': $v.coupon.couponAllUse.$invalid }" v-model="$v.coupon.couponAllUse.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUseAffiliateId')" for="coupon-couponUseAffiliateId">Coupon Use Affiliate Id</label>
                        <input type="number" class="form-control" name="couponUseAffiliateId" id="coupon-couponUseAffiliateId"
                            :class="{'valid': !$v.coupon.couponUseAffiliateId.$invalid, 'invalid': $v.coupon.couponUseAffiliateId.$invalid }" v-model.number="$v.coupon.couponUseAffiliateId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponAmountType')" for="coupon-couponAmountType">Coupon Amount Type</label>
                        <select class="form-control" name="couponAmountType" :class="{'valid': !$v.coupon.couponAmountType.$invalid, 'invalid': $v.coupon.couponAmountType.$invalid }" v-model="$v.coupon.couponAmountType.$model" id="coupon-couponAmountType" >
                            <option value="ONETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.ONETHOUSAND')">ONETHOUSAND</option>
                            <option value="THREETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.THREETHOUSAND')">THREETHOUSAND</option>
                            <option value="FIVETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.FIVETHOUSAND')">FIVETHOUSAND</option>
                            <option value="SEVENTHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.SEVENTHOUSAND')">SEVENTHOUSAND</option>
                            <option value="TENTHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.TENTHOUSAND')">TENTHOUSAND</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponDuplication')" for="coupon-couponDuplication">Coupon Duplication</label>
                        <input type="checkbox" class="form-check" name="couponDuplication" id="coupon-couponDuplication"
                            :class="{'valid': !$v.coupon.couponDuplication.$invalid, 'invalid': $v.coupon.couponDuplication.$invalid }" v-model="$v.coupon.couponDuplication.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponAutoPublish')" for="coupon-couponAutoPublish">Coupon Auto Publish</label>
                        <input type="checkbox" class="form-check" name="couponAutoPublish" id="coupon-couponAutoPublish"
                            :class="{'valid': !$v.coupon.couponAutoPublish.$invalid, 'invalid': $v.coupon.couponAutoPublish.$invalid }" v-model="$v.coupon.couponAutoPublish.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUseTypeLimit')" for="coupon-couponUseTypeLimit">Coupon Use Type Limit</label>
                        <input type="checkbox" class="form-check" name="couponUseTypeLimit" id="coupon-couponUseTypeLimit"
                            :class="{'valid': !$v.coupon.couponUseTypeLimit.$invalid, 'invalid': $v.coupon.couponUseTypeLimit.$invalid }" v-model="$v.coupon.couponUseTypeLimit.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUseType')" for="coupon-couponUseType">Coupon Use Type</label>
                        <select class="form-control" name="couponUseType" :class="{'valid': !$v.coupon.couponUseType.$invalid, 'invalid': $v.coupon.couponUseType.$invalid }" v-model="$v.coupon.couponUseType.$model" id="coupon-couponUseType" >
                            <option value="DAYUSE" v-bind:label="$t('hotelgaServerApp.CouponUseType.DAYUSE')">DAYUSE</option>
                            <option value="FULLRENT" v-bind:label="$t('hotelgaServerApp.CouponUseType.FULLRENT')">FULLRENT</option>
                            <option value="RELAYRENT" v-bind:label="$t('hotelgaServerApp.CouponUseType.RELAYRENT')">RELAYRENT</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUsePriceLimit')" for="coupon-couponUsePriceLimit">Coupon Use Price Limit</label>
                        <input type="checkbox" class="form-check" name="couponUsePriceLimit" id="coupon-couponUsePriceLimit"
                            :class="{'valid': !$v.coupon.couponUsePriceLimit.$invalid, 'invalid': $v.coupon.couponUsePriceLimit.$invalid }" v-model="$v.coupon.couponUsePriceLimit.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUsePrice')" for="coupon-couponUsePrice">Coupon Use Price</label>
                        <input type="number" class="form-control" name="couponUsePrice" id="coupon-couponUsePrice"
                            :class="{'valid': !$v.coupon.couponUsePrice.$invalid, 'invalid': $v.coupon.couponUsePrice.$invalid }" v-model.number="$v.coupon.couponUsePrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUseExpireLimit')" for="coupon-couponUseExpireLimit">Coupon Use Expire Limit</label>
                        <input type="checkbox" class="form-check" name="couponUseExpireLimit" id="coupon-couponUseExpireLimit"
                            :class="{'valid': !$v.coupon.couponUseExpireLimit.$invalid, 'invalid': $v.coupon.couponUseExpireLimit.$invalid }" v-model="$v.coupon.couponUseExpireLimit.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUseExpireMonth')" for="coupon-couponUseExpireMonth">Coupon Use Expire Month</label>
                        <input type="number" class="form-control" name="couponUseExpireMonth" id="coupon-couponUseExpireMonth"
                            :class="{'valid': !$v.coupon.couponUseExpireMonth.$invalid, 'invalid': $v.coupon.couponUseExpireMonth.$invalid }" v-model.number="$v.coupon.couponUseExpireMonth.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponCreateDt')" for="coupon-couponCreateDt">Coupon Create Dt</label>
                        <div class="d-flex">
                            <input id="coupon-couponCreateDt" type="datetime-local" class="form-control" name="couponCreateDt" :class="{'valid': !$v.coupon.couponCreateDt.$invalid, 'invalid': $v.coupon.couponCreateDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.coupon.couponCreateDt.$model)"
                            @change="updateZonedDateTimeField('couponCreateDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponUpdateDt')" for="coupon-couponUpdateDt">Coupon Update Dt</label>
                        <div class="d-flex">
                            <input id="coupon-couponUpdateDt" type="datetime-local" class="form-control" name="couponUpdateDt" :class="{'valid': !$v.coupon.couponUpdateDt.$invalid, 'invalid': $v.coupon.couponUpdateDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.coupon.couponUpdateDt.$model)"
                            @change="updateZonedDateTimeField('couponUpdateDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponCurrentPublishedDt')" for="coupon-couponCurrentPublishedDt">Coupon Current Published Dt</label>
                        <div class="d-flex">
                            <input id="coupon-couponCurrentPublishedDt" type="datetime-local" class="form-control" name="couponCurrentPublishedDt" :class="{'valid': !$v.coupon.couponCurrentPublishedDt.$invalid, 'invalid': $v.coupon.couponCurrentPublishedDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.coupon.couponCurrentPublishedDt.$model)"
                            @change="updateZonedDateTimeField('couponCurrentPublishedDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.coupon.couponState')" for="coupon-couponState">Coupon State</label>
                        <select class="form-control" name="couponState" :class="{'valid': !$v.coupon.couponState.$invalid, 'invalid': $v.coupon.couponState.$invalid }" v-model="$v.coupon.couponState.$model" id="coupon-couponState"  required>
                            <option value="NORMAL" v-bind:label="$t('hotelgaServerApp.StateCoupon.NORMAL')">NORMAL</option>
                            <option value="ABNORMAL" v-bind:label="$t('hotelgaServerApp.StateCoupon.ABNORMAL')">ABNORMAL</option>
                            <option value="DELETE" v-bind:label="$t('hotelgaServerApp.StateCoupon.DELETE')">DELETE</option>
                        </select>
                        <div v-if="$v.coupon.couponState.$anyDirty && $v.coupon.couponState.$invalid">
                            <small class="form-text text-danger" v-if="!$v.coupon.couponState.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.coupon.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./coupon-update.component.ts">
</script>
