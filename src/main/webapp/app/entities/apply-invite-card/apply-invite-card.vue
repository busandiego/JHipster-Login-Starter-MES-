<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.applyInviteCard.home.title')" id="apply-invite-card-heading">Apply Invite Cards</span>
            <router-link :to="{name: 'ApplyInviteCardCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-apply-invite-card">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.applyInviteCard.home.createLabel')">
                    Create a new Apply Invite Card
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
        <div class="alert alert-warning" v-if="!isFetching && applyInviteCards && applyInviteCards.length === 0">
            <span v-text="$t('hotelgaServerApp.applyInviteCard.home.notFound')">No applyInviteCards found</span>
        </div>
        <div class="table-responsive" v-if="applyInviteCards && applyInviteCards.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('inviteName')"><span v-text="$t('hotelgaServerApp.applyInviteCard.inviteName')">Invite Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('applyCardDt')"><span v-text="$t('hotelgaServerApp.applyInviteCard.applyCardDt')">Apply Card Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('managerName')"><span v-text="$t('hotelgaServerApp.applyInviteCard.managerName')">Manager Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('accommodationName')"><span v-text="$t('hotelgaServerApp.applyInviteCard.accommodationName')">Accommodation Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('managerPhoneNum')"><span v-text="$t('hotelgaServerApp.applyInviteCard.managerPhoneNum')">Manager Phone Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('applyAmountNum')"><span v-text="$t('hotelgaServerApp.applyInviteCard.applyAmountNum')">Apply Amount Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('managerId')"><span v-text="$t('hotelgaServerApp.applyInviteCard.managerId')">Manager Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('accommodationId')"><span v-text="$t('hotelgaServerApp.applyInviteCard.accommodationId')">Accommodation Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('applyInviteCardState')"><span v-text="$t('hotelgaServerApp.applyInviteCard.applyInviteCardState')">Apply Invite Card State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="applyInviteCard in applyInviteCards"
                    :key="applyInviteCard.id">
                    <td>
                        <router-link :to="{name: 'ApplyInviteCardView', params: {applyInviteCardId: applyInviteCard.id}}">{{applyInviteCard.id}}</router-link>
                    </td>
                    <td>{{applyInviteCard.inviteName}}</td>
                    <td>{{applyInviteCard.applyCardDt | formatDate}}</td>
                    <td>{{applyInviteCard.managerName}}</td>
                    <td>{{applyInviteCard.accommodationName}}</td>
                    <td>{{applyInviteCard.managerPhoneNum}}</td>
                    <td>{{applyInviteCard.applyAmountNum}}</td>
                    <td>{{applyInviteCard.managerId}}</td>
                    <td>{{applyInviteCard.accommodationId}}</td>
                    <td v-text="$t('hotelgaServerApp.ApplyInviteCardState.' + applyInviteCard.applyInviteCardState)">{{applyInviteCard.applyInviteCardState}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'ApplyInviteCardView', params: {applyInviteCardId: applyInviteCard.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'ApplyInviteCardEdit', params: {applyInviteCardId: applyInviteCard.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(applyInviteCard)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.applyInviteCard.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-applyInviteCard-heading" v-bind:title="$t('hotelgaServerApp.applyInviteCard.delete.question')">Are you sure you want to delete this Apply Invite Card?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-applyInviteCard" v-text="$t('entity.action.delete')" v-on:click="removeApplyInviteCard()">Delete</button>
            </div>
        </b-modal>
        <div v-show="applyInviteCards && applyInviteCards.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./apply-invite-card.component.ts">
</script>
