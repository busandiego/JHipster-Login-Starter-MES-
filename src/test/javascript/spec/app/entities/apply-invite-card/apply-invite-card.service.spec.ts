/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import ApplyInviteCardService from '@/entities/apply-invite-card/apply-invite-card.service';
import { ApplyInviteCard, ApplyInviteCardState } from '@/shared/model/apply-invite-card.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('ApplyInviteCard Service', () => {
    let service: ApplyInviteCardService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new ApplyInviteCardService();
      currentDate = new Date();

      elemDefault = new ApplyInviteCard(0, 'AAAAAAA', currentDate, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 0, 0, 0, ApplyInviteCardState.APPROVE);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            applyCardDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a ApplyInviteCard', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            applyCardDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            applyCardDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a ApplyInviteCard', async () => {
        const returnedFromService = Object.assign(
          {
            inviteName: 'BBBBBB',
            applyCardDt: format(currentDate, DATE_TIME_FORMAT),
            managerName: 'BBBBBB',
            accommodationName: 'BBBBBB',
            managerPhoneNum: 'BBBBBB',
            applyAmountNum: 1,
            managerId: 1,
            accommodationId: 1,
            applyInviteCardState: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            applyCardDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of ApplyInviteCard', async () => {
        const returnedFromService = Object.assign(
          {
            inviteName: 'BBBBBB',
            applyCardDt: format(currentDate, DATE_TIME_FORMAT),
            managerName: 'BBBBBB',
            accommodationName: 'BBBBBB',
            managerPhoneNum: 'BBBBBB',
            applyAmountNum: 1,
            managerId: 1,
            accommodationId: 1,
            applyInviteCardState: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            applyCardDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a ApplyInviteCard', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
