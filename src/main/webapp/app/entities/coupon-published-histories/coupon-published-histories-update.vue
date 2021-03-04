<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.couponPublishedHistories.home.createOrEditLabel" v-text="$t('hotelgaServerApp.couponPublishedHistories.home.createOrEditLabel')">Create or edit a CouponPublishedHistories</h2>
                <div>
                    <div class="form-group" v-if="couponPublishedHistories.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="couponPublishedHistories.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.publishedName')" for="coupon-published-histories-publishedName">Published Name</label>
                        <input type="text" class="form-control" name="publishedName" id="coupon-published-histories-publishedName"
                            :class="{'valid': !$v.couponPublishedHistories.publishedName.$invalid, 'invalid': $v.couponPublishedHistories.publishedName.$invalid }" v-model="$v.couponPublishedHistories.publishedName.$model"  required/>
                        <div v-if="$v.couponPublishedHistories.publishedName.$anyDirty && $v.couponPublishedHistories.publishedName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.couponPublishedHistories.publishedName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.totalPublishedNum')" for="coupon-published-histories-totalPublishedNum">Total Published Num</label>
                        <input type="number" class="form-control" name="totalPublishedNum" id="coupon-published-histories-totalPublishedNum"
                            :class="{'valid': !$v.couponPublishedHistories.totalPublishedNum.$invalid, 'invalid': $v.couponPublishedHistories.totalPublishedNum.$invalid }" v-model.number="$v.couponPublishedHistories.totalPublishedNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.oneThousandNum')" for="coupon-published-histories-oneThousandNum">One Thousand Num</label>
                        <input type="number" class="form-control" name="oneThousandNum" id="coupon-published-histories-oneThousandNum"
                            :class="{'valid': !$v.couponPublishedHistories.oneThousandNum.$invalid, 'invalid': $v.couponPublishedHistories.oneThousandNum.$invalid }" v-model.number="$v.couponPublishedHistories.oneThousandNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.threeThousandNum')" for="coupon-published-histories-threeThousandNum">Three Thousand Num</label>
                        <input type="number" class="form-control" name="threeThousandNum" id="coupon-published-histories-threeThousandNum"
                            :class="{'valid': !$v.couponPublishedHistories.threeThousandNum.$invalid, 'invalid': $v.couponPublishedHistories.threeThousandNum.$invalid }" v-model.number="$v.couponPublishedHistories.threeThousandNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.fiveThousandNum')" for="coupon-published-histories-fiveThousandNum">Five Thousand Num</label>
                        <input type="number" class="form-control" name="fiveThousandNum" id="coupon-published-histories-fiveThousandNum"
                            :class="{'valid': !$v.couponPublishedHistories.fiveThousandNum.$invalid, 'invalid': $v.couponPublishedHistories.fiveThousandNum.$invalid }" v-model.number="$v.couponPublishedHistories.fiveThousandNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.sevenThousandNum')" for="coupon-published-histories-sevenThousandNum">Seven Thousand Num</label>
                        <input type="number" class="form-control" name="sevenThousandNum" id="coupon-published-histories-sevenThousandNum"
                            :class="{'valid': !$v.couponPublishedHistories.sevenThousandNum.$invalid, 'invalid': $v.couponPublishedHistories.sevenThousandNum.$invalid }" v-model.number="$v.couponPublishedHistories.sevenThousandNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.tenThousandNum')" for="coupon-published-histories-tenThousandNum">Ten Thousand Num</label>
                        <input type="number" class="form-control" name="tenThousandNum" id="coupon-published-histories-tenThousandNum"
                            :class="{'valid': !$v.couponPublishedHistories.tenThousandNum.$invalid, 'invalid': $v.couponPublishedHistories.tenThousandNum.$invalid }" v-model.number="$v.couponPublishedHistories.tenThousandNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.autoPublishedNum')" for="coupon-published-histories-autoPublishedNum">Auto Published Num</label>
                        <input type="number" class="form-control" name="autoPublishedNum" id="coupon-published-histories-autoPublishedNum"
                            :class="{'valid': !$v.couponPublishedHistories.autoPublishedNum.$invalid, 'invalid': $v.couponPublishedHistories.autoPublishedNum.$invalid }" v-model.number="$v.couponPublishedHistories.autoPublishedNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.totalPublishedPrice')" for="coupon-published-histories-totalPublishedPrice">Total Published Price</label>
                        <input type="number" class="form-control" name="totalPublishedPrice" id="coupon-published-histories-totalPublishedPrice"
                            :class="{'valid': !$v.couponPublishedHistories.totalPublishedPrice.$invalid, 'invalid': $v.couponPublishedHistories.totalPublishedPrice.$invalid }" v-model.number="$v.couponPublishedHistories.totalPublishedPrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.publishedDt')" for="coupon-published-histories-publishedDt">Published Dt</label>
                        <div class="d-flex">
                            <input id="coupon-published-histories-publishedDt" type="datetime-local" class="form-control" name="publishedDt" :class="{'valid': !$v.couponPublishedHistories.publishedDt.$invalid, 'invalid': $v.couponPublishedHistories.publishedDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.couponPublishedHistories.publishedDt.$model)"
                            @change="updateZonedDateTimeField('publishedDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.expireDt')" for="coupon-published-histories-expireDt">Expire Dt</label>
                        <div class="d-flex">
                            <input id="coupon-published-histories-expireDt" type="datetime-local" class="form-control" name="expireDt" :class="{'valid': !$v.couponPublishedHistories.expireDt.$invalid, 'invalid': $v.couponPublishedHistories.expireDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.couponPublishedHistories.expireDt.$model)"
                            @change="updateZonedDateTimeField('expireDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.couponPublishedHistories.CouponPublishedHistoriesState')" for="coupon-published-histories-CouponPublishedHistoriesState">Coupon Published Histories State</label>
                        <select class="form-control" name="CouponPublishedHistoriesState" :class="{'valid': !$v.couponPublishedHistories.CouponPublishedHistoriesState.$invalid, 'invalid': $v.couponPublishedHistories.CouponPublishedHistoriesState.$invalid }" v-model="$v.couponPublishedHistories.CouponPublishedHistoriesState.$model" id="coupon-published-histories-CouponPublishedHistoriesState"  required>
                            <option value="NORMAL" v-bind:label="$t('hotelgaServerApp.CouponPublishedHistoriesState.NORMAL')">NORMAL</option>
                            <option value="ABNORMAL" v-bind:label="$t('hotelgaServerApp.CouponPublishedHistoriesState.ABNORMAL')">ABNORMAL</option>
                        </select>
                        <div v-if="$v.couponPublishedHistories.CouponPublishedHistoriesState.$anyDirty && $v.couponPublishedHistories.CouponPublishedHistoriesState.$invalid">
                            <small class="form-text text-danger" v-if="!$v.couponPublishedHistories.CouponPublishedHistoriesState.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.couponPublishedHistories.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./coupon-published-histories-update.component.ts">
</script>
