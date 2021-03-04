/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import PublishedCouponInfoDetailComponent from '@/entities/published-coupon-info/published-coupon-info-details.vue';
import PublishedCouponInfoClass from '@/entities/published-coupon-info/published-coupon-info-details.component';
import PublishedCouponInfoService from '@/entities/published-coupon-info/published-coupon-info.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('PublishedCouponInfo Management Detail Component', () => {
    let wrapper: Wrapper<PublishedCouponInfoClass>;
    let comp: PublishedCouponInfoClass;
    let publishedCouponInfoServiceStub: SinonStubbedInstance<PublishedCouponInfoService>;

    beforeEach(() => {
      publishedCouponInfoServiceStub = sinon.createStubInstance<PublishedCouponInfoService>(PublishedCouponInfoService);

      wrapper = shallowMount<PublishedCouponInfoClass>(PublishedCouponInfoDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { publishedCouponInfoService: () => publishedCouponInfoServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPublishedCouponInfo = { id: 123 };
        publishedCouponInfoServiceStub.find.resolves(foundPublishedCouponInfo);

        // WHEN
        comp.retrievePublishedCouponInfo(123);
        await comp.$nextTick();

        // THEN
        expect(comp.publishedCouponInfo).toBe(foundPublishedCouponInfo);
      });
    });
  });
});
