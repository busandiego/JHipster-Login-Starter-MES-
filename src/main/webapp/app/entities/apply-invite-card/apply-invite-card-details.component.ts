import { Component, Inject, Vue } from 'vue-property-decorator';

import { IApplyInviteCard } from '@/shared/model/apply-invite-card.model';
import ApplyInviteCardService from './apply-invite-card.service';

@Component
export default class ApplyInviteCardDetails extends Vue {
  @Inject('applyInviteCardService') private applyInviteCardService: () => ApplyInviteCardService;
  public applyInviteCard: IApplyInviteCard = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.applyInviteCardId) {
        vm.retrieveApplyInviteCard(to.params.applyInviteCardId);
      }
    });
  }

  public retrieveApplyInviteCard(applyInviteCardId) {
    this.applyInviteCardService()
      .find(applyInviteCardId)
      .then(res => {
        this.applyInviteCard = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
