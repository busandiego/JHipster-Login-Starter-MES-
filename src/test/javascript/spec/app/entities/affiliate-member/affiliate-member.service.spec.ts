/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import AffiliateMemberService from '@/entities/affiliate-member/affiliate-member.service';
import { AffiliateMember, StateAffiliateMember } from '@/shared/model/affiliate-member.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('AffiliateMember Service', () => {
    let service: AffiliateMemberService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new AffiliateMemberService();
      currentDate = new Date();

      elemDefault = new AffiliateMember(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        StateAffiliateMember.NORMAL,
        0
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            createDt: format(currentDate, DATE_TIME_FORMAT),
            updateDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a AffiliateMember', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            createDt: format(currentDate, DATE_TIME_FORMAT),
            updateDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createDt: currentDate,
            updateDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a AffiliateMember', async () => {
        const returnedFromService = Object.assign(
          {
            affiliateMemberLoginId: 'BBBBBB',
            affiliateMemberPassword: 'BBBBBB',
            affiliateMemberName: 'BBBBBB',
            affiliateMemberPhoneNum: 'BBBBBB',
            affiliateMemberMemo: 'BBBBBB',
            pushToken: 'BBBBBB',
            createDt: format(currentDate, DATE_TIME_FORMAT),
            updateDt: format(currentDate, DATE_TIME_FORMAT),
            affiliateMemberState: 'BBBBBB',
            affiliateId: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createDt: currentDate,
            updateDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of AffiliateMember', async () => {
        const returnedFromService = Object.assign(
          {
            affiliateMemberLoginId: 'BBBBBB',
            affiliateMemberPassword: 'BBBBBB',
            affiliateMemberName: 'BBBBBB',
            affiliateMemberPhoneNum: 'BBBBBB',
            affiliateMemberMemo: 'BBBBBB',
            pushToken: 'BBBBBB',
            createDt: format(currentDate, DATE_TIME_FORMAT),
            updateDt: format(currentDate, DATE_TIME_FORMAT),
            affiliateMemberState: 'BBBBBB',
            affiliateId: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createDt: currentDate,
            updateDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a AffiliateMember', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
