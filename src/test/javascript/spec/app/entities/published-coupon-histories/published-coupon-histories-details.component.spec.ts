/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import PublishedCouponHistoriesDetailComponent from '@/entities/published-coupon-histories/published-coupon-histories-details.vue';
import PublishedCouponHistoriesClass from '@/entities/published-coupon-histories/published-coupon-histories-details.component';
import PublishedCouponHistoriesService from '@/entities/published-coupon-histories/published-coupon-histories.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('PublishedCouponHistories Management Detail Component', () => {
    let wrapper: Wrapper<PublishedCouponHistoriesClass>;
    let comp: PublishedCouponHistoriesClass;
    let publishedCouponHistoriesServiceStub: SinonStubbedInstance<PublishedCouponHistoriesService>;

    beforeEach(() => {
      publishedCouponHistoriesServiceStub = sinon.createStubInstance<PublishedCouponHistoriesService>(PublishedCouponHistoriesService);

      wrapper = shallowMount<PublishedCouponHistoriesClass>(PublishedCouponHistoriesDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { publishedCouponHistoriesService: () => publishedCouponHistoriesServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPublishedCouponHistories = { id: 123 };
        publishedCouponHistoriesServiceStub.find.resolves(foundPublishedCouponHistories);

        // WHEN
        comp.retrievePublishedCouponHistories(123);
        await comp.$nextTick();

        // THEN
        expect(comp.publishedCouponHistories).toBe(foundPublishedCouponHistories);
      });
    });
  });
});
