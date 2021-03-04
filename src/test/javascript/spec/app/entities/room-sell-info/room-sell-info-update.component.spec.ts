/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import RoomSellInfoUpdateComponent from '@/entities/room-sell-info/room-sell-info-update.vue';
import RoomSellInfoClass from '@/entities/room-sell-info/room-sell-info-update.component';
import RoomSellInfoService from '@/entities/room-sell-info/room-sell-info.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('RoomSellInfo Management Update Component', () => {
    let wrapper: Wrapper<RoomSellInfoClass>;
    let comp: RoomSellInfoClass;
    let roomSellInfoServiceStub: SinonStubbedInstance<RoomSellInfoService>;

    beforeEach(() => {
      roomSellInfoServiceStub = sinon.createStubInstance<RoomSellInfoService>(RoomSellInfoService);

      wrapper = shallowMount<RoomSellInfoClass>(RoomSellInfoUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          roomSellInfoService: () => roomSellInfoServiceStub
        }
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.roomSellInfo = entity;
        roomSellInfoServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(roomSellInfoServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.roomSellInfo = entity;
        roomSellInfoServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(roomSellInfoServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
