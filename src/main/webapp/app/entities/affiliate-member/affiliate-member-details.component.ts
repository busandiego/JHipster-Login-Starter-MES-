import { Component, Inject, Vue } from 'vue-property-decorator';

import { IAffiliateMember } from '@/shared/model/affiliate-member.model';
import AffiliateMemberService from './affiliate-member.service';

@Component
export default class AffiliateMemberDetails extends Vue {
  @Inject('affiliateMemberService') private affiliateMemberService: () => AffiliateMemberService;
  public affiliateMember: IAffiliateMember = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.affiliateMemberId) {
        vm.retrieveAffiliateMember(to.params.affiliateMemberId);
      }
    });
  }

  public retrieveAffiliateMember(affiliateMemberId) {
    this.affiliateMemberService()
      .find(affiliateMemberId)
      .then(res => {
        this.affiliateMember = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
