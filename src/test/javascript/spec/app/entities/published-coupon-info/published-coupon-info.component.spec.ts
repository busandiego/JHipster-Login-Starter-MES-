/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import PublishedCouponInfoComponent from '@/entities/published-coupon-info/published-coupon-info.vue';
import PublishedCouponInfoClass from '@/entities/published-coupon-info/published-coupon-info.component';
import PublishedCouponInfoService from '@/entities/published-coupon-info/published-coupon-info.service';

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
  describe('PublishedCouponInfo Management Component', () => {
    let wrapper: Wrapper<PublishedCouponInfoClass>;
    let comp: PublishedCouponInfoClass;
    let publishedCouponInfoServiceStub: SinonStubbedInstance<PublishedCouponInfoService>;

    beforeEach(() => {
      publishedCouponInfoServiceStub = sinon.createStubInstance<PublishedCouponInfoService>(PublishedCouponInfoService);
      publishedCouponInfoServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<PublishedCouponInfoClass>(PublishedCouponInfoComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          publishedCouponInfoService: () => publishedCouponInfoServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      publishedCouponInfoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllPublishedCouponInfos();
      await comp.$nextTick();

      // THEN
      expect(publishedCouponInfoServiceStub.retrieve.called).toBeTruthy();
      expect(comp.publishedCouponInfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      publishedCouponInfoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(publishedCouponInfoServiceStub.retrieve.called).toBeTruthy();
      expect(comp.publishedCouponInfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      publishedCouponInfoServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(publishedCouponInfoServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      publishedCouponInfoServiceStub.retrieve.reset();
      publishedCouponInfoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(publishedCouponInfoServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.publishedCouponInfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      publishedCouponInfoServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removePublishedCouponInfo();
      await comp.$nextTick();

      // THEN
      expect(publishedCouponInfoServiceStub.delete.called).toBeTruthy();
      expect(publishedCouponInfoServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
