/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CouponPublishedHistoriesDetailComponent from '@/entities/coupon-published-histories/coupon-published-histories-details.vue';
import CouponPublishedHistoriesClass from '@/entities/coupon-published-histories/coupon-published-histories-details.component';
import CouponPublishedHistoriesService from '@/entities/coupon-published-histories/coupon-published-histories.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('CouponPublishedHistories Management Detail Component', () => {
    let wrapper: Wrapper<CouponPublishedHistoriesClass>;
    let comp: CouponPublishedHistoriesClass;
    let couponPublishedHistoriesServiceStub: SinonStubbedInstance<CouponPublishedHistoriesService>;

    beforeEach(() => {
      couponPublishedHistoriesServiceStub = sinon.createStubInstance<CouponPublishedHistoriesService>(CouponPublishedHistoriesService);

      wrapper = shallowMount<CouponPublishedHistoriesClass>(CouponPublishedHistoriesDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { couponPublishedHistoriesService: () => couponPublishedHistoriesServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCouponPublishedHistories = { id: 123 };
        couponPublishedHistoriesServiceStub.find.resolves(foundCouponPublishedHistories);

        // WHEN
        comp.retrieveCouponPublishedHistories(123);
        await comp.$nextTick();

        // THEN
        expect(comp.couponPublishedHistories).toBe(foundCouponPublishedHistories);
      });
    });
  });
});
