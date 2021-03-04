import { Component, Inject, Vue } from 'vue-property-decorator';

import { IInviteCard } from '@/shared/model/invite-card.model';
import InviteCardService from './invite-card.service';

@Component
export default class InviteCardDetails extends Vue {
  @Inject('inviteCardService') private inviteCardService: () => InviteCardService;
  public inviteCard: IInviteCard = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.inviteCardId) {
        vm.retrieveInviteCard(to.params.inviteCardId);
      }
    });
  }

  public retrieveInviteCard(inviteCardId) {
    this.inviteCardService()
      .find(inviteCardId)
      .then(res => {
        this.inviteCard = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
