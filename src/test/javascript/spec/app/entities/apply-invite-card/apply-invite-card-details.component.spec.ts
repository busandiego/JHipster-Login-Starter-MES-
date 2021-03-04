/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ApplyInviteCardDetailComponent from '@/entities/apply-invite-card/apply-invite-card-details.vue';
import ApplyInviteCardClass from '@/entities/apply-invite-card/apply-invite-card-details.component';
import ApplyInviteCardService from '@/entities/apply-invite-card/apply-invite-card.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('ApplyInviteCard Management Detail Component', () => {
    let wrapper: Wrapper<ApplyInviteCardClass>;
    let comp: ApplyInviteCardClass;
    let applyInviteCardServiceStub: SinonStubbedInstance<ApplyInviteCardService>;

    beforeEach(() => {
      applyInviteCardServiceStub = sinon.createStubInstance<ApplyInviteCardService>(ApplyInviteCardService);

      wrapper = shallowMount<ApplyInviteCardClass>(ApplyInviteCardDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { applyInviteCardService: () => applyInviteCardServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundApplyInviteCard = { id: 123 };
        applyInviteCardServiceStub.find.resolves(foundApplyInviteCard);

        // WHEN
        comp.retrieveApplyInviteCard(123);
        await comp.$nextTick();

        // THEN
        expect(comp.applyInviteCard).toBe(foundApplyInviteCard);
      });
    });
  });
});
