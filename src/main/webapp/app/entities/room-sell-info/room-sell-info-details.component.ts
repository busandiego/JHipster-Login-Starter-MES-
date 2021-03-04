import { Component, Inject, Vue } from 'vue-property-decorator';

import { IRoomSellInfo } from '@/shared/model/room-sell-info.model';
import RoomSellInfoService from './room-sell-info.service';

@Component
export default class RoomSellInfoDetails extends Vue {
  @Inject('roomSellInfoService') private roomSellInfoService: () => RoomSellInfoService;
  public roomSellInfo: IRoomSellInfo = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.roomSellInfoId) {
        vm.retrieveRoomSellInfo(to.params.roomSellInfoId);
      }
    });
  }

  public retrieveRoomSellInfo(roomSellInfoId) {
    this.roomSellInfoService()
      .find(roomSellInfoId)
      .then(res => {
        this.roomSellInfo = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
