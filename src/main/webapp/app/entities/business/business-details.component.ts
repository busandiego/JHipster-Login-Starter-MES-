import { Component, Vue, Inject } from 'vue-property-decorator';

import { IBusiness } from '@/shared/model/business.model';
import BusinessService from './business.service';

@Component
export default class BusinessDetails extends Vue {
  @Inject('businessService') private businessService: () => BusinessService;
  public business: IBusiness = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.businessId) {
        vm.retrieveBusiness(to.params.businessId);
      }
    });
  }

  public retrieveBusiness(businessId) {
    this.businessService()
      .find(businessId)
      .then(res => {
        this.business = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
