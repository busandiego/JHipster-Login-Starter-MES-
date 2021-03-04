import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IPublishedCouponInfo, PublishedCouponInfo } from '@/shared/model/published-coupon-info.model';
import PublishedCouponInfoService from './published-coupon-info.service';

const validations: any = {
  publishedCouponInfo: {
    publishedCouponName: {
      required
    },
    publishedCouponType: {
      required
    },
    publishedCouponAllUse: {},
    publishedCouponUseAffiliateId: {},
    publishedCouponAmountType: {},
    publishedCouponDuplication: {},
    publishedCouponAutoPublish: {},
    publishedCouponUseTypeLimit: {},
    publishedCouponUseType: {},
    publishedCouponUsePriceLimit: {},
    publishedCouponUsePrice: {},
    publishedCouponUseExpireLimit: {},
    publishedCouponUseExpireMonth: {},
    publishedCouponCreateDt: {},
    publishedCouponUpdateDt: {},
    publishedCouponCurrentPublishedDt: {},
    publishedCouponAmountNum: {},
    publishedCouponSoldNum: {},
    couponState: {
      required
    },
    couponPublishedHistoriesId: {}
  }
};

@Component({
  validations
})
export default class PublishedCouponInfoUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('publishedCouponInfoService') private publishedCouponInfoService: () => PublishedCouponInfoService;
  public publishedCouponInfo: IPublishedCouponInfo = new PublishedCouponInfo();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.publishedCouponInfoId) {
        vm.retrievePublishedCouponInfo(to.params.publishedCouponInfoId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.publishedCouponInfo.id) {
      this.publishedCouponInfoService()
        .update(this.publishedCouponInfo)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.publishedCouponInfo.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.publishedCouponInfoService()
        .create(this.publishedCouponInfo)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.publishedCouponInfo.created', { param: param.id });
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
      this.publishedCouponInfo[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.publishedCouponInfo[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.publishedCouponInfo[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.publishedCouponInfo[field] = null;
    }
  }

  public retrievePublishedCouponInfo(publishedCouponInfoId): void {
    this.publishedCouponInfoService()
      .find(publishedCouponInfoId)
      .then(res => {
        res.publishedCouponCreateDt = new Date(res.publishedCouponCreateDt);
        res.publishedCouponUpdateDt = new Date(res.publishedCouponUpdateDt);
        res.publishedCouponCurrentPublishedDt = new Date(res.publishedCouponCurrentPublishedDt);
        this.publishedCouponInfo = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
