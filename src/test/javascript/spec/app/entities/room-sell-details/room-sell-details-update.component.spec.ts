/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import format from 'date-fns/format';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import RoomSellDetailsUpdateComponent from '@/entities/room-sell-details/room-sell-details-update.vue';
import RoomSellDetailsClass from '@/entities/room-sell-details/room-sell-details-update.component';
import RoomSellDetailsService from '@/entities/room-sell-details/room-sell-details.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('RoomSellDetails Management Update Component', () => {
    let wrapper: Wrapper<RoomSellDetailsClass>;
    let comp: RoomSellDetailsClass;
    let roomSellDetailsServiceStub: SinonStubbedInstance<RoomSellDetailsService>;

    beforeEach(() => {
      roomSellDetailsServiceStub = sinon.createStubInstance<RoomSellDetailsService>(RoomSellDetailsService);

      wrapper = shallowMount<RoomSellDetailsClass>(RoomSellDetailsUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          roomSellDetailsService: () => roomSellDetailsServiceStub
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
        comp.roomSellDetails = entity;
        roomSellDetailsServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(roomSellDetailsServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.roomSellDetails = entity;
        roomSellDetailsServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(roomSellDetailsServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
