import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { ApplyInviteCard, IApplyInviteCard } from '@/shared/model/apply-invite-card.model';
import ApplyInviteCardService from './apply-invite-card.service';

const validations: any = {
  applyInviteCard: {
    inviteName: {
      required
    },
    applyCardDt: {},
    managerName: {},
    accommodationName: {},
    managerPhoneNum: {},
    applyAmountNum: {},
    managerId: {},
    accommodationId: {},
    applyInviteCardState: {
      required
    }
  }
};

@Component({
  validations
})
export default class ApplyInviteCardUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('applyInviteCardService') private applyInviteCardService: () => ApplyInviteCardService;
  public applyInviteCard: IApplyInviteCard = new ApplyInviteCard();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.applyInviteCardId) {
        vm.retrieveApplyInviteCard(to.params.applyInviteCardId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.applyInviteCard.id) {
      this.applyInviteCardService()
        .update(this.applyInviteCard)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.applyInviteCard.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.applyInviteCardService()
        .create(this.applyInviteCard)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.applyInviteCard.created', { param: param.id });
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
      this.applyInviteCard[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.applyInviteCard[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.applyInviteCard[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.applyInviteCard[field] = null;
    }
  }

  public retrieveApplyInviteCard(applyInviteCardId): void {
    this.applyInviteCardService()
      .find(applyInviteCardId)
      .then(res => {
        res.applyCardDt = new Date(res.applyCardDt);
        this.applyInviteCard = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
