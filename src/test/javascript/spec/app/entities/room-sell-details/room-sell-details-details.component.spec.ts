/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import RoomSellDetailsDetailComponent from '@/entities/room-sell-details/room-sell-details-details.vue';
import RoomSellDetailsClass from '@/entities/room-sell-details/room-sell-details-details.component';
import RoomSellDetailsService from '@/entities/room-sell-details/room-sell-details.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('RoomSellDetails Management Detail Component', () => {
    let wrapper: Wrapper<RoomSellDetailsClass>;
    let comp: RoomSellDetailsClass;
    let roomSellDetailsServiceStub: SinonStubbedInstance<RoomSellDetailsService>;

    beforeEach(() => {
      roomSellDetailsServiceStub = sinon.createStubInstance<RoomSellDetailsService>(RoomSellDetailsService);

      wrapper = shallowMount<RoomSellDetailsClass>(RoomSellDetailsDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { roomSellDetailsService: () => roomSellDetailsServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundRoomSellDetails = { id: 123 };
        roomSellDetailsServiceStub.find.resolves(foundRoomSellDetails);

        // WHEN
        comp.retrieveRoomSellDetails(123);
        await comp.$nextTick();

        // THEN
        expect(comp.roomSellDetails).toBe(foundRoomSellDetails);
      });
    });
  });
});
