import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IRoomSellDetails, RoomSellDetails } from '@/shared/model/room-sell-details.model';
import RoomSellDetailsService from './room-sell-details.service';

const validations: any = {
  roomSellDetails: {
    sellDt: {
      required
    },
    sellAmount: {},
    sellSoldNum: {},
    sellStartTime: {},
    sellEndTime: {},
    sellUseTime: {},
    couponBoolean: {},
    sellState: {}
  }
};

@Component({
  validations
})
export default class RoomSellDetailsUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('roomSellDetailsService') private roomSellDetailsService: () => RoomSellDetailsService;
  public roomSellDetails: IRoomSellDetails = new RoomSellDetails();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.roomSellDetailsId) {
        vm.retrieveRoomSellDetails(to.params.roomSellDetailsId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.roomSellDetails.id) {
      this.roomSellDetailsService()
        .update(this.roomSellDetails)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.roomSellDetails.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.roomSellDetailsService()
        .create(this.roomSellDetails)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.roomSellDetails.created', { param: param.id });
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
      this.roomSellDetails[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.roomSellDetails[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.roomSellDetails[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.roomSellDetails[field] = null;
    }
  }

  public retrieveRoomSellDetails(roomSellDetailsId): void {
    this.roomSellDetailsService()
      .find(roomSellDetailsId)
      .then(res => {
        res.sellDt = new Date(res.sellDt);
        this.roomSellDetails = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
