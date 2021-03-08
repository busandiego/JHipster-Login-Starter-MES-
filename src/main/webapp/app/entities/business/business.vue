<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('wmesServerApp.business.home.title')" id="business-heading">Businesses</span>
            <router-link :to="{name: 'BusinessCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-business">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('wmesServerApp.business.home.createLabel')">
                    Create a new Business
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && businesses && businesses.length === 0">
            <span v-text="$t('wmesServerApp.business.home.notFound')">No businesses found</span>
        </div>
        <div class="table-responsive" v-if="businesses && businesses.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><span v-text="$t('global.field.id')">ID</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessName')">Business Name</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessRepresentative')">Business Representative</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessRegistrationNum')">Business Registration Num</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessContactNum')">Business Contact Num</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessType')">Business Type</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessAddress')">Business Address</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessCategory')">Business Category</span></th>
                    <th><span v-text="$t('wmesServerApp.business.businessFaxNum')">Business Fax Num</span></th>
                    <th><span v-text="$t('wmesServerApp.business.isHeadquarter')">Is Headquarter</span></th>
                    <th><span v-text="$t('wmesServerApp.business.createdDate')">Created Date</span></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="business in businesses"
                    :key="business.id">
                    <td>
                        <router-link :to="{name: 'BusinessView', params: {businessId: business.id}}">{{business.id}}</router-link>
                    </td>
                    <td>{{business.businessName}}</td>
                    <td>{{business.businessRepresentative}}</td>
                    <td>{{business.businessRegistrationNum}}</td>
                    <td>{{business.businessContactNum}}</td>
                    <td>{{business.businessType}}</td>
                    <td>{{business.businessAddress}}</td>
                    <td>{{business.businessCategory}}</td>
                    <td>{{business.businessFaxNum}}</td>
                    <td>{{business.isHeadquarter}}</td>
                    <td>{{business.createdDate | formatDate}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'BusinessView', params: {businessId: business.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'BusinessEdit', params: {businessId: business.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(business)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
                                <font-awesome-icon icon="times"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                            </b-button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="wmesServerApp.business.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-business-heading" v-bind:title="$t('wmesServerApp.business.delete.question')">Are you sure you want to delete this Business?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-business" v-text="$t('entity.action.delete')" v-on:click="removeBusiness()">Delete</button>
            </div>
        </b-modal>
    </div>
</template>

<script lang="ts" src="./business.component.ts">
</script>
