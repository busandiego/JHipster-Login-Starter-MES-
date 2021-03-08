import { mixins } from 'vue-class-component';

import { Component, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IBusiness } from '@/shared/model/business.model';
import AlertService from '@/shared/alert/alert.service';

import BusinessService from './business.service';

@Component
export default class Business extends mixins(Vue2Filters.mixin) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('businessService') private businessService: () => BusinessService;
  private removeId: number = null;
  public businesses: IBusiness[] = [];

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
    this.retrieveAllBusinesss();
  }

  public clear(): void {
    this.retrieveAllBusinesss();
  }

  public retrieveAllBusinesss(): void {
    this.isFetching = true;

    this.businessService()
      .retrieve()
      .then(
        res => {
          this.businesses = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IBusiness): void {
    this.removeId = instance.id;
  }

  public removeBusiness(): void {
    this.businessService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('wmesServerApp.business.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();

        this.removeId = null;
        this.retrieveAllBusinesss();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
