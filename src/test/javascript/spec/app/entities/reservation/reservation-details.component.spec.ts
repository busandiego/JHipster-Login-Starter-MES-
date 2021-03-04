/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ReservationDetailComponent from '@/entities/reservation/reservation-details.vue';
import ReservationClass from '@/entities/reservation/reservation-details.component';
import ReservationService from '@/entities/reservation/reservation.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Reservation Management Detail Component', () => {
    let wrapper: Wrapper<ReservationClass>;
    let comp: ReservationClass;
    let reservationServiceStub: SinonStubbedInstance<ReservationService>;

    beforeEach(() => {
      reservationServiceStub = sinon.createStubInstance<ReservationService>(ReservationService);

      wrapper = shallowMount<ReservationClass>(ReservationDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { reservationService: () => reservationServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundReservation = { id: 123 };
        reservationServiceStub.find.resolves(foundReservation);

        // WHEN
        comp.retrieveReservation(123);
        await comp.$nextTick();

        // THEN
        expect(comp.reservation).toBe(foundReservation);
      });
    });
  });
});
