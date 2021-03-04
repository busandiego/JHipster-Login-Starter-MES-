/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import PaymentDetailComponent from '@/entities/payment/payment-details.vue';
import PaymentClass from '@/entities/payment/payment-details.component';
import PaymentService from '@/entities/payment/payment.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Payment Management Detail Component', () => {
    let wrapper: Wrapper<PaymentClass>;
    let comp: PaymentClass;
    let paymentServiceStub: SinonStubbedInstance<PaymentService>;

    beforeEach(() => {
      paymentServiceStub = sinon.createStubInstance<PaymentService>(PaymentService);

      wrapper = shallowMount<PaymentClass>(PaymentDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { paymentService: () => paymentServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPayment = { id: 123 };
        paymentServiceStub.find.resolves(foundPayment);

        // WHEN
        comp.retrievePayment(123);
        await comp.$nextTick();

        // THEN
        expect(comp.payment).toBe(foundPayment);
      });
    });
  });
});
