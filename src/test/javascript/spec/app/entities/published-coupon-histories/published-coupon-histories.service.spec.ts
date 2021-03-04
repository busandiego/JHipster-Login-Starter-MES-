/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import PublishedCouponHistoriesService from '@/entities/published-coupon-histories/published-coupon-histories.service';
import { CouponAmountType, PublishedCouponHistories } from '@/shared/model/published-coupon-histories.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('PublishedCouponHistories Service', () => {
    let service: PublishedCouponHistoriesService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new PublishedCouponHistoriesService();
      currentDate = new Date();

      elemDefault = new PublishedCouponHistories(0, 'AAAAAAA', CouponAmountType.ONETHOUSAND, currentDate, false, 0, currentDate, false, 0);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            useDt: format(currentDate, DATE_TIME_FORMAT),
            publishedDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a PublishedCouponHistories', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            useDt: format(currentDate, DATE_TIME_FORMAT),
            publishedDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            useDt: currentDate,
            publishedDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a PublishedCouponHistories', async () => {
        const returnedFromService = Object.assign(
          {
            publishedUniqCode: 'BBBBBB',
            publishedCouponAmountType: 'BBBBBB',
            useDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponAllUse: true,
            publishedCouponUseAffiliateId: 1,
            publishedDt: format(currentDate, DATE_TIME_FORMAT),
            useCheck: true,
            couponPublishedHistoriesId: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            useDt: currentDate,
            publishedDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of PublishedCouponHistories', async () => {
        const returnedFromService = Object.assign(
          {
            publishedUniqCode: 'BBBBBB',
            publishedCouponAmountType: 'BBBBBB',
            useDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponAllUse: true,
            publishedCouponUseAffiliateId: 1,
            publishedDt: format(currentDate, DATE_TIME_FORMAT),
            useCheck: true,
            couponPublishedHistoriesId: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            useDt: currentDate,
            publishedDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a PublishedCouponHistories', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
