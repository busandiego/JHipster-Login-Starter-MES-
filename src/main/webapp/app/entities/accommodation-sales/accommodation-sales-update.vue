<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="hotelgaServerApp.accommodationSales.home.createOrEditLabel" v-text="$t('hotelgaServerApp.accommodationSales.home.createOrEditLabel')">Create or edit a AccommodationSales</h2>
                <div>
                    <div class="form-group" v-if="accommodationSales.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="accommodationSales.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.accommodationSales.accommodationId')" for="accommodation-sales-accommodationId">Accommodation Id</label>
                        <input type="number" class="form-control" name="accommodationId" id="accommodation-sales-accommodationId"
                            :class="{'valid': !$v.accommodationSales.accommodationId.$invalid, 'invalid': $v.accommodationSales.accommodationId.$invalid }" v-model.number="$v.accommodationSales.accommodationId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('hotelgaServerApp.accommodationSales.adminUserId')" for="accommodation-sales-adminUserId">Admin User Id</label>
                        <input type="number" class="form-control" name="adminUserId" id="accommodation-sales-adminUserId"
                            :class="{'valid': !$v.accommodationSales.adminUserId.$invalid, 'invalid': $v.accommodationSales.adminUserId.$invalid }" v-model.number="$v.accommodationSales.adminUserId.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.accommodationSales.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./accommodation-sales-update.component.ts">
</script>
