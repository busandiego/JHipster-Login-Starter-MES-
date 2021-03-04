/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import AccommodationSalesComponent from '@/entities/accommodation-sales/accommodation-sales.vue';
import AccommodationSalesClass from '@/entities/accommodation-sales/accommodation-sales.component';
import AccommodationSalesService from '@/entities/accommodation-sales/accommodation-sales.service';

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
  describe('AccommodationSales Management Component', () => {
    let wrapper: Wrapper<AccommodationSalesClass>;
    let comp: AccommodationSalesClass;
    let accommodationSalesServiceStub: SinonStubbedInstance<AccommodationSalesService>;

    beforeEach(() => {
      accommodationSalesServiceStub = sinon.createStubInstance<AccommodationSalesService>(AccommodationSalesService);
      accommodationSalesServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<AccommodationSalesClass>(AccommodationSalesComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          accommodationSalesService: () => accommodationSalesServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      accommodationSalesServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllAccommodationSaless();
      await comp.$nextTick();

      // THEN
      expect(accommodationSalesServiceStub.retrieve.called).toBeTruthy();
      expect(comp.accommodationSales[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      accommodationSalesServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeAccommodationSales();
      await comp.$nextTick();

      // THEN
      expect(accommodationSalesServiceStub.delete.called).toBeTruthy();
      expect(accommodationSalesServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
