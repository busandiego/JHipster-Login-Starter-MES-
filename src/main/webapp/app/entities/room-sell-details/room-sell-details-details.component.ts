import { Component, Inject, Vue } from 'vue-property-decorator';

import { IRoomSellDetails } from '@/shared/model/room-sell-details.model';
import RoomSellDetailsService from './room-sell-details.service';

@Component
export default class RoomSellDetailsDetails extends Vue {
  @Inject('roomSellDetailsService') private roomSellDetailsService: () => RoomSellDetailsService;
  public roomSellDetails: IRoomSellDetails = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.roomSellDetailsId) {
        vm.retrieveRoomSellDetails(to.params.roomSellDetailsId);
      }
    });
  }

  public retrieveRoomSellDetails(roomSellDetailsId) {
    this.roomSellDetailsService()
      .find(roomSellDetailsId)
      .then(res => {
        this.roomSellDetails = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
