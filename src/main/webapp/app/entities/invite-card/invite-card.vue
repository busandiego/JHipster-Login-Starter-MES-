<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.inviteCard.home.title')" id="invite-card-heading">Invite Cards</span>
            <router-link :to="{name: 'InviteCardCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-invite-card">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.inviteCard.home.createLabel')">
                    Create a new Invite Card
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
        <div class="alert alert-warning" v-if="!isFetching && inviteCards && inviteCards.length === 0">
            <span v-text="$t('hotelgaServerApp.inviteCard.home.notFound')">No inviteCards found</span>
        </div>
        <div class="table-responsive" v-if="inviteCards && inviteCards.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('inviteName')"><span v-text="$t('hotelgaServerApp.inviteCard.inviteName')">Invite Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('inviteSerial')"><span v-text="$t('hotelgaServerApp.inviteCard.inviteSerial')">Invite Serial</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('inviteCreateDt')"><span v-text="$t('hotelgaServerApp.inviteCard.inviteCreateDt')">Invite Create Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('inviteExpirationDt')"><span v-text="$t('hotelgaServerApp.inviteCard.inviteExpirationDt')">Invite Expiration Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('managerName')"><span v-text="$t('hotelgaServerApp.inviteCard.managerName')">Manager Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('accommodationName')"><span v-text="$t('hotelgaServerApp.inviteCard.accommodationName')">Accommodation Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('inflowNum')"><span v-text="$t('hotelgaServerApp.inviteCard.inflowNum')">Inflow Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('reservationNum')"><span v-text="$t('hotelgaServerApp.inviteCard.reservationNum')">Reservation Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('managerId')"><span v-text="$t('hotelgaServerApp.inviteCard.managerId')">Manager Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('accommodationId')"><span v-text="$t('hotelgaServerApp.inviteCard.accommodationId')">Accommodation Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('inviteCardState')"><span v-text="$t('hotelgaServerApp.inviteCard.inviteCardState')">Invite Card State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="inviteCard in inviteCards"
                    :key="inviteCard.id">
                    <td>
                        <router-link :to="{name: 'InviteCardView', params: {inviteCardId: inviteCard.id}}">{{inviteCard.id}}</router-link>
                    </td>
                    <td>{{inviteCard.inviteName}}</td>
                    <td>{{inviteCard.inviteSerial}}</td>
                    <td>{{inviteCard.inviteCreateDt | formatDate}}</td>
                    <td>{{inviteCard.inviteExpirationDt | formatDate}}</td>
                    <td>{{inviteCard.managerName}}</td>
                    <td>{{inviteCard.accommodationName}}</td>
                    <td>{{inviteCard.inflowNum}}</td>
                    <td>{{inviteCard.reservationNum}}</td>
                    <td>{{inviteCard.managerId}}</td>
                    <td>{{inviteCard.accommodationId}}</td>
                    <td v-text="$t('hotelgaServerApp.InviteCardState.' + inviteCard.inviteCardState)">{{inviteCard.inviteCardState}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'InviteCardView', params: {inviteCardId: inviteCard.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'InviteCardEdit', params: {inviteCardId: inviteCard.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(inviteCard)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.inviteCard.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-inviteCard-heading" v-bind:title="$t('hotelgaServerApp.inviteCard.delete.question')">Are you sure you want to delete this Invite Card?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-inviteCard" v-text="$t('entity.action.delete')" v-on:click="removeInviteCard()">Delete</button>
            </div>
        </b-modal>
        <div v-show="inviteCards && inviteCards.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./invite-card.component.ts">
</script>
