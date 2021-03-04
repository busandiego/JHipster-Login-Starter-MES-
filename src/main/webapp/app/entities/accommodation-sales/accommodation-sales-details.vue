<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="accommodationSales">
                <h2 class="jh-entity-heading"><span v-text="$t('hotelgaServerApp.accommodationSales.detail.title')">AccommodationSales</span> {{accommodationSales.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('hotelgaServerApp.accommodationSales.accommodationId')">Accommodation Id</span>
                    </dt>
                    <dd>
                        <span>{{accommodationSales.accommodationId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('hotelgaServerApp.accommodationSales.adminUserId')">Admin User Id</span>
                    </dt>
                    <dd>
                        <span>{{accommodationSales.adminUserId}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="accommodationSales.id" :to="{name: 'AccommodationSalesEdit', params: {accommodationSalesId: accommodationSales.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./accommodation-sales-details.component.ts">
</script>
