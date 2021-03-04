/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import AccommodationSalesDetailComponent from '@/entities/accommodation-sales/accommodation-sales-details.vue';
import AccommodationSalesClass from '@/entities/accommodation-sales/accommodation-sales-details.component';
import AccommodationSalesService from '@/entities/accommodation-sales/accommodation-sales.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('AccommodationSales Management Detail Component', () => {
    let wrapper: Wrapper<AccommodationSalesClass>;
    let comp: AccommodationSalesClass;
    let accommodationSalesServiceStub: SinonStubbedInstance<AccommodationSalesService>;

    beforeEach(() => {
      accommodationSalesServiceStub = sinon.createStubInstance<AccommodationSalesService>(AccommodationSalesService);

      wrapper = shallowMount<AccommodationSalesClass>(AccommodationSalesDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { accommodationSalesService: () => accommodationSalesServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundAccommodationSales = { id: 123 };
        accommodationSalesServiceStub.find.resolves(foundAccommodationSales);

        // WHEN
        comp.retrieveAccommodationSales(123);
        await comp.$nextTick();

        // THEN
        expect(comp.accommodationSales).toBe(foundAccommodationSales);
      });
    });
  });
});
