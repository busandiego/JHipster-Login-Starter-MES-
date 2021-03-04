import { Component, Inject, Vue } from 'vue-property-decorator';

import { IAccommodationSales } from '@/shared/model/accommodation-sales.model';
import AccommodationSalesService from './accommodation-sales.service';

@Component
export default class AccommodationSalesDetails extends Vue {
  @Inject('accommodationSalesService') private accommodationSalesService: () => AccommodationSalesService;
  public accommodationSales: IAccommodationSales = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.accommodationSalesId) {
        vm.retrieveAccommodationSales(to.params.accommodationSalesId);
      }
    });
  }

  public retrieveAccommodationSales(accommodationSalesId) {
    this.accommodationSalesService()
      .find(accommodationSalesId)
      .then(res => {
        this.accommodationSales = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
