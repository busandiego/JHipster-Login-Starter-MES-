<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.roomSellInfo.home.createOrEditLabel" v-text="$t('hotelgaServerApp.roomSellInfo.home.createOrEditLabel')">Create or edit a RoomSellInfo</h2>
                <div>
                    <div class="form-group" v-if="roomSellInfo.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="roomSellInfo.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellInfo.roomSalesType')" for="room-sell-info-roomSalesType">Room Sales Type</label>
                        <select class="form-control" name="roomSalesType" :class="{'valid': !$v.roomSellInfo.roomSalesType.$invalid, 'invalid': $v.roomSellInfo.roomSalesType.$invalid }" v-model="$v.roomSellInfo.roomSalesType.$model" id="room-sell-info-roomSalesType" >
                            <option value="DAYUSE" v-bind:label="$t('hotelgaServerApp.RoomSalesType.DAYUSE')">DAYUSE</option>
                            <option value="FULLRENT" v-bind:label="$t('hotelgaServerApp.RoomSalesType.FULLRENT')">FULLRENT</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.roomSellInfo.roomId')" for="room-sell-info-roomId">Room Id</label>
                        <input type="number" class="form-control" name="roomId" id="room-sell-info-roomId"
                            :class="{'valid': !$v.roomSellInfo.roomId.$invalid, 'invalid': $v.roomSellInfo.roomId.$invalid }" v-model.number="$v.roomSellInfo.roomId.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.roomSellInfo.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./room-sell-info-update.component.ts">
</script>
