/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import AffiliateMemberDetailComponent from '@/entities/affiliate-member/affiliate-member-details.vue';
import AffiliateMemberClass from '@/entities/affiliate-member/affiliate-member-details.component';
import AffiliateMemberService from '@/entities/affiliate-member/affiliate-member.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('AffiliateMember Management Detail Component', () => {
    let wrapper: Wrapper<AffiliateMemberClass>;
    let comp: AffiliateMemberClass;
    let affiliateMemberServiceStub: SinonStubbedInstance<AffiliateMemberService>;

    beforeEach(() => {
      affiliateMemberServiceStub = sinon.createStubInstance<AffiliateMemberService>(AffiliateMemberService);

      wrapper = shallowMount<AffiliateMemberClass>(AffiliateMemberDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { affiliateMemberService: () => affiliateMemberServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundAffiliateMember = { id: 123 };
        affiliateMemberServiceStub.find.resolves(foundAffiliateMember);

        // WHEN
        comp.retrieveAffiliateMember(123);
        await comp.$nextTick();

        // THEN
        expect(comp.affiliateMember).toBe(foundAffiliateMember);
      });
    });
  });
});
