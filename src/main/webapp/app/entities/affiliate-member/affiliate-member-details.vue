<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="affiliateMember">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.affiliateMember.detail.title')">AffiliateMember</span> {{affiliateMember.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberLoginId')">Affiliate Member Login Id</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.affiliateMemberLoginId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberPassword')">Affiliate Member Password</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.affiliateMemberPassword}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberName')">Affiliate Member Name</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.affiliateMemberName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberPhoneNum')">Affiliate Member Phone Num</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.affiliateMemberPhoneNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberMemo')">Affiliate Member Memo</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.affiliateMemberMemo}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.pushToken')">Push Token</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.pushToken}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.createDt')">Create Dt</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.createDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.updateDt')">Update Dt</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.updateDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberState')">Affiliate Member State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.StateAffiliateMember.' + affiliateMember.affiliateMemberState)">{{affiliateMember.affiliateMemberState}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.affiliateMember.affiliateId')">Affiliate Id</span>
                    </dt>
                    <dd>
                        <span>{{affiliateMember.affiliateId}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="affiliateMember.id" :to="{name: 'AffiliateMemberEdit', params: {affiliateMemberId: affiliateMember.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./affiliate-member-details.component.ts">
</script>
