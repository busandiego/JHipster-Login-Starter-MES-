/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import RoomSellInfoComponent from '@/entities/room-sell-info/room-sell-info.vue';
import RoomSellInfoClass from '@/entities/room-sell-info/room-sell-info.component';
import RoomSellInfoService from '@/entities/room-sell-info/room-sell-info.service';

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
  describe('RoomSellInfo Management Component', () => {
    let wrapper: Wrapper<RoomSellInfoClass>;
    let comp: RoomSellInfoClass;
    let roomSellInfoServiceStub: SinonStubbedInstance<RoomSellInfoService>;

    beforeEach(() => {
      roomSellInfoServiceStub = sinon.createStubInstance<RoomSellInfoService>(RoomSellInfoService);
      roomSellInfoServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<RoomSellInfoClass>(RoomSellInfoComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          roomSellInfoService: () => roomSellInfoServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      roomSellInfoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllRoomSellInfos();
      await comp.$nextTick();

      // THEN
      expect(roomSellInfoServiceStub.retrieve.called).toBeTruthy();
      expect(comp.roomSellInfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      roomSellInfoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(roomSellInfoServiceStub.retrieve.called).toBeTruthy();
      expect(comp.roomSellInfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      roomSellInfoServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(roomSellInfoServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      roomSellInfoServiceStub.retrieve.reset();
      roomSellInfoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(roomSellInfoServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.roomSellInfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      roomSellInfoServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeRoomSellInfo();
      await comp.$nextTick();

      // THEN
      expect(roomSellInfoServiceStub.delete.called).toBeTruthy();
      expect(roomSellInfoServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
