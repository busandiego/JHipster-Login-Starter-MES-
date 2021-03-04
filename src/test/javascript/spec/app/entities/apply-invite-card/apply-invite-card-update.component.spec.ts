/* tslint:disable max-line-length */
import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import format from 'date-fns/format';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import ApplyInviteCardUpdateComponent from '@/entities/apply-invite-card/apply-invite-card-update.vue';
import ApplyInviteCardClass from '@/entities/apply-invite-card/apply-invite-card-update.component';
import ApplyInviteCardService from '@/entities/apply-invite-card/apply-invite-card.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('ApplyInviteCard Management Update Component', () => {
    let wrapper: Wrapper<ApplyInviteCardClass>;
    let comp: ApplyInviteCardClass;
    let applyInviteCardServiceStub: SinonStubbedInstance<ApplyInviteCardService>;

    beforeEach(() => {
      applyInviteCardServiceStub = sinon.createStubInstance<ApplyInviteCardService>(ApplyInviteCardService);

      wrapper = shallowMount<ApplyInviteCardClass>(ApplyInviteCardUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          applyInviteCardService: () => applyInviteCardServiceStub
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
        comp.applyInviteCard = entity;
        applyInviteCardServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(applyInviteCardServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.applyInviteCard = entity;
        applyInviteCardServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(applyInviteCardServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
