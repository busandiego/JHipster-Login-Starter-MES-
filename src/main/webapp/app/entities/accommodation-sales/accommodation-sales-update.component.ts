import { Component, Inject, Vue } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';
import { AccommodationSales, IAccommodationSales } from '@/shared/model/accommodation-sales.model';
import AccommodationSalesService from './accommodation-sales.service';

const validations: any = {
  accommodationSales: {
    accommodationId: {},
    adminUserId: {}
  }
};

@Component({
  validations
})
export default class AccommodationSalesUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('accommodationSalesService') private accommodationSalesService: () => AccommodationSalesService;
  public accommodationSales: IAccommodationSales = new AccommodationSales();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.accommodationSalesId) {
        vm.retrieveAccommodationSales(to.params.accommodationSalesId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.accommodationSales.id) {
      this.accommodationSalesService()
        .update(this.accommodationSales)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.accommodationSales.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.accommodationSalesService()
        .create(this.accommodationSales)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.accommodationSales.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveAccommodationSales(accommodationSalesId): void {
    this.accommodationSalesService()
      .find(accommodationSalesId)
      .then(res => {
        this.accommodationSales = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
