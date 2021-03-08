import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IBusiness, Business } from '@/shared/model/business.model';
import BusinessService from './business.service';

const validations: any = {
  business: {
    businessName: {
      required
    },
    businessRepresentative: {
      required
    },
    businessRegistrationNum: {},
    businessContactNum: {},
    businessType: {},
    businessAddress: {},
    businessCategory: {},
    businessFaxNum: {},
    isHeadquarter: {},
    createdDate: {}
  }
};

@Component({
  validations
})
export default class BusinessUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('businessService') private businessService: () => BusinessService;
  public business: IBusiness = new Business();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.businessId) {
        vm.retrieveBusiness(to.params.businessId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.business.id) {
      this.businessService()
        .update(this.business)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('wmesServerApp.business.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.businessService()
        .create(this.business)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('wmesServerApp.business.created', { param: param.id });
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
      this.business[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.business[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.business[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.business[field] = null;
    }
  }

  public retrieveBusiness(businessId): void {
    this.businessService()
      .find(businessId)
      .then(res => {
        res.createdDate = new Date(res.createdDate);
        this.business = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
