<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="business">
                <h2 class="jh-entity-heading"><span v-text="$t('wmesServerApp.business.detail.title')">Business</span> {{business.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessName')">Business Name</span>
                    </dt>
                    <dd>
                        <span>{{business.businessName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessRepresentative')">Business Representative</span>
                    </dt>
                    <dd>
                        <span>{{business.businessRepresentative}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessRegistrationNum')">Business Registration Num</span>
                    </dt>
                    <dd>
                        <span>{{business.businessRegistrationNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessContactNum')">Business Contact Num</span>
                    </dt>
                    <dd>
                        <span>{{business.businessContactNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessType')">Business Type</span>
                    </dt>
                    <dd>
                        <span>{{business.businessType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessAddress')">Business Address</span>
                    </dt>
                    <dd>
                        <span>{{business.businessAddress}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessCategory')">Business Category</span>
                    </dt>
                    <dd>
                        <span>{{business.businessCategory}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.businessFaxNum')">Business Fax Num</span>
                    </dt>
                    <dd>
                        <span>{{business.businessFaxNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.isHeadquarter')">Is Headquarter</span>
                    </dt>
                    <dd>
                        <span>{{business.isHeadquarter}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('wmesServerApp.business.createdDate')">Created Date</span>
                    </dt>
                    <dd>
                        <span>{{business.createdDate | formatDate}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="business.id" :to="{name: 'BusinessEdit', params: {businessId: business.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./business-details.component.ts">
</script>
