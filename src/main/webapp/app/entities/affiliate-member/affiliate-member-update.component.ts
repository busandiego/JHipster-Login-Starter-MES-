import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { AffiliateMember, IAffiliateMember } from '@/shared/model/affiliate-member.model';
import AffiliateMemberService from './affiliate-member.service';

const validations: any = {
  affiliateMember: {
    affiliateMemberLoginId: {
      required
    },
    affiliateMemberPassword: {
      required
    },
    affiliateMemberName: {
      required
    },
    affiliateMemberPhoneNum: {
      required
    },
    affiliateMemberMemo: {},
    pushToken: {},
    createDt: {},
    updateDt: {},
    affiliateMemberState: {},
    affiliateId: {}
  }
};

@Component({
  validations
})
export default class AffiliateMemberUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('affiliateMemberService') private affiliateMemberService: () => AffiliateMemberService;
  public affiliateMember: IAffiliateMember = new AffiliateMember();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.affiliateMemberId) {
        vm.retrieveAffiliateMember(to.params.affiliateMemberId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.affiliateMember.id) {
      this.affiliateMemberService()
        .update(this.affiliateMember)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.affiliateMember.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.affiliateMemberService()
        .create(this.affiliateMember)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.affiliateMember.created', { param: param.id });
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
      this.affiliateMember[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.affiliateMember[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.affiliateMember[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.affiliateMember[field] = null;
    }
  }

  public retrieveAffiliateMember(affiliateMemberId): void {
    this.affiliateMemberService()
      .find(affiliateMemberId)
      .then(res => {
        res.createDt = new Date(res.createDt);
        res.updateDt = new Date(res.updateDt);
        this.affiliateMember = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
