<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.publishedCouponHistories.home.createOrEditLabel" v-text="$t('hotelgaServerApp.publishedCouponHistories.home.createOrEditLabel')">Create or edit a PublishedCouponHistories</h2>
                <div>
                    <div class="form-group" v-if="publishedCouponHistories.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="publishedCouponHistories.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedUniqCode')" for="published-coupon-histories-publishedUniqCode">Published Uniq Code</label>
                        <input type="text" class="form-control" name="publishedUniqCode" id="published-coupon-histories-publishedUniqCode"
                            :class="{'valid': !$v.publishedCouponHistories.publishedUniqCode.$invalid, 'invalid': $v.publishedCouponHistories.publishedUniqCode.$invalid }" v-model="$v.publishedCouponHistories.publishedUniqCode.$model"  required/>
                        <div v-if="$v.publishedCouponHistories.publishedUniqCode.$anyDirty && $v.publishedCouponHistories.publishedUniqCode.$invalid">
                            <small class="form-text text-danger" v-if="!$v.publishedCouponHistories.publishedUniqCode.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponAmountType')" for="published-coupon-histories-publishedCouponAmountType">Published Coupon Amount Type</label>
                        <select class="form-control" name="publishedCouponAmountType" :class="{'valid': !$v.publishedCouponHistories.publishedCouponAmountType.$invalid, 'invalid': $v.publishedCouponHistories.publishedCouponAmountType.$invalid }" v-model="$v.publishedCouponHistories.publishedCouponAmountType.$model" id="published-coupon-histories-publishedCouponAmountType" >
                            <option value="ONETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.ONETHOUSAND')">ONETHOUSAND</option>
                            <option value="THREETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.THREETHOUSAND')">THREETHOUSAND</option>
                            <option value="FIVETHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.FIVETHOUSAND')">FIVETHOUSAND</option>
                            <option value="SEVENTHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.SEVENTHOUSAND')">SEVENTHOUSAND</option>
                            <option value="TENTHOUSAND" v-bind:label="$t('hotelgaServerApp.CouponAmountType.TENTHOUSAND')">TENTHOUSAND</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.useDt')" for="published-coupon-histories-useDt">Use Dt</label>
                        <div class="d-flex">
                            <input id="published-coupon-histories-useDt" type="datetime-local" class="form-control" name="useDt" :class="{'valid': !$v.publishedCouponHistories.useDt.$invalid, 'invalid': $v.publishedCouponHistories.useDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.publishedCouponHistories.useDt.$model)"
                            @change="updateZonedDateTimeField('useDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponAllUse')" for="published-coupon-histories-publishedCouponAllUse">Published Coupon All Use</label>
                        <input type="checkbox" class="form-check" name="publishedCouponAllUse" id="published-coupon-histories-publishedCouponAllUse"
                            :class="{'valid': !$v.publishedCouponHistories.publishedCouponAllUse.$invalid, 'invalid': $v.publishedCouponHistories.publishedCouponAllUse.$invalid }" v-model="$v.publishedCouponHistories.publishedCouponAllUse.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedCouponUseAffiliateId')" for="published-coupon-histories-publishedCouponUseAffiliateId">Published Coupon Use Affiliate Id</label>
                        <input type="number" class="form-control" name="publishedCouponUseAffiliateId" id="published-coupon-histories-publishedCouponUseAffiliateId"
                            :class="{'valid': !$v.publishedCouponHistories.publishedCouponUseAffiliateId.$invalid, 'invalid': $v.publishedCouponHistories.publishedCouponUseAffiliateId.$invalid }" v-model.number="$v.publishedCouponHistories.publishedCouponUseAffiliateId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.publishedDt')" for="published-coupon-histories-publishedDt">Published Dt</label>
                        <div class="d-flex">
                            <input id="published-coupon-histories-publishedDt" type="datetime-local" class="form-control" name="publishedDt" :class="{'valid': !$v.publishedCouponHistories.publishedDt.$invalid, 'invalid': $v.publishedCouponHistories.publishedDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.publishedCouponHistories.publishedDt.$model)"
                            @change="updateZonedDateTimeField('publishedDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.useCheck')" for="published-coupon-histories-useCheck">Use Check</label>
                        <input type="checkbox" class="form-check" name="useCheck" id="published-coupon-histories-useCheck"
                            :class="{'valid': !$v.publishedCouponHistories.useCheck.$invalid, 'invalid': $v.publishedCouponHistories.useCheck.$invalid }" v-model="$v.publishedCouponHistories.useCheck.$model"  required/>
                        <div v-if="$v.publishedCouponHistories.useCheck.$anyDirty && $v.publishedCouponHistories.useCheck.$invalid">
                            <small class="form-text text-danger" v-if="!$v.publishedCouponHistories.useCheck.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.publishedCouponHistories.couponPublishedHistoriesId')" for="published-coupon-histories-couponPublishedHistoriesId">Coupon Published Histories Id</label>
                        <input type="number" class="form-control" name="couponPublishedHistoriesId" id="published-coupon-histories-couponPublishedHistoriesId"
                            :class="{'valid': !$v.publishedCouponHistories.couponPublishedHistoriesId.$invalid, 'invalid': $v.publishedCouponHistories.couponPublishedHistoriesId.$invalid }" v-model.number="$v.publishedCouponHistories.couponPublishedHistoriesId.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.publishedCouponHistories.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./published-coupon-histories-update.component.ts">
</script>
