<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.affiliateMember.home.createOrEditLabel" v-text="$t('hotelgaServerApp.affiliateMember.home.createOrEditLabel')">Create or edit a AffiliateMember</h2>
                <div>
                    <div class="form-group" v-if="affiliateMember.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="affiliateMember.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberLoginId')" for="affiliate-member-affiliateMemberLoginId">Affiliate Member Login Id</label>
                        <input type="text" class="form-control" name="affiliateMemberLoginId" id="affiliate-member-affiliateMemberLoginId"
                            :class="{'valid': !$v.affiliateMember.affiliateMemberLoginId.$invalid, 'invalid': $v.affiliateMember.affiliateMemberLoginId.$invalid }" v-model="$v.affiliateMember.affiliateMemberLoginId.$model"  required/>
                        <div v-if="$v.affiliateMember.affiliateMemberLoginId.$anyDirty && $v.affiliateMember.affiliateMemberLoginId.$invalid">
                            <small class="form-text text-danger" v-if="!$v.affiliateMember.affiliateMemberLoginId.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberPassword')" for="affiliate-member-affiliateMemberPassword">Affiliate Member Password</label>
                        <input type="text" class="form-control" name="affiliateMemberPassword" id="affiliate-member-affiliateMemberPassword"
                            :class="{'valid': !$v.affiliateMember.affiliateMemberPassword.$invalid, 'invalid': $v.affiliateMember.affiliateMemberPassword.$invalid }" v-model="$v.affiliateMember.affiliateMemberPassword.$model"  required/>
                        <div v-if="$v.affiliateMember.affiliateMemberPassword.$anyDirty && $v.affiliateMember.affiliateMemberPassword.$invalid">
                            <small class="form-text text-danger" v-if="!$v.affiliateMember.affiliateMemberPassword.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberName')" for="affiliate-member-affiliateMemberName">Affiliate Member Name</label>
                        <input type="text" class="form-control" name="affiliateMemberName" id="affiliate-member-affiliateMemberName"
                            :class="{'valid': !$v.affiliateMember.affiliateMemberName.$invalid, 'invalid': $v.affiliateMember.affiliateMemberName.$invalid }" v-model="$v.affiliateMember.affiliateMemberName.$model"  required/>
                        <div v-if="$v.affiliateMember.affiliateMemberName.$anyDirty && $v.affiliateMember.affiliateMemberName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.affiliateMember.affiliateMemberName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberPhoneNum')" for="affiliate-member-affiliateMemberPhoneNum">Affiliate Member Phone Num</label>
                        <input type="text" class="form-control" name="affiliateMemberPhoneNum" id="affiliate-member-affiliateMemberPhoneNum"
                            :class="{'valid': !$v.affiliateMember.affiliateMemberPhoneNum.$invalid, 'invalid': $v.affiliateMember.affiliateMemberPhoneNum.$invalid }" v-model="$v.affiliateMember.affiliateMemberPhoneNum.$model"  required/>
                        <div v-if="$v.affiliateMember.affiliateMemberPhoneNum.$anyDirty && $v.affiliateMember.affiliateMemberPhoneNum.$invalid">
                            <small class="form-text text-danger" v-if="!$v.affiliateMember.affiliateMemberPhoneNum.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberMemo')" for="affiliate-member-affiliateMemberMemo">Affiliate Member Memo</label>
                        <input type="text" class="form-control" name="affiliateMemberMemo" id="affiliate-member-affiliateMemberMemo"
                            :class="{'valid': !$v.affiliateMember.affiliateMemberMemo.$invalid, 'invalid': $v.affiliateMember.affiliateMemberMemo.$invalid }" v-model="$v.affiliateMember.affiliateMemberMemo.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.pushToken')" for="affiliate-member-pushToken">Push Token</label>
                        <input type="text" class="form-control" name="pushToken" id="affiliate-member-pushToken"
                            :class="{'valid': !$v.affiliateMember.pushToken.$invalid, 'invalid': $v.affiliateMember.pushToken.$invalid }" v-model="$v.affiliateMember.pushToken.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.createDt')" for="affiliate-member-createDt">Create Dt</label>
                        <div class="d-flex">
                            <input id="affiliate-member-createDt" type="datetime-local" class="form-control" name="createDt" :class="{'valid': !$v.affiliateMember.createDt.$invalid, 'invalid': $v.affiliateMember.createDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.affiliateMember.createDt.$model)"
                            @change="updateZonedDateTimeField('createDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.updateDt')" for="affiliate-member-updateDt">Update Dt</label>
                        <div class="d-flex">
                            <input id="affiliate-member-updateDt" type="datetime-local" class="form-control" name="updateDt" :class="{'valid': !$v.affiliateMember.updateDt.$invalid, 'invalid': $v.affiliateMember.updateDt.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.affiliateMember.updateDt.$model)"
                            @change="updateZonedDateTimeField('updateDt', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberState')" for="affiliate-member-affiliateMemberState">Affiliate Member State</label>
                        <select class="form-control" name="affiliateMemberState" :class="{'valid': !$v.affiliateMember.affiliateMemberState.$invalid, 'invalid': $v.affiliateMember.affiliateMemberState.$invalid }" v-model="$v.affiliateMember.affiliateMemberState.$model" id="affiliate-member-affiliateMemberState" >
                            <option value="NORMAL" v-bind:label="$t('hotelgaServerApp.StateAffiliateMember.NORMAL')">NORMAL</option>
                            <option value="ABNORMAL" v-bind:label="$t('hotelgaServerApp.StateAffiliateMember.ABNORMAL')">ABNORMAL</option>
                            <option value="DELETE" v-bind:label="$t('hotelgaServerApp.StateAffiliateMember.DELETE')">DELETE</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.affiliateMember.affiliateId')" for="affiliate-member-affiliateId">Affiliate Id</label>
                        <input type="number" class="form-control" name="affiliateId" id="affiliate-member-affiliateId"
                            :class="{'valid': !$v.affiliateMember.affiliateId.$invalid, 'invalid': $v.affiliateMember.affiliateId.$invalid }" v-model.number="$v.affiliateMember.affiliateId.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.affiliateMember.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./affiliate-member-update.component.ts">
</script>
