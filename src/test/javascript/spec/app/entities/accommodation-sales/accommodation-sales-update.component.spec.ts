/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import AccommodationSalesUpdateComponent from '@/entities/accommodation-sales/accommodation-sales-update.vue';
import AccommodationSalesClass from '@/entities/accommodation-sales/accommodation-sales-update.component';
import AccommodationSalesService from '@/entities/accommodation-sales/accommodation-sales.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('AccommodationSales Management Update Component', () => {
    let wrapper: Wrapper<AccommodationSalesClass>;
    let comp: AccommodationSalesClass;
    let accommodationSalesServiceStub: SinonStubbedInstance<AccommodationSalesService>;

    beforeEach(() => {
      accommodationSalesServiceStub = sinon.createStubInstance<AccommodationSalesService>(AccommodationSalesService);

      wrapper = shallowMount<AccommodationSalesClass>(AccommodationSalesUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          accommodationSalesService: () => accommodationSalesServiceStub
        }
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.accommodationSales = entity;
        accommodationSalesServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(accommodationSalesServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.accommodationSales = entity;
        accommodationSalesServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(accommodationSalesServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
