import { Component, Inject, Vue } from 'vue-property-decorator';

import { ICouponPublishedHistories } from '@/shared/model/coupon-published-histories.model';
import CouponPublishedHistoriesService from './coupon-published-histories.service';

@Component
export default class CouponPublishedHistoriesDetails extends Vue {
  @Inject('couponPublishedHistoriesService') private couponPublishedHistoriesService: () => CouponPublishedHistoriesService;
  public couponPublishedHistories: ICouponPublishedHistories = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.couponPublishedHistoriesId) {
        vm.retrieveCouponPublishedHistories(to.params.couponPublishedHistoriesId);
      }
    });
  }

  public retrieveCouponPublishedHistories(couponPublishedHistoriesId) {
    this.couponPublishedHistoriesService()
      .find(couponPublishedHistoriesId)
      .then(res => {
        this.couponPublishedHistories = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
