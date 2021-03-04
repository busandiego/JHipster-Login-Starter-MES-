import { Component, Inject, Vue } from 'vue-property-decorator';

import { IPublishedCouponHistories } from '@/shared/model/published-coupon-histories.model';
import PublishedCouponHistoriesService from './published-coupon-histories.service';

@Component
export default class PublishedCouponHistoriesDetails extends Vue {
  @Inject('publishedCouponHistoriesService') private publishedCouponHistoriesService: () => PublishedCouponHistoriesService;
  public publishedCouponHistories: IPublishedCouponHistories = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.publishedCouponHistoriesId) {
        vm.retrievePublishedCouponHistories(to.params.publishedCouponHistoriesId);
      }
    });
  }

  public retrievePublishedCouponHistories(publishedCouponHistoriesId) {
    this.publishedCouponHistoriesService()
      .find(publishedCouponHistoriesId)
      .then(res => {
        this.publishedCouponHistories = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
