import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IPublishedCouponHistories, PublishedCouponHistories } from '@/shared/model/published-coupon-histories.model';
import PublishedCouponHistoriesService from './published-coupon-histories.service';

const validations: any = {
  publishedCouponHistories: {
    publishedUniqCode: {
      required
    },
    publishedCouponAmountType: {},
    useDt: {},
    publishedCouponAllUse: {},
    publishedCouponUseAffiliateId: {},
    publishedDt: {},
    useCheck: {
      required
    },
    couponPublishedHistoriesId: {}
  }
};

@Component({
  validations
})
export default class PublishedCouponHistoriesUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('publishedCouponHistoriesService') private publishedCouponHistoriesService: () => PublishedCouponHistoriesService;
  public publishedCouponHistories: IPublishedCouponHistories = new PublishedCouponHistories();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.publishedCouponHistoriesId) {
        vm.retrievePublishedCouponHistories(to.params.publishedCouponHistoriesId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.publishedCouponHistories.id) {
      this.publishedCouponHistoriesService()
        .update(this.publishedCouponHistories)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.publishedCouponHistories.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.publishedCouponHistoriesService()
        .create(this.publishedCouponHistories)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.publishedCouponHistories.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public convertDateTimeFromServer(date: Date): string {
    if (date) {
      return format(date, DATE_TIME_LONG_FORMAT);
    }
    return null;
  }

  public updateInstantField(field, event) {
    if (event.target.value) {
      this.publishedCouponHistories[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.publishedCouponHistories[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.publishedCouponHistories[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.publishedCouponHistories[field] = null;
    }
  }

  public retrievePublishedCouponHistories(publishedCouponHistoriesId): void {
    this.publishedCouponHistoriesService()
      .find(publishedCouponHistoriesId)
      .then(res => {
        res.useDt = new Date(res.useDt);
        res.publishedDt = new Date(res.publishedDt);
        this.publishedCouponHistories = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
