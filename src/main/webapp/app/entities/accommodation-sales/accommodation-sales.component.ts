import { mixins } from 'vue-class-component';

import { Component, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IAccommodationSales } from '@/shared/model/accommodation-sales.model';
import AlertService from '@/shared/alert/alert.service';

import AccommodationSalesService from './accommodation-sales.service';

@Component
export default class AccommodationSales extends mixins(Vue2Filters.mixin) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('accommodationSalesService') private accommodationSalesService: () => AccommodationSalesService;
  private removeId: number = null;
  public accommodationSales: IAccommodationSales[] = [];

  public isFetching = false;
  public dismissCountDown: number = this.$store.getters.dismissCountDown;
  public dismissSecs: number = this.$store.getters.dismissSecs;
  public alertType: string = this.$store.getters.alertType;
  public alertMessage: any = this.$store.getters.alertMessage;

  public getAlertFromStore() {
    this.dismissCountDown = this.$store.getters.dismissCountDown;
    this.dismissSecs = this.$store.getters.dismissSecs;
    this.alertType = this.$store.getters.alertType;
    this.alertMessage = this.$store.getters.alertMessage;
  }

  public countDownChanged(dismissCountDown: number) {
    this.alertService().countDownChanged(dismissCountDown);
    this.getAlertFromStore();
  }

  public mounted(): void {
    this.retrieveAllAccommodationSaless();
  }

  public clear(): void {
    this.retrieveAllAccommodationSaless();
  }

  public retrieveAllAccommodationSaless(): void {
    this.isFetching = true;

    this.accommodationSalesService()
      .retrieve()
      .then(
        res => {
          this.accommodationSales = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IAccommodationSales): void {
    this.removeId = instance.id;
  }

  public removeAccommodationSales(): void {
    this.accommodationSalesService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('hotelgaServerApp.accommodationSales.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();

        this.removeId = null;
        this.retrieveAllAccommodationSaless();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
