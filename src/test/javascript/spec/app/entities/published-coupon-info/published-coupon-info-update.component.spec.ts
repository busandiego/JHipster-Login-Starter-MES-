/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import format from 'date-fns/format';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import PublishedCouponInfoUpdateComponent from '@/entities/published-coupon-info/published-coupon-info-update.vue';
import PublishedCouponInfoClass from '@/entities/published-coupon-info/published-coupon-info-update.component';
import PublishedCouponInfoService from '@/entities/published-coupon-info/published-coupon-info.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('PublishedCouponInfo Management Update Component', () => {
    let wrapper: Wrapper<PublishedCouponInfoClass>;
    let comp: PublishedCouponInfoClass;
    let publishedCouponInfoServiceStub: SinonStubbedInstance<PublishedCouponInfoService>;

    beforeEach(() => {
      publishedCouponInfoServiceStub = sinon.createStubInstance<PublishedCouponInfoService>(PublishedCouponInfoService);

      wrapper = shallowMount<PublishedCouponInfoClass>(PublishedCouponInfoUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          publishedCouponInfoService: () => publishedCouponInfoServiceStub
        }
      });
      comp = wrapper.vm;
    });

    describe('load', () => {
      it('Should convert date from string', () => {
        // GIVEN
        const date = new Date('2019-10-15T11:42:02Z');

        // WHEN
        const convertedDate = comp.convertDateTimeFromServer(date);

        // THEN
        expect(convertedDate).toEqual(format(date, DATE_TIME_LONG_FORMAT));
      });

      it('Should not convert date if date is not present', () => {
        expect(comp.convertDateTimeFromServer(null)).toBeNull();
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.publishedCouponInfo = entity;
        publishedCouponInfoServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(publishedCouponInfoServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.publishedCouponInfo = entity;
        publishedCouponInfoServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(publishedCouponInfoServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
