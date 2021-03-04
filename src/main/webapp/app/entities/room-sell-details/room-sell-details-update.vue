<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.roomSellDetails.home.createOrEditLabel" v-text="$t('hotelgaServerApp.roomSellDetails.home.createOrEditLabel')">Create or edit a RoomSellDetails</h2>
                <div>
                    <div class="form-group" v-if="roomSellDetails.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="roomSellDetails.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.sellDt')" for="room-sell-details-sellDt">Sell Dt</label>
                        <div class="d-flex">
                            <input id="room-sell-details-sellDt" type="datetime-local" class="form-control" name="sellDt" :class="{'valid': !$v.roomSellDetails.sellDt.$invalid, 'invalid': $v.roomSellDetails.sellDt.$invalid }"
                             required
                            :value="convertDateTimeFromServer($v.roomSellDetails.sellDt.$model)"
                            @change="updateZonedDateTimeField('sellDt', $event)"/>
                        </div>
                        <div v-if="$v.roomSellDetails.sellDt.$anyDirty && $v.roomSellDetails.sellDt.$invalid">
                            <small class="form-text text-danger" v-if="!$v.roomSellDetails.sellDt.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.roomSellDetails.sellDt.ZonedDateTimelocal" v-text="$t('entity.validation.ZonedDateTimelocal')">
                                This field should be a date and time.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.sellAmount')" for="room-sell-details-sellAmount">Sell Amount</label>
                        <input type="number" class="form-control" name="sellAmount" id="room-sell-details-sellAmount"
                            :class="{'valid': !$v.roomSellDetails.sellAmount.$invalid, 'invalid': $v.roomSellDetails.sellAmount.$invalid }" v-model.number="$v.roomSellDetails.sellAmount.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.sellSoldNum')" for="room-sell-details-sellSoldNum">Sell Sold Num</label>
                        <input type="number" class="form-control" name="sellSoldNum" id="room-sell-details-sellSoldNum"
                            :class="{'valid': !$v.roomSellDetails.sellSoldNum.$invalid, 'invalid': $v.roomSellDetails.sellSoldNum.$invalid }" v-model.number="$v.roomSellDetails.sellSoldNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.sellStartTime')" for="room-sell-details-sellStartTime">Sell Start Time</label>
                        <input type="number" class="form-control" name="sellStartTime" id="room-sell-details-sellStartTime"
                            :class="{'valid': !$v.roomSellDetails.sellStartTime.$invalid, 'invalid': $v.roomSellDetails.sellStartTime.$invalid }" v-model.number="$v.roomSellDetails.sellStartTime.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.sellEndTime')" for="room-sell-details-sellEndTime">Sell End Time</label>
                        <input type="number" class="form-control" name="sellEndTime" id="room-sell-details-sellEndTime"
                            :class="{'valid': !$v.roomSellDetails.sellEndTime.$invalid, 'invalid': $v.roomSellDetails.sellEndTime.$invalid }" v-model.number="$v.roomSellDetails.sellEndTime.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.sellUseTime')" for="room-sell-details-sellUseTime">Sell Use Time</label>
                        <input type="number" class="form-control" name="sellUseTime" id="room-sell-details-sellUseTime"
                            :class="{'valid': !$v.roomSellDetails.sellUseTime.$invalid, 'invalid': $v.roomSellDetails.sellUseTime.$invalid }" v-model.number="$v.roomSellDetails.sellUseTime.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.couponBoolean')" for="room-sell-details-couponBoolean">Coupon Boolean</label>
                        <input type="number" class="form-control" name="couponBoolean" id="room-sell-details-couponBoolean"
                            :class="{'valid': !$v.roomSellDetails.couponBoolean.$invalid, 'invalid': $v.roomSellDetails.couponBoolean.$invalid }" v-model.number="$v.roomSellDetails.couponBoolean.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellDetails.sellState')" for="room-sell-details-sellState">Sell State</label>
                        <select class="form-control" name="sellState" :class="{'valid': !$v.roomSellDetails.sellState.$invalid, 'invalid': $v.roomSellDetails.sellState.$invalid }" v-model="$v.roomSellDetails.sellState.$model" id="room-sell-details-sellState" >
                            <option value="NORMAL" v-bind:label="$t('hotelgaServerApp.SellState.NORMAL')">NORMAL</option>
                            <option value="ABNORMAL" v-bind:label="$t('hotelgaServerApp.SellState.ABNORMAL')">ABNORMAL</option>
                            <option value="DELETE" v-bind:label="$t('hotelgaServerApp.SellState.DELETE')">DELETE</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.roomSellDetails.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./room-sell-details-update.component.ts">
</script>
