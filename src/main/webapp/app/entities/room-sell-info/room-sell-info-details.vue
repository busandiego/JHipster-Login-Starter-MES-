<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="roomSellInfo">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.roomSellInfo.detail.title')">RoomSellInfo</span> {{roomSellInfo.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellInfo.roomSalesType')">Room Sales Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.RoomSalesType.' + roomSellInfo.roomSalesType)">{{roomSellInfo.roomSalesType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.roomSellInfo.roomId')">Room Id</span>
                    </dt>
                    <dd>
                        <span>{{roomSellInfo.roomId}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="roomSellInfo.id" :to="{name: 'RoomSellInfoEdit', params: {roomSellInfoId: roomSellInfo.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./room-sell-info-details.component.ts">
</script>
