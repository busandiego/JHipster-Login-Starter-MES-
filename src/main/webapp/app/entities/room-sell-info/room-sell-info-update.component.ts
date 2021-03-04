import { Component, Inject, Vue } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';
import { IRoomSellInfo, RoomSellInfo } from '@/shared/model/room-sell-info.model';
import RoomSellInfoService from './room-sell-info.service';

const validations: any = {
  roomSellInfo: {
    roomSalesType: {},
    roomId: {}
  }
};

@Component({
  validations
})
export default class RoomSellInfoUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('roomSellInfoService') private roomSellInfoService: () => RoomSellInfoService;
  public roomSellInfo: IRoomSellInfo = new RoomSellInfo();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.roomSellInfoId) {
        vm.retrieveRoomSellInfo(to.params.roomSellInfoId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.roomSellInfo.id) {
      this.roomSellInfoService()
        .update(this.roomSellInfo)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.roomSellInfo.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.roomSellInfoService()
        .create(this.roomSellInfo)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.roomSellInfo.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveRoomSellInfo(roomSellInfoId): void {
    this.roomSellInfoService()
      .find(roomSellInfoId)
      .then(res => {
        this.roomSellInfo = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
