import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { Coupon, ICoupon } from '@/shared/model/coupon.model';
import CouponService from './coupon.service';

const validations: any = {
  coupon: {
    couponName: {
      required
    },
    couponType: {
      required
    },
    couponAllUse: {},
    couponUseAffiliateId: {},
    couponAmountType: {},
    couponDuplication: {},
    couponAutoPublish: {},
    couponUseTypeLimit: {},
    couponUseType: {},
    couponUsePriceLimit: {},
    couponUsePrice: {},
    couponUseExpireLimit: {},
    couponUseExpireMonth: {},
    couponCreateDt: {},
    couponUpdateDt: {},
    couponCurrentPublishedDt: {},
    couponState: {
      required
    }
  }
};

@Component({
  validations
})
export default class CouponUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('couponService') private couponService: () => CouponService;
  public coupon: ICoupon = new Coupon();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.couponId) {
        vm.retrieveCoupon(to.params.couponId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.coupon.id) {
      this.couponService()
        .update(this.coupon)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.coupon.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.couponService()
        .create(this.coupon)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.coupon.created', { param: param.id });
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
      this.coupon[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.coupon[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.coupon[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.coupon[field] = null;
    }
  }

  public retrieveCoupon(couponId): void {
    this.couponService()
      .find(couponId)
      .then(res => {
        res.couponCreateDt = new Date(res.couponCreateDt);
        res.couponUpdateDt = new Date(res.couponUpdateDt);
        res.couponCurrentPublishedDt = new Date(res.couponCurrentPublishedDt);
        this.coupon = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
