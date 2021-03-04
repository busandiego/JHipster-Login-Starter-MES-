import { Component, Inject, Vue } from 'vue-property-decorator';

import { required } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IInviteCard, InviteCard } from '@/shared/model/invite-card.model';
import InviteCardService from './invite-card.service';

const validations: any = {
  inviteCard: {
    inviteName: {
      required
    },
    inviteSerial: {},
    inviteCreateDt: {},
    inviteExpirationDt: {},
    managerName: {},
    accommodationName: {},
    inflowNum: {},
    reservationNum: {},
    managerId: {},
    accommodationId: {},
    inviteCardState: {
      required
    }
  }
};

@Component({
  validations
})
export default class InviteCardUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('inviteCardService') private inviteCardService: () => InviteCardService;
  public inviteCard: IInviteCard = new InviteCard();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.inviteCardId) {
        vm.retrieveInviteCard(to.params.inviteCardId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.inviteCard.id) {
      this.inviteCardService()
        .update(this.inviteCard)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.inviteCard.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.inviteCardService()
        .create(this.inviteCard)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('hotelgaServerApp.inviteCard.created', { param: param.id });
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
      this.inviteCard[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.inviteCard[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.inviteCard[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.inviteCard[field] = null;
    }
  }

  public retrieveInviteCard(inviteCardId): void {
    this.inviteCardService()
      .find(inviteCardId)
      .then(res => {
        res.inviteCreateDt = new Date(res.inviteCreateDt);
        res.inviteExpirationDt = new Date(res.inviteExpirationDt);
        this.inviteCard = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
