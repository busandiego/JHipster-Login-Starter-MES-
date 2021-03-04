<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="inviteCard">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.inviteCard.detail.title')">InviteCard</span> {{inviteCard.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.inviteName')">Invite Name</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.inviteName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.inviteSerial')">Invite Serial</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.inviteSerial}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.inviteCreateDt')">Invite Create Dt</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.inviteCreateDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.inviteExpirationDt')">Invite Expiration Dt</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.inviteExpirationDt | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.managerName')">Manager Name</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.managerName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.accommodationName')">Accommodation Name</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.accommodationName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.inflowNum')">Inflow Num</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.inflowNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.reservationNum')">Reservation Num</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.reservationNum}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.managerId')">Manager Id</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.managerId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.accommodationId')">Accommodation Id</span>
                    </dt>
                    <dd>
                        <span>{{inviteCard.accommodationId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.inviteCard.inviteCardState')">Invite Card State</span>
                    </dt>
                    <dd>
                        <span v-text="$t('hotelgaServerApp.InviteCardState.' + inviteCard.inviteCardState)">{{inviteCard.inviteCardState}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="inviteCard.id" :to="{name: 'InviteCardEdit', params: {inviteCardId: inviteCard.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./invite-card-details.component.ts">
</script>
