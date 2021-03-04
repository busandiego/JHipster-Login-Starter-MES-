/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import PublishedCouponHistoriesComponent from '@/entities/published-coupon-histories/published-coupon-histories.vue';
import PublishedCouponHistoriesClass from '@/entities/published-coupon-histories/published-coupon-histories.component';
import PublishedCouponHistoriesService from '@/entities/published-coupon-histories/published-coupon-histories.service';

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
  describe('PublishedCouponHistories Management Component', () => {
    let wrapper: Wrapper<PublishedCouponHistoriesClass>;
    let comp: PublishedCouponHistoriesClass;
    let publishedCouponHistoriesServiceStub: SinonStubbedInstance<PublishedCouponHistoriesService>;

    beforeEach(() => {
      publishedCouponHistoriesServiceStub = sinon.createStubInstance<PublishedCouponHistoriesService>(PublishedCouponHistoriesService);
      publishedCouponHistoriesServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<PublishedCouponHistoriesClass>(PublishedCouponHistoriesComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          publishedCouponHistoriesService: () => publishedCouponHistoriesServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      publishedCouponHistoriesServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllPublishedCouponHistoriess();
      await comp.$nextTick();

      // THEN
      expect(publishedCouponHistoriesServiceStub.retrieve.called).toBeTruthy();
      expect(comp.publishedCouponHistories[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      publishedCouponHistoriesServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(publishedCouponHistoriesServiceStub.retrieve.called).toBeTruthy();
      expect(comp.publishedCouponHistories[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      publishedCouponHistoriesServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(publishedCouponHistoriesServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      publishedCouponHistoriesServiceStub.retrieve.reset();
      publishedCouponHistoriesServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(publishedCouponHistoriesServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.publishedCouponHistories[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // GIVEN
      comp.propOrder = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      publishedCouponHistoriesServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removePublishedCouponHistories();
      await comp.$nextTick();

      // THEN
      expect(publishedCouponHistoriesServiceStub.delete.called).toBeTruthy();
      expect(publishedCouponHistoriesServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
