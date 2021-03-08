<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="wmesServerApp.business.home.createOrEditLabel" v-text="$t('wmesServerApp.business.home.createOrEditLabel')">Create or edit a Business</h2>
                <div>
                    <div class="form-group" v-if="business.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="business.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessName')" for="business-businessName">Business Name</label>
                        <input type="text" class="form-control" name="businessName" id="business-businessName"
                            :class="{'valid': !$v.business.businessName.$invalid, 'invalid': $v.business.businessName.$invalid }" v-model="$v.business.businessName.$model"  required/>
                        <div v-if="$v.business.businessName.$anyDirty && $v.business.businessName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.business.businessName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessRepresentative')" for="business-businessRepresentative">Business Representative</label>
                        <input type="text" class="form-control" name="businessRepresentative" id="business-businessRepresentative"
                            :class="{'valid': !$v.business.businessRepresentative.$invalid, 'invalid': $v.business.businessRepresentative.$invalid }" v-model="$v.business.businessRepresentative.$model"  required/>
                        <div v-if="$v.business.businessRepresentative.$anyDirty && $v.business.businessRepresentative.$invalid">
                            <small class="form-text text-danger" v-if="!$v.business.businessRepresentative.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessRegistrationNum')" for="business-businessRegistrationNum">Business Registration Num</label>
                        <input type="text" class="form-control" name="businessRegistrationNum" id="business-businessRegistrationNum"
                            :class="{'valid': !$v.business.businessRegistrationNum.$invalid, 'invalid': $v.business.businessRegistrationNum.$invalid }" v-model="$v.business.businessRegistrationNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessContactNum')" for="business-businessContactNum">Business Contact Num</label>
                        <input type="text" class="form-control" name="businessContactNum" id="business-businessContactNum"
                            :class="{'valid': !$v.business.businessContactNum.$invalid, 'invalid': $v.business.businessContactNum.$invalid }" v-model="$v.business.businessContactNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessType')" for="business-businessType">Business Type</label>
                        <input type="text" class="form-control" name="businessType" id="business-businessType"
                            :class="{'valid': !$v.business.businessType.$invalid, 'invalid': $v.business.businessType.$invalid }" v-model="$v.business.businessType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessAddress')" for="business-businessAddress">Business Address</label>
                        <input type="text" class="form-control" name="businessAddress" id="business-businessAddress"
                            :class="{'valid': !$v.business.businessAddress.$invalid, 'invalid': $v.business.businessAddress.$invalid }" v-model="$v.business.businessAddress.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessCategory')" for="business-businessCategory">Business Category</label>
                        <input type="text" class="form-control" name="businessCategory" id="business-businessCategory"
                            :class="{'valid': !$v.business.businessCategory.$invalid, 'invalid': $v.business.businessCategory.$invalid }" v-model="$v.business.businessCategory.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.businessFaxNum')" for="business-businessFaxNum">Business Fax Num</label>
                        <input type="text" class="form-control" name="businessFaxNum" id="business-businessFaxNum"
                            :class="{'valid': !$v.business.businessFaxNum.$invalid, 'invalid': $v.business.businessFaxNum.$invalid }" v-model="$v.business.businessFaxNum.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.isHeadquarter')" for="business-isHeadquarter">Is Headquarter</label>
                        <input type="checkbox" class="form-check" name="isHeadquarter" id="business-isHeadquarter"
                            :class="{'valid': !$v.business.isHeadquarter.$invalid, 'invalid': $v.business.isHeadquarter.$invalid }" v-model="$v.business.isHeadquarter.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('wmesServerApp.business.createdDate')" for="business-createdDate">Created Date</label>
                        <div class="d-flex">
                            <input id="business-createdDate" type="datetime-local" class="form-control" name="createdDate" :class="{'valid': !$v.business.createdDate.$invalid, 'invalid': $v.business.createdDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.business.createdDate.$model)"
                            @change="updateZonedDateTimeField('createdDate', $event)"/>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.business.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./business-update.component.ts">
</script>
