/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import InviteCardDetailComponent from '@/entities/invite-card/invite-card-details.vue';
import InviteCardClass from '@/entities/invite-card/invite-card-details.component';
import InviteCardService from '@/entities/invite-card/invite-card.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('InviteCard Management Detail Component', () => {
    let wrapper: Wrapper<InviteCardClass>;
    let comp: InviteCardClass;
    let inviteCardServiceStub: SinonStubbedInstance<InviteCardService>;

    beforeEach(() => {
      inviteCardServiceStub = sinon.createStubInstance<InviteCardService>(InviteCardService);

      wrapper = shallowMount<InviteCardClass>(InviteCardDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { inviteCardService: () => inviteCardServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundInviteCard = { id: 123 };
        inviteCardServiceStub.find.resolves(foundInviteCard);

        // WHEN
        comp.retrieveInviteCard(123);
        await comp.$nextTick();

        // THEN
        expect(comp.inviteCard).toBe(foundInviteCard);
      });
    });
  });
});
