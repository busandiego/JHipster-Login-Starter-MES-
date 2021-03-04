import { Component, Inject, Vue } from 'vue-property-decorator';

import { numeric, required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IPayment, Payment } from '@/shared/model/payment.model';
import PaymentService from './payment.service';

const validations: any = {
  payment: {
    sellingPrice: {
      required,
      numeric
    },
    commission: {
      required,
      numeric
    },
    paymentMoney: {
      required,
      numeric
    },
    paymentType: {
      required
    },
    paymentDt: {
      required
    },
    couponDiscount: {},
    transactionNum: {},
    paymentMethod: {},
    remark: {},
    reservationId: {},
    paymentState: {
      required
    }
  }
};

@Component({
  validations
})
export default class PaymentUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('paymentService') private paymentService: () => PaymentService;
  public payment: IPayment = new Payment();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.paymentId) {
        vm.retrievePayment(to.params.paymentId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.payment.id) {
      this.paymentService()
        .update(this.payment)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.payment.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.paymentService()
        .create(this.payment)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.payment.created', { param: param.id });
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
      this.payment[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.payment[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.payment[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.payment[field] = null;
    }
  }

  public retrievePayment(paymentId): void {
    this.paymentService()
      .find(paymentId)
      .then(res => {
        res.paymentDt = new Date(res.paymentDt);
        this.payment = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
