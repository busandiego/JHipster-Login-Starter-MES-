/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import BusinessDetailComponent from '@/entities/business/business-details.vue';
import BusinessClass from '@/entities/business/business-details.component';
import BusinessService from '@/entities/business/business.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Business Management Detail Component', () => {
    let wrapper: Wrapper<BusinessClass>;
    let comp: BusinessClass;
    let businessServiceStub: SinonStubbedInstance<BusinessService>;

    beforeEach(() => {
      businessServiceStub = sinon.createStubInstance<BusinessService>(BusinessService);

      wrapper = shallowMount<BusinessClass>(BusinessDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { businessService: () => businessServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundBusiness = { id: 123 };
        businessServiceStub.find.resolves(foundBusiness);

        // WHEN
        comp.retrieveBusiness(123);
        await comp.$nextTick();

        // THEN
        expect(comp.business).toBe(foundBusiness);
      });
    });
  });
});
