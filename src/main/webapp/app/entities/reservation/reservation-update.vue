<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.reservation.home.createOrEditLabel" v-text="$t('hotelgaServerApp.reservation.home.createOrEditLabel')">Create or edit a Reservation</h2>
                <div>
                    <div class="form-group" v-if="reservation.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="reservation.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.orderUniqNum')" for="reservation-orderUniqNum">Order Uniq Num</label>
                        <input type="text" class="form-control" name="orderUniqNum" id="reservation-orderUniqNum"
                            :class="{'valid': !$v.reservation.orderUniqNum.$invalid, 'invalid': $v.reservation.orderUniqNum.$invalid }" v-model="$v.reservation.orderUniqNum.$model"  required/>
                        <div v-if="$v.reservation.orderUniqNum.$anyDirty && $v.reservation.orderUniqNum.$invalid">
                            <small class="form-text text-danger" v-if="!$v.reservation.orderUniqNum.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.orderUserName')" for="reservation-orderUserName">Order User Name</label>
                        <input type="text" class="form-control" name="orderUserName" id="reservation-orderUserName"
                            :class="{'valid': !$v.reservation.orderUserName.$invalid, 'invalid': $v.reservation.orderUserName.$invalid }" v-model="$v.reservation.orderUserName.$model"  required/>
                        <div v-if="$v.reservation.orderUserName.$anyDirty && $v.reservation.orderUserName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.reservation.orderUserName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.orderUserNum')" for="reservation-orderUserNum">Order User Num</label>
                        <input type="text" class="form-control" name="orderUserNum" id="reservation-orderUserNum"
                            :class="{'valid': !$v.reservation.orderUserNum.$invalid, 'invalid': $v.reservation.orderUserNum.$invalid }" v-model="$v.reservation.orderUserNum.$model"  required/>
                        <div v-if="$v.reservation.orderUserNum.$anyDirty && $v.reservation.orderUserNum.$invalid">
                            <small class="form-text text-danger" v-if="!$v.reservation.orderUserNum.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.transportation')" for="reservation-transportation">Transportation</label>
                        <input type="text" class="form-control" name="transportation" id="reservation-transportation"
                            :class="{'valid': !$v.reservation.transportation.$invalid, 'invalid': $v.reservation.transportation.$invalid }" v-model="$v.reservation.transportation.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.accommodationName')" for="reservation-accommodationName">Accommodation Name</label>
                        <input type="text" class="form-control" name="accommodationName" id="reservation-accommodationName"
                            :class="{'valid': !$v.reservation.accommodationName.$invalid, 'invalid': $v.reservation.accommodationName.$invalid }" v-model="$v.reservation.accommodationName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.roomName')" for="reservation-roomName">Room Name</label>
                        <input type="text" class="form-control" name="roomName" id="reservation-roomName"
                            :class="{'valid': !$v.reservation.roomName.$invalid, 'invalid': $v.reservation.roomName.$invalid }" v-model="$v.reservation.roomName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.reservationPrice')" for="reservation-reservationPrice">Reservation Price</label>
                        <input type="number" class="form-control" name="reservationPrice" id="reservation-reservationPrice"
                            :class="{'valid': !$v.reservation.reservationPrice.$invalid, 'invalid': $v.reservation.reservationPrice.$invalid }" v-model.number="$v.reservation.reservationPrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.roomDiscountPer')" for="reservation-roomDiscountPer">Room Discount Per</label>
                        <input type="number" class="form-control" name="roomDiscountPer" id="reservation-roomDiscountPer"
                            :class="{'valid': !$v.reservation.roomDiscountPer.$invalid, 'invalid': $v.reservation.roomDiscountPer.$invalid }" v-model.number="$v.reservation.roomDiscountPer.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.couponApply')" for="reservation-couponApply">Coupon Apply</label>
                        <input type="checkbox" class="form-check" name="couponApply" id="reservation-couponApply"
                            :class="{'valid': !$v.reservation.couponApply.$invalid, 'invalid': $v.reservation.couponApply.$invalid }" v-model="$v.reservation.couponApply.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.couponName')" for="reservation-couponName">Coupon Name</label>
                        <input type="text" class="form-control" name="couponName" id="reservation-couponName"
                            :class="{'valid': !$v.reservation.couponName.$invalid, 'invalid': $v.reservation.couponName.$invalid }" v-model="$v.reservation.couponName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.couponDiscountPrice')" for="reservation-couponDiscountPrice">Coupon Discount Price</label>
                        <input type="number" class="form-control" name="couponDiscountPrice" id="reservation-couponDiscountPrice"
                            :class="{'valid': !$v.reservation.couponDiscountPrice.$invalid, 'invalid': $v.reservation.couponDiscountPrice.$invalid }" v-model.number="$v.reservation.couponDiscountPrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.couponType')" for="reservation-couponType">Coupon Type</label>
                        <input type="text" class="form-control" name="couponType" id="reservation-couponType"
                            :class="{'valid': !$v.reservation.couponType.$invalid, 'invalid': $v.reservation.couponType.$invalid }" v-model="$v.reservation.couponType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.paymentPrice')" for="reservation-paymentPrice">Payment Price</label>
                        <input type="number" class="form-control" name="paymentPrice" id="reservation-paymentPrice"
                            :class="{'valid': !$v.reservation.paymentPrice.$invalid, 'invalid': $v.reservation.paymentPrice.$invalid }" v-model.number="$v.reservation.paymentPrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.paymentType')" for="reservation-paymentType">Payment Type</label>
                        <input type="text" class="form-control" name="paymentType" id="reservation-paymentType"
                            :class="{'valid': !$v.reservation.paymentType.$invalid, 'invalid': $v.reservation.paymentType.$invalid }" v-model="$v.reservation.paymentType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.affiliateCommission')" for="reservation-affiliateCommission">Affiliate Commission</label>
                        <input type="number" class="form-control" name="affiliateCommission" id="reservation-affiliateCommission"
                            :class="{'valid': !$v.reservation.affiliateCommission.$invalid, 'invalid': $v.reservation.affiliateCommission.$invalid }" v-model.number="$v.reservation.affiliateCommission.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.managerCommission')" for="reservation-managerCommission">Manager Commission</label>
                        <input type="number" class="form-control" name="managerCommission" id="reservation-managerCommission"
                            :class="{'valid': !$v.reservation.managerCommission.$invalid, 'invalid': $v.reservation.managerCommission.$invalid }" v-model.number="$v.reservation.managerCommission.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.investmentCommission')" for="reservation-investmentCommission">Investment Commission</label>
                        <input type="number" class="form-control" name="investmentCommission" id="reservation-investmentCommission"
                            :class="{'valid': !$v.reservation.investmentCommission.$invalid, 'invalid': $v.reservation.investmentCommission.$invalid }" v-model.number="$v.reservation.investmentCommission.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.useStartTime')" for="reservation-useStartTime">Use Start Time</label>
                        <div class="d-flex">
                            <input id="reservation-useStartTime" type="datetime-local" class="form-control" name="useStartTime" :class="{'valid': !$v.reservation.useStartTime.$invalid, 'invalid': $v.reservation.useStartTime.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.reservation.useStartTime.$model)"
                            @change="updateZonedDateTimeField('useStartTime', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.useEndTime')" for="reservation-useEndTime">Use End Time</label>
                        <div class="d-flex">
                            <input id="reservation-useEndTime" type="datetime-local" class="form-control" name="useEndTime" :class="{'valid': !$v.reservation.useEndTime.$invalid, 'invalid': $v.reservation.useEndTime.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.reservation.useEndTime.$model)"
                            @change="updateZonedDateTimeField('useEndTime', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.orderCreateDt')" for="reservation-orderCreateDt">Order Create Dt</label>
                        <div class="d-flex">
                            <input id="reservation-orderCreateDt" type="datetime-local" class="form-control" name="orderCreateDt" :class="{'valid': !$v.reservation.orderCreateDt.$invalid, 'invalid': $v.reservation.orderCreateDt.$invalid }"
                             required
                            :value="convertDateTimeFromServer($v.reservation.orderCreateDt.$model)"
                            @change="updateZonedDateTimeField('orderCreateDt', $event)"/>
                        </div>
                        <div v-if="$v.reservation.orderCreateDt.$anyDirty && $v.reservation.orderCreateDt.$invalid">
                            <small class="form-text text-danger" v-if="!$v.reservation.orderCreateDt.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.reservation.orderCreateDt.ZonedDateTimelocal" v-text="$t('entity.validation.ZonedDateTimelocal')">
                                This field should be a date and time.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.checkInDt')" for="reservation-checkInDt">Check In Dt</label>
                        <div class="d-flex">
                            <input id="reservation-checkInDt" type="datetime-local" class="form-control" name="checkInDt" :class="{'valid': !$v.reservation.checkInDt.$invalid, 'invalid': $v.reservation.checkInDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.reservation.checkInDt.$model)"
                            @change="updateZonedDateTimeField('checkInDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.checkOutDt')" for="reservation-checkOutDt">Check Out Dt</label>
                        <div class="d-flex">
                            <input id="reservation-checkOutDt" type="datetime-local" class="form-control" name="checkOutDt" :class="{'valid': !$v.reservation.checkOutDt.$invalid, 'invalid': $v.reservation.checkOutDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.reservation.checkOutDt.$model)"
                            @change="updateZonedDateTimeField('checkOutDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.orderState')" for="reservation-orderState">Order State</label>
                        <select class="form-control" name="orderState" :class="{'valid': !$v.reservation.orderState.$invalid, 'invalid': $v.reservation.orderState.$invalid }" v-model="$v.reservation.orderState.$model" id="reservation-orderState" >
                            <option value="DEPOSITWAIT" v-bind:label="$t('hotelgaServerApp.StateOrder.DEPOSITWAIT')">DEPOSITWAIT</option>
                            <option value="RESERVATIONOK" v-bind:label="$t('hotelgaServerApp.StateOrder.RESERVATIONOK')">RESERVATIONOK</option>
                            <option value="USEOK" v-bind:label="$t('hotelgaServerApp.StateOrder.USEOK')">USEOK</option>
                            <option value="RESERVATIONFAIL" v-bind:label="$t('hotelgaServerApp.StateOrder.RESERVATIONFAIL')">RESERVATIONFAIL</option>
                            <option value="RESERVATIONCANCEL" v-bind:label="$t('hotelgaServerApp.StateOrder.RESERVATIONCANCEL')">RESERVATIONCANCEL</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.hoMemberId')" for="reservation-hoMemberId">Ho Member Id</label>
                        <input type="number" class="form-control" name="hoMemberId" id="reservation-hoMemberId"
                            :class="{'valid': !$v.reservation.hoMemberId.$invalid, 'invalid': $v.reservation.hoMemberId.$invalid }" v-model.number="$v.reservation.hoMemberId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.managerId')" for="reservation-managerId">Manager Id</label>
                        <input type="number" class="form-control" name="managerId" id="reservation-managerId"
                            :class="{'valid': !$v.reservation.managerId.$invalid, 'invalid': $v.reservation.managerId.$invalid }" v-model.number="$v.reservation.managerId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.affiliateId')" for="reservation-affiliateId">Affiliate Id</label>
                        <input type="number" class="form-control" name="affiliateId" id="reservation-affiliateId"
                            :class="{'valid': !$v.reservation.affiliateId.$invalid, 'invalid': $v.reservation.affiliateId.$invalid }" v-model.number="$v.reservation.affiliateId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.reservation.accommodationId')" for="reservation-accommodationId">Accommodation Id</label>
                        <input type="number" class="form-control" name="accommodationId" id="reservation-accommodationId"
                            :class="{'valid': !$v.reservation.accommodationId.$invalid, 'invalid': $v.reservation.accommodationId.$invalid }" v-model.number="$v.reservation.accommodationId.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.reservation.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./reservation-update.component.ts">
</script>
