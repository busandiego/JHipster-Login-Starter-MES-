/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import BusinessComponent from '@/entities/business/business.vue';
import BusinessClass from '@/entities/business/business.component';
import BusinessService from '@/entities/business/business.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-alert', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {}
  }
};

describe('Component Tests', () => {
  describe('Business Management Component', () => {
    let wrapper: Wrapper<BusinessClass>;
    let comp: BusinessClass;
    let businessServiceStub: SinonStubbedInstance<BusinessService>;

    beforeEach(() => {
      businessServiceStub = sinon.createStubInstance<BusinessService>(BusinessService);
      businessServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<BusinessClass>(BusinessComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          businessService: () => businessServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      businessServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllBusinesss();
      await comp.$nextTick();

      // THEN
      expect(businessServiceStub.retrieve.called).toBeTruthy();
      expect(comp.businesses[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      businessServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeBusiness();
      await comp.$nextTick();

      // THEN
      expect(businessServiceStub.delete.called).toBeTruthy();
      expect(businessServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
