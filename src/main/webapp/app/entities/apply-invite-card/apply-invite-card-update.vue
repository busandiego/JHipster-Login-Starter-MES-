<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.applyInviteCard.home.createOrEditLabel" v-text="$t('hotelgaServerApp.applyInviteCard.home.createOrEditLabel')">Create or edit a ApplyInviteCard</h2>
                <div>
                    <div class="form-group" v-if="applyInviteCard.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="applyInviteCard.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.inviteName')" for="apply-invite-card-inviteName">Invite Name</label>
                        <input type="text" class="form-control" name="inviteName" id="apply-invite-card-inviteName"
                            :class="{'valid': !$v.applyInviteCard.inviteName.$invalid, 'invalid': $v.applyInviteCard.inviteName.$invalid }" v-model="$v.applyInviteCard.inviteName.$model"  required/>
                        <div v-if="$v.applyInviteCard.inviteName.$anyDirty && $v.applyInviteCard.inviteName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.applyInviteCard.inviteName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.applyCardDt')" for="apply-invite-card-applyCardDt">Apply Card Dt</label>
                        <div class="d-flex">
                            <input id="apply-invite-card-applyCardDt" type="datetime-local" class="form-control" name="applyCardDt" :class="{'valid': !$v.applyInviteCard.applyCardDt.$invalid, 'invalid': $v.applyInviteCard.applyCardDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.applyInviteCard.applyCardDt.$model)"
                            @change="updateZonedDateTimeField('applyCardDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.managerName')" for="apply-invite-card-managerName">Manager Name</label>
                        <input type="text" class="form-control" name="managerName" id="apply-invite-card-managerName"
                            :class="{'valid': !$v.applyInviteCard.managerName.$invalid, 'invalid': $v.applyInviteCard.managerName.$invalid }" v-model="$v.applyInviteCard.managerName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.accommodationName')" for="apply-invite-card-accommodationName">Accommodation Name</label>
                        <input type="text" class="form-control" name="accommodationName" id="apply-invite-card-accommodationName"
                            :class="{'valid': !$v.applyInviteCard.accommodationName.$invalid, 'invalid': $v.applyInviteCard.accommodationName.$invalid }" v-model="$v.applyInviteCard.accommodationName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.managerPhoneNum')" for="apply-invite-card-managerPhoneNum">Manager Phone Num</label>
                        <input type="text" class="form-control" name="managerPhoneNum" id="apply-invite-card-managerPhoneNum"
                            :class="{'valid': !$v.applyInviteCard.managerPhoneNum.$invalid, 'invalid': $v.applyInviteCard.managerPhoneNum.$invalid }" v-model="$v.applyInviteCard.managerPhoneNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.applyAmountNum')" for="apply-invite-card-applyAmountNum">Apply Amount Num</label>
                        <input type="number" class="form-control" name="applyAmountNum" id="apply-invite-card-applyAmountNum"
                            :class="{'valid': !$v.applyInviteCard.applyAmountNum.$invalid, 'invalid': $v.applyInviteCard.applyAmountNum.$invalid }" v-model.number="$v.applyInviteCard.applyAmountNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.managerId')" for="apply-invite-card-managerId">Manager Id</label>
                        <input type="number" class="form-control" name="managerId" id="apply-invite-card-managerId"
                            :class="{'valid': !$v.applyInviteCard.managerId.$invalid, 'invalid': $v.applyInviteCard.managerId.$invalid }" v-model.number="$v.applyInviteCard.managerId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.accommodationId')" for="apply-invite-card-accommodationId">Accommodation Id</label>
                        <input type="number" class="form-control" name="accommodationId" id="apply-invite-card-accommodationId"
                            :class="{'valid': !$v.applyInviteCard.accommodationId.$invalid, 'invalid': $v.applyInviteCard.accommodationId.$invalid }" v-model.number="$v.applyInviteCard.accommodationId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.applyInviteCard.applyInviteCardState')" for="apply-invite-card-applyInviteCardState">Apply Invite Card State</label>
                        <select class="form-control" name="applyInviteCardState" :class="{'valid': !$v.applyInviteCard.applyInviteCardState.$invalid, 'invalid': $v.applyInviteCard.applyInviteCardState.$invalid }" v-model="$v.applyInviteCard.applyInviteCardState.$model" id="apply-invite-card-applyInviteCardState"  required>
                            <option value="APPROVE" v-bind:label="$t('hotelgaServerApp.ApplyInviteCardState.APPROVE')">APPROVE</option>
                            <option value="DELETE" v-bind:label="$t('hotelgaServerApp.ApplyInviteCardState.DELETE')">DELETE</option>
                            <option value="WAITING" v-bind:label="$t('hotelgaServerApp.ApplyInviteCardState.WAITING')">WAITING</option>
                        </select>
                        <div v-if="$v.applyInviteCard.applyInviteCardState.$anyDirty && $v.applyInviteCard.applyInviteCardState.$invalid">
                            <small class="form-text text-danger" v-if="!$v.applyInviteCard.applyInviteCardState.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.applyInviteCard.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./apply-invite-card-update.component.ts">
</script>
