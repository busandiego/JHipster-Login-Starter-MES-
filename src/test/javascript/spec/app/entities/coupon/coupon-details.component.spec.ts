/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CouponDetailComponent from '@/entities/coupon/coupon-details.vue';
import CouponClass from '@/entities/coupon/coupon-details.component';
import CouponService from '@/entities/coupon/coupon.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Coupon Management Detail Component', () => {
    let wrapper: Wrapper<CouponClass>;
    let comp: CouponClass;
    let couponServiceStub: SinonStubbedInstance<CouponService>;

    beforeEach(() => {
      couponServiceStub = sinon.createStubInstance<CouponService>(CouponService);

      wrapper = shallowMount<CouponClass>(CouponDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { couponService: () => couponServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCoupon = { id: 123 };
        couponServiceStub.find.resolves(foundCoupon);

        // WHEN
        comp.retrieveCoupon(123);
        await comp.$nextTick();

        // THEN
        expect(comp.coupon).toBe(foundCoupon);
      });
    });
  });
});
