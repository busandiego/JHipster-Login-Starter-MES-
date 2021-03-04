<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="roomSellDetails">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.roomSellDetails.detail.title')">RoomSellDetails</span> {{roomSellDetails.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.sellDt')">Sell Dt</span>
                    </dt>
                    <dd>
                        <span>{{roomSellDetails.sellDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.sellAmount')">Sell Amount</span>
                    </dt>
                    <dd>
                        <span>{{roomSellDetails.sellAmount}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.sellSoldNum')">Sell Sold Num</span>
                    </dt>
                    <dd>
                        <span>{{roomSellDetails.sellSoldNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.sellStartTime')">Sell Start Time</span>
                    </dt>
                    <dd>
                        <span>{{roomSellDetails.sellStartTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.sellEndTime')">Sell End Time</span>
                    </dt>
                    <dd>
                        <span>{{roomSellDetails.sellEndTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.sellUseTime')">Sell Use Time</span>
                    </dt>
                    <dd>
                        <span>{{roomSellDetails.sellUseTime}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.couponBoolean')">Coupon Boolean</span>
                    </dt>
                    <dd>
                        <span>{{roomSellDetails.couponBoolean}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellDetails.sellState')">Sell State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.SellState.' + roomSellDetails.sellState)">{{roomSellDetails.sellState}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="roomSellDetails.id" :to="{name: 'RoomSellDetailsEdit', params: {roomSellDetailsId: roomSellDetails.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./room-sell-details-details.component.ts">
</script>
