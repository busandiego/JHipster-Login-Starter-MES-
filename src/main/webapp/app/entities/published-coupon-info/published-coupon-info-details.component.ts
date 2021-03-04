import { Component, Inject, Vue } from 'vue-property-decorator';

import { IPublishedCouponInfo } from '@/shared/model/published-coupon-info.model';
import PublishedCouponInfoService from './published-coupon-info.service';

@Component
export default class PublishedCouponInfoDetails extends Vue {
  @Inject('publishedCouponInfoService') private publishedCouponInfoService: () => PublishedCouponInfoService;
  public publishedCouponInfo: IPublishedCouponInfo = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.publishedCouponInfoId) {
        vm.retrievePublishedCouponInfo(to.params.publishedCouponInfoId);
      }
    });
  }

  public retrievePublishedCouponInfo(publishedCouponInfoId) {
    this.publishedCouponInfoService()
      .find(publishedCouponInfoId)
      .then(res => {
        this.publishedCouponInfo = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
