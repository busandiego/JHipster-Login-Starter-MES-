/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import RoomSellInfoDetailComponent from '@/entities/room-sell-info/room-sell-info-details.vue';
import RoomSellInfoClass from '@/entities/room-sell-info/room-sell-info-details.component';
import RoomSellInfoService from '@/entities/room-sell-info/room-sell-info.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('RoomSellInfo Management Detail Component', () => {
    let wrapper: Wrapper<RoomSellInfoClass>;
    let comp: RoomSellInfoClass;
    let roomSellInfoServiceStub: SinonStubbedInstance<RoomSellInfoService>;

    beforeEach(() => {
      roomSellInfoServiceStub = sinon.createStubInstance<RoomSellInfoService>(RoomSellInfoService);

      wrapper = shallowMount<RoomSellInfoClass>(RoomSellInfoDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { roomSellInfoService: () => roomSellInfoServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundRoomSellInfo = { id: 123 };
        roomSellInfoServiceStub.find.resolves(foundRoomSellInfo);

        // WHEN
        comp.retrieveRoomSellInfo(123);
        await comp.$nextTick();

        // THEN
        expect(comp.roomSellInfo).toBe(foundRoomSellInfo);
      });
    });
  });
});
