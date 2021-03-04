<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.inviteCard.home.createOrEditLabel" v-text="$t('hotelgaServerApp.inviteCard.home.createOrEditLabel')">Create or edit a InviteCard</h2>
                <div>
                    <div class="form-group" v-if="inviteCard.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="inviteCard.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.inviteName')" for="invite-card-inviteName">Invite Name</label>
                        <input type="text" class="form-control" name="inviteName" id="invite-card-inviteName"
                            :class="{'valid': !$v.inviteCard.inviteName.$invalid, 'invalid': $v.inviteCard.inviteName.$invalid }" v-model="$v.inviteCard.inviteName.$model"  required/>
                        <div v-if="$v.inviteCard.inviteName.$anyDirty && $v.inviteCard.inviteName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.inviteCard.inviteName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.inviteSerial')" for="invite-card-inviteSerial">Invite Serial</label>
                        <input type="text" class="form-control" name="inviteSerial" id="invite-card-inviteSerial"
                            :class="{'valid': !$v.inviteCard.inviteSerial.$invalid, 'invalid': $v.inviteCard.inviteSerial.$invalid }" v-model="$v.inviteCard.inviteSerial.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.inviteCreateDt')" for="invite-card-inviteCreateDt">Invite Create Dt</label>
                        <div class="d-flex">
                            <input id="invite-card-inviteCreateDt" type="datetime-local" class="form-control" name="inviteCreateDt" :class="{'valid': !$v.inviteCard.inviteCreateDt.$invalid, 'invalid': $v.inviteCard.inviteCreateDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.inviteCard.inviteCreateDt.$model)"
                            @change="updateZonedDateTimeField('inviteCreateDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.inviteExpirationDt')" for="invite-card-inviteExpirationDt">Invite Expiration Dt</label>
                        <div class="d-flex">
                            <input id="invite-card-inviteExpirationDt" type="datetime-local" class="form-control" name="inviteExpirationDt" :class="{'valid': !$v.inviteCard.inviteExpirationDt.$invalid, 'invalid': $v.inviteCard.inviteExpirationDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.inviteCard.inviteExpirationDt.$model)"
                            @change="updateZonedDateTimeField('inviteExpirationDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.managerName')" for="invite-card-managerName">Manager Name</label>
                        <input type="text" class="form-control" name="managerName" id="invite-card-managerName"
                            :class="{'valid': !$v.inviteCard.managerName.$invalid, 'invalid': $v.inviteCard.managerName.$invalid }" v-model="$v.inviteCard.managerName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.accommodationName')" for="invite-card-accommodationName">Accommodation Name</label>
                        <input type="text" class="form-control" name="accommodationName" id="invite-card-accommodationName"
                            :class="{'valid': !$v.inviteCard.accommodationName.$invalid, 'invalid': $v.inviteCard.accommodationName.$invalid }" v-model="$v.inviteCard.accommodationName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.inflowNum')" for="invite-card-inflowNum">Inflow Num</label>
                        <input type="number" class="form-control" name="inflowNum" id="invite-card-inflowNum"
                            :class="{'valid': !$v.inviteCard.inflowNum.$invalid, 'invalid': $v.inviteCard.inflowNum.$invalid }" v-model.number="$v.inviteCard.inflowNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.reservationNum')" for="invite-card-reservationNum">Reservation Num</label>
                        <input type="number" class="form-control" name="reservationNum" id="invite-card-reservationNum"
                            :class="{'valid': !$v.inviteCard.reservationNum.$invalid, 'invalid': $v.inviteCard.reservationNum.$invalid }" v-model.number="$v.inviteCard.reservationNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.managerId')" for="invite-card-managerId">Manager Id</label>
                        <input type="number" class="form-control" name="managerId" id="invite-card-managerId"
                            :class="{'valid': !$v.inviteCard.managerId.$invalid, 'invalid': $v.inviteCard.managerId.$invalid }" v-model.number="$v.inviteCard.managerId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.accommodationId')" for="invite-card-accommodationId">Accommodation Id</label>
                        <input type="number" class="form-control" name="accommodationId" id="invite-card-accommodationId"
                            :class="{'valid': !$v.inviteCard.accommodationId.$invalid, 'invalid': $v.inviteCard.accommodationId.$invalid }" v-model.number="$v.inviteCard.accommodationId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.inviteCard.inviteCardState')" for="invite-card-inviteCardState">Invite Card State</label>
                        <select class="form-control" name="inviteCardState" :class="{'valid': !$v.inviteCard.inviteCardState.$invalid, 'invalid': $v.inviteCard.inviteCardState.$invalid }" v-model="$v.inviteCard.inviteCardState.$model" id="invite-card-inviteCardState"  required>
                            <option value="NORMAL" v-bind:label="$t('hotelgaServerApp.InviteCardState.NORMAL')">NORMAL</option>
                            <option value="ABNORMAL" v-bind:label="$t('hotelgaServerApp.InviteCardState.ABNORMAL')">ABNORMAL</option>
                            <option value="DELETE" v-bind:label="$t('hotelgaServerApp.InviteCardState.DELETE')">DELETE</option>
                            <option value="WAITING" v-bind:label="$t('hotelgaServerApp.InviteCardState.WAITING')">WAITING</option>
                        </select>
                        <div v-if="$v.inviteCard.inviteCardState.$anyDirty && $v.inviteCard.inviteCardState.$invalid">
                            <small class="form-text text-danger" v-if="!$v.inviteCard.inviteCardState.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.inviteCard.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./invite-card-update.component.ts">
</script>
