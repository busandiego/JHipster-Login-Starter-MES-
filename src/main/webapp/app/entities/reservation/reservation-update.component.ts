import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IReservation, Reservation } from '@/shared/model/reservation.model';
import ReservationService from './reservation.service';

const validations: any = {
  reservation: {
    orderUniqNum: {
      required
    },
    orderUserName: {
      required
    },
    orderUserNum: {
      required
    },
    transportation: {},
    accommodationName: {},
    roomName: {},
    reservationPrice: {},
    roomDiscountPer: {},
    couponApply: {},
    couponName: {},
    couponDiscountPrice: {},
    couponType: {},
    paymentPrice: {},
    paymentType: {},
    affiliateCommission: {},
    managerCommission: {},
    investmentCommission: {},
    useStartTime: {},
    useEndTime: {},
    orderCreateDt: {
      required
    },
    checkInDt: {},
    checkOutDt: {},
    orderState: {},
    hoMemberId: {},
    managerId: {},
    affiliateId: {},
    accommodationId: {}
  }
};

@Component({
  validations
})
export default class ReservationUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('reservationService') private reservationService: () => ReservationService;
  public reservation: IReservation = new Reservation();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.reservationId) {
        vm.retrieveReservation(to.params.reservationId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.reservation.id) {
      this.reservationService()
        .update(this.reservation)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.reservation.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.reservationService()
        .create(this.reservation)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.reservation.created', { param: param.id });
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
      this.reservation[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.reservation[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.reservation[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.reservation[field] = null;
    }
  }

  public retrieveReservation(reservationId): void {
    this.reservationService()
      .find(reservationId)
      .then(res => {
        res.useStartTime = new Date(res.useStartTime);
        res.useEndTime = new Date(res.useEndTime);
        res.orderCreateDt = new Date(res.orderCreateDt);
        res.checkInDt = new Date(res.checkInDt);
        res.checkOutDt = new Date(res.checkOutDt);
        this.reservation = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
