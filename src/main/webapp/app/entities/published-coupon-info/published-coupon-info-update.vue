<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.publishedCouponInfo.home.createOrEditLabel" v-text="$t('hotelgaServerApp.publishedCouponInfo.home.createOrEditLabel')">Create or edit a PublishedCouponInfo</h2>
                <div>
                    <div class="form-group" v-if="publishedCouponInfo.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="publishedCouponInfo.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponName')" for="published-coupon-info-publishedCouponName">Published Coupon Name</label>
                        <input type="text" class="form-control" name="publishedCouponName" id="published-coupon-info-publishedCouponName"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponName.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponName.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponName.$model"  required/>
                        <div v-if="$v.publishedCouponInfo.publishedCouponName.$anyDirty && $v.publishedCouponInfo.publishedCouponName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.publishedCouponInfo.publishedCouponName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponType')" for="published-coupon-info-publishedCouponType">Published Coupon Type</label>
                        <select class="form-control" name="publishedCouponType" :class="{'valid': !$v.publishedCouponInfo.publishedCouponType.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponType.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponType.$model" id="published-coupon-info-publishedCouponType"  required>
                            <option value="AFFILIATECOUPON" v-bind:label="$t('hotelgaServerApp.CouponType.AFFILIATECOUPON')">AFFILIATECOUPON</option>
                            <option value="ABSOLUTECOUPON" v-bind:label="$t('hotelgaServerApp.CouponType.ABSOLUTECOUPON')">ABSOLUTECOUPON</option>
                        </select>
                        <div v-if="$v.publishedCouponInfo.publishedCouponType.$anyDirty && $v.publishedCouponInfo.publishedCouponType.$invalid">
                            <small class="form-text text-danger" v-if="!$v.publishedCouponInfo.publishedCouponType.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAllUse')" for="published-coupon-info-publishedCouponAllUse">Published Coupon All Use</label>
                        <input type="checkbox" class="form-check" name="publishedCouponAllUse" id="published-coupon-info-publishedCouponAllUse"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponAllUse.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponAllUse.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponAllUse.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseAffiliateId')" for="published-coupon-info-publishedCouponUseAffiliateId">Published Coupon Use Affiliate Id</label>
                        <input type="number" class="form-control" name="publishedCouponUseAffiliateId" id="published-coupon-info-publishedCouponUseAffiliateId"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponUseAffiliateId.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUseAffiliateId.$invalid }" v-model.number="$v.publishedCouponInfo.publishedCouponUseAffiliateId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAmountType')" for="published-coupon-info-publishedCouponAmountType">Published Coupon Amount Type</label>
                        <select class="form-control" name="publishedCouponAmountType" :class="{'valid': !$v.publishedCouponInfo.publishedCouponAmountType.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponAmountType.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponAmountType.$model" id="published-coupon-info-publishedCouponAmountType" >
                            <option value="ONETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.ONETHOUSAND')">ONETHOUSAND</option>
                            <option value="THREETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.THREETHOUSAND')">THREETHOUSAND</option>
                            <option value="FIVETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.FIVETHOUSAND')">FIVETHOUSAND</option>
                            <option value="SEVENTHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.SEVENTHOUSAND')">SEVENTHOUSAND</option>
                            <option value="TENTHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.TENTHOUSAND')">TENTHOUSAND</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponDuplication')" for="published-coupon-info-publishedCouponDuplication">Published Coupon Duplication</label>
                        <input type="checkbox" class="form-check" name="publishedCouponDuplication" id="published-coupon-info-publishedCouponDuplication"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponDuplication.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponDuplication.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponDuplication.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAutoPublish')" for="published-coupon-info-publishedCouponAutoPublish">Published Coupon Auto Publish</label>
                        <input type="checkbox" class="form-check" name="publishedCouponAutoPublish" id="published-coupon-info-publishedCouponAutoPublish"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponAutoPublish.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponAutoPublish.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponAutoPublish.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseTypeLimit')" for="published-coupon-info-publishedCouponUseTypeLimit">Published Coupon Use Type Limit</label>
                        <input type="checkbox" class="form-check" name="publishedCouponUseTypeLimit" id="published-coupon-info-publishedCouponUseTypeLimit"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponUseTypeLimit.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUseTypeLimit.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponUseTypeLimit.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseType')" for="published-coupon-info-publishedCouponUseType">Published Coupon Use Type</label>
                        <select class="form-control" name="publishedCouponUseType" :class="{'valid': !$v.publishedCouponInfo.publishedCouponUseType.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUseType.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponUseType.$model" id="published-coupon-info-publishedCouponUseType" >
                            <option value="DAYUSE" v-bind:label="$t('hotelgaServerApp.CouponUseType.DAYUSE')">DAYUSE</option>
                            <option value="FULLRENT" v-bind:label="$t('hotelgaServerApp.CouponUseType.FULLRENT')">FULLRENT</option>
                            <option value="RELAYRENT" v-bind:label="$t('hotelgaServerApp.CouponUseType.RELAYRENT')">RELAYRENT</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUsePriceLimit')" for="published-coupon-info-publishedCouponUsePriceLimit">Published Coupon Use Price Limit</label>
                        <input type="checkbox" class="form-check" name="publishedCouponUsePriceLimit" id="published-coupon-info-publishedCouponUsePriceLimit"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponUsePriceLimit.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUsePriceLimit.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponUsePriceLimit.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUsePrice')" for="published-coupon-info-publishedCouponUsePrice">Published Coupon Use Price</label>
                        <input type="number" class="form-control" name="publishedCouponUsePrice" id="published-coupon-info-publishedCouponUsePrice"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponUsePrice.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUsePrice.$invalid }" v-model.number="$v.publishedCouponInfo.publishedCouponUsePrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseExpireLimit')" for="published-coupon-info-publishedCouponUseExpireLimit">Published Coupon Use Expire Limit</label>
                        <input type="checkbox" class="form-check" name="publishedCouponUseExpireLimit" id="published-coupon-info-publishedCouponUseExpireLimit"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponUseExpireLimit.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUseExpireLimit.$invalid }" v-model="$v.publishedCouponInfo.publishedCouponUseExpireLimit.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUseExpireMonth')" for="published-coupon-info-publishedCouponUseExpireMonth">Published Coupon Use Expire Month</label>
                        <input type="number" class="form-control" name="publishedCouponUseExpireMonth" id="published-coupon-info-publishedCouponUseExpireMonth"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponUseExpireMonth.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUseExpireMonth.$invalid }" v-model.number="$v.publishedCouponInfo.publishedCouponUseExpireMonth.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponCreateDt')" for="published-coupon-info-publishedCouponCreateDt">Published Coupon Create Dt</label>
                        <div class="d-flex">
                            <input id="published-coupon-info-publishedCouponCreateDt" type="datetime-local" class="form-control" name="publishedCouponCreateDt" :class="{'valid': !$v.publishedCouponInfo.publishedCouponCreateDt.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponCreateDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.publishedCouponInfo.publishedCouponCreateDt.$model)"
                            @change="updateZonedDateTimeField('publishedCouponCreateDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponUpdateDt')" for="published-coupon-info-publishedCouponUpdateDt">Published Coupon Update Dt</label>
                        <div class="d-flex">
                            <input id="published-coupon-info-publishedCouponUpdateDt" type="datetime-local" class="form-control" name="publishedCouponUpdateDt" :class="{'valid': !$v.publishedCouponInfo.publishedCouponUpdateDt.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponUpdateDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.publishedCouponInfo.publishedCouponUpdateDt.$model)"
                            @change="updateZonedDateTimeField('publishedCouponUpdateDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponCurrentPublishedDt')" for="published-coupon-info-publishedCouponCurrentPublishedDt">Published Coupon Current Published Dt</label>
                        <div class="d-flex">
                            <input id="published-coupon-info-publishedCouponCurrentPublishedDt" type="datetime-local" class="form-control" name="publishedCouponCurrentPublishedDt" :class="{'valid': !$v.publishedCouponInfo.publishedCouponCurrentPublishedDt.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponCurrentPublishedDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.publishedCouponInfo.publishedCouponCurrentPublishedDt.$model)"
                            @change="updateZonedDateTimeField('publishedCouponCurrentPublishedDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponAmountNum')" for="published-coupon-info-publishedCouponAmountNum">Published Coupon Amount Num</label>
                        <input type="number" class="form-control" name="publishedCouponAmountNum" id="published-coupon-info-publishedCouponAmountNum"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponAmountNum.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponAmountNum.$invalid }" v-model.number="$v.publishedCouponInfo.publishedCouponAmountNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.publishedCouponSoldNum')" for="published-coupon-info-publishedCouponSoldNum">Published Coupon Sold Num</label>
                        <input type="number" class="form-control" name="publishedCouponSoldNum" id="published-coupon-info-publishedCouponSoldNum"
                            :class="{'valid': !$v.publishedCouponInfo.publishedCouponSoldNum.$invalid, 'invalid': $v.publishedCouponInfo.publishedCouponSoldNum.$invalid }" v-model.number="$v.publishedCouponInfo.publishedCouponSoldNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.couponState')" for="published-coupon-info-couponState">Coupon State</label>
                        <select class="form-control" name="couponState" :class="{'valid': !$v.publishedCouponInfo.couponState.$invalid, 'invalid': $v.publishedCouponInfo.couponState.$invalid }" v-model="$v.publishedCouponInfo.couponState.$model" id="published-coupon-info-couponState"  required>
                            <option value="NORMAL" v-bind:label="$t('hotelgaServerApp.StateCoupon.NORMAL')">NORMAL</option>
                            <option value="ABNORMAL" v-bind:label="$t('hotelgaServerApp.StateCoupon.ABNORMAL')">ABNORMAL</option>
                            <option value="DELETE" v-bind:label="$t('hotelgaServerApp.StateCoupon.DELETE')">DELETE</option>
                        </select>
                        <div v-if="$v.publishedCouponInfo.couponState.$anyDirty && $v.publishedCouponInfo.couponState.$invalid">
                            <small class="form-text text-danger" v-if="!$v.publishedCouponInfo.couponState.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponInfo.couponPublishedHistoriesId')" for="published-coupon-info-couponPublishedHistoriesId">Coupon Published Histories Id</label>
                        <input type="number" class="form-control" name="couponPublishedHistoriesId" id="published-coupon-info-couponPublishedHistoriesId"
                            :class="{'valid': !$v.publishedCouponInfo.couponPublishedHistoriesId.$invalid, 'invalid': $v.publishedCouponInfo.couponPublishedHistoriesId.$invalid }" v-model.number="$v.publishedCouponInfo.couponPublishedHistoriesId.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.publishedCouponInfo.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./published-coupon-info-update.component.ts">
</script>
