<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="applyInviteCard">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.applyInviteCard.detail.title')">ApplyInviteCard</span> {{applyInviteCard.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.inviteName')">Invite Name</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.inviteName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.applyCardDt')">Apply Card Dt</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.applyCardDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.managerName')">Manager Name</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.managerName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.accommodationName')">Accommodation Name</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.accommodationName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.managerPhoneNum')">Manager Phone Num</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.managerPhoneNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.applyAmountNum')">Apply Amount Num</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.applyAmountNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.managerId')">Manager Id</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.managerId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.accommodationId')">Accommodation Id</span>
                    </dt>
                    <dd>
                        <span>{{applyInviteCard.accommodationId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.applyInviteCard.applyInviteCardState')">Apply Invite Card State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.ApplyInviteCardState.' + applyInviteCard.applyInviteCardState)">{{applyInviteCard.applyInviteCardState}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="applyInviteCard.id" :to="{name: 'ApplyInviteCardEdit', params: {applyInviteCardId: applyInviteCard.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./apply-invite-card-details.component.ts">
</script>
