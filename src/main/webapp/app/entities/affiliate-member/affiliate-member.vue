<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('hotelgaServerApp.affiliateMember.home.title')" id="affiliate-member-heading">Affiliate Members</span>
            <router-link :to="{name: 'AffiliateMemberCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-affiliate-member">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('hotelgaServerApp.affiliateMember.home.createLabel')">
                    Create a new Affiliate Member
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
        <div class="alert alert-warning" v-if="!isFetching && affiliateMembers && affiliateMembers.length === 0">
            <span v-text="$t('hotelgaServerApp.affiliateMember.home.notFound')">No affiliateMembers found</span>
        </div>
        <div class="table-responsive" v-if="affiliateMembers && affiliateMembers.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateMemberLoginId')"><span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberLoginId')">Affiliate Member Login Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateMemberPassword')"><span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberPassword')">Affiliate Member Password</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateMemberName')"><span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberName')">Affiliate Member Name</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateMemberPhoneNum')"><span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberPhoneNum')">Affiliate Member Phone Num</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateMemberMemo')"><span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberMemo')">Affiliate Member Memo</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('pushToken')"><span v-text="$t('hotelgaServerApp.affiliateMember.pushToken')">Push Token</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('createDt')"><span v-text="$t('hotelgaServerApp.affiliateMember.createDt')">Create Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('updateDt')"><span v-text="$t('hotelgaServerApp.affiliateMember.updateDt')">Update Dt</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateMemberState')"><span v-text="$t('hotelgaServerApp.affiliateMember.affiliateMemberState')">Affiliate Member State</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('affiliateId')"><span v-text="$t('hotelgaServerApp.affiliateMember.affiliateId')">Affiliate Id</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="affiliateMember in affiliateMembers"
                    :key="affiliateMember.id">
                    <td>
                        <router-link :to="{name: 'AffiliateMemberView', params: {affiliateMemberId: affiliateMember.id}}">{{affiliateMember.id}}</router-link>
                    </td>
                    <td>{{affiliateMember.affiliateMemberLoginId}}</td>
                    <td>{{affiliateMember.affiliateMemberPassword}}</td>
                    <td>{{affiliateMember.affiliateMemberName}}</td>
                    <td>{{affiliateMember.affiliateMemberPhoneNum}}</td>
                    <td>{{affiliateMember.affiliateMemberMemo}}</td>
                    <td>{{affiliateMember.pushToken}}</td>
                    <td>{{affiliateMember.createDt | formatDate}}</td>
                    <td>{{affiliateMember.updateDt | formatDate}}</td>
                    <td v-text="$t('hotelgaServerApp.StateAffiliateMember.' + affiliateMember.affiliateMemberState)">{{affiliateMember.affiliateMemberState}}</td>
                    <td>{{affiliateMember.affiliateId}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'AffiliateMemberView', params: {affiliateMemberId: affiliateMember.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'AffiliateMemberEdit', params: {affiliateMemberId: affiliateMember.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(affiliateMember)"
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
            <span slot="modal-title"><span id="hotelgaServerApp.affiliateMember.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-affiliateMember-heading" v-bind:title="$t('hotelgaServerApp.affiliateMember.delete.question')">Are you sure you want to delete this Affiliate Member?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-affiliateMember" v-text="$t('entity.action.delete')" v-on:click="removeAffiliateMember()">Delete</button>
            </div>
        </b-modal>
        <div v-show="affiliateMembers && affiliateMembers.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./affiliate-member.component.ts">
</script>
