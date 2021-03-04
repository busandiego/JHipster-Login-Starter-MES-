import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { CouponPublishedHistories, ICouponPublishedHistories } from '@/shared/model/coupon-published-histories.model';
import CouponPublishedHistoriesService from './coupon-published-histories.service';

const validations: any = {
  couponPublishedHistories: {
    publishedName: {
      required
    },
    totalPublishedNum: {},
    oneThousandNum: {},
    threeThousandNum: {},
    fiveThousandNum: {},
    sevenThousandNum: {},
    tenThousandNum: {},
    autoPublishedNum: {},
    totalPublishedPrice: {},
    publishedDt: {},
    expireDt: {},
    CouponPublishedHistoriesState: {
      required
    }
  }
};

@Component({
  validations
})
export default class CouponPublishedHistoriesUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('couponPublishedHistoriesService') private couponPublishedHistoriesService: () => CouponPublishedHistoriesService;
  public couponPublishedHistories: ICouponPublishedHistories = new CouponPublishedHistories();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.couponPublishedHistoriesId) {
        vm.retrieveCouponPublishedHistories(to.params.couponPublishedHistoriesId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.couponPublishedHistories.id) {
      this.couponPublishedHistoriesService()
        .update(this.couponPublishedHistories)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.couponPublishedHistories.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.couponPublishedHistoriesService()
        .create(this.couponPublishedHistories)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.couponPublishedHistories.created', { param: param.id });
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
      this.couponPublishedHistories[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.couponPublishedHistories[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.couponPublishedHistories[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.couponPublishedHistories[field] = null;
    }
  }

  public retrieveCouponPublishedHistories(couponPublishedHistoriesId): void {
    this.couponPublishedHistoriesService()
      .find(couponPublishedHistoriesId)
      .then(res => {
        res.publishedDt = new Date(res.publishedDt);
        res.expireDt = new Date(res.expireDt);
        this.couponPublishedHistories = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
