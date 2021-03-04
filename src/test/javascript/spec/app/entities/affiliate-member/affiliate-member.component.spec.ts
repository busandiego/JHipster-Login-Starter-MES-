/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import AffiliateMemberComponent from '@/entities/affiliate-member/affiliate-member.vue';
import AffiliateMemberClass from '@/entities/affiliate-member/affiliate-member.component';
import AffiliateMemberService from '@/entities/affiliate-member/affiliate-member.service';

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
  describe('AffiliateMember Management Component', () => {
    let wrapper: Wrapper<AffiliateMemberClass>;
    let comp: AffiliateMemberClass;
    let affiliateMemberServiceStub: SinonStubbedInstance<AffiliateMemberService>;

    beforeEach(() => {
      affiliateMemberServiceStub = sinon.createStubInstance<AffiliateMemberService>(AffiliateMemberService);
      affiliateMemberServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<AffiliateMemberClass>(AffiliateMemberComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          affiliateMemberService: () => affiliateMemberServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      affiliateMemberServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllAffiliateMembers();
      await comp.$nextTick();

      // THEN
      expect(affiliateMemberServiceStub.retrieve.called).toBeTruthy();
      expect(comp.affiliateMembers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      affiliateMemberServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(affiliateMemberServiceStub.retrieve.called).toBeTruthy();
      expect(comp.affiliateMembers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      affiliateMemberServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(affiliateMemberServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      affiliateMemberServiceStub.retrieve.reset();
      affiliateMemberServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(affiliateMemberServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.affiliateMembers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      affiliateMemberServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeAffiliateMember();
      await comp.$nextTick();

      // THEN
      expect(affiliateMemberServiceStub.delete.called).toBeTruthy();
      expect(affiliateMemberServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
