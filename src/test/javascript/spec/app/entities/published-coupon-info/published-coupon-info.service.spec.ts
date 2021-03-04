/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import PublishedCouponInfoService from '@/entities/published-coupon-info/published-coupon-info.service';
import { CouponAmountType, CouponType, CouponUseType, PublishedCouponInfo, StateCoupon } from '@/shared/model/published-coupon-info.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('PublishedCouponInfo Service', () => {
    let service: PublishedCouponInfoService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new PublishedCouponInfoService();
      currentDate = new Date();

      elemDefault = new PublishedCouponInfo(
        0,
        'AAAAAAA',
        CouponType.AFFILIATECOUPON,
        false,
        0,
        CouponAmountType.ONETHOUSAND,
        false,
        false,
        false,
        CouponUseType.DAYUSE,
        false,
        0,
        false,
        0,
        currentDate,
        currentDate,
        currentDate,
        0,
        0,
        StateCoupon.NORMAL,
        0
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            publishedCouponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a PublishedCouponInfo', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            publishedCouponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            publishedCouponCreateDt: currentDate,
            publishedCouponUpdateDt: currentDate,
            publishedCouponCurrentPublishedDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a PublishedCouponInfo', async () => {
        const returnedFromService = Object.assign(
          {
            publishedCouponName: 'BBBBBB',
            publishedCouponType: 'BBBBBB',
            publishedCouponAllUse: true,
            publishedCouponUseAffiliateId: 1,
            publishedCouponAmountType: 'BBBBBB',
            publishedCouponDuplication: true,
            publishedCouponAutoPublish: true,
            publishedCouponUseTypeLimit: true,
            publishedCouponUseType: 'BBBBBB',
            publishedCouponUsePriceLimit: true,
            publishedCouponUsePrice: 1,
            publishedCouponUseExpireLimit: true,
            publishedCouponUseExpireMonth: 1,
            publishedCouponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponAmountNum: 1,
            publishedCouponSoldNum: 1,
            couponState: 'BBBBBB',
            couponPublishedHistoriesId: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            publishedCouponCreateDt: currentDate,
            publishedCouponUpdateDt: currentDate,
            publishedCouponCurrentPublishedDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of PublishedCouponInfo', async () => {
        const returnedFromService = Object.assign(
          {
            publishedCouponName: 'BBBBBB',
            publishedCouponType: 'BBBBBB',
            publishedCouponAllUse: true,
            publishedCouponUseAffiliateId: 1,
            publishedCouponAmountType: 'BBBBBB',
            publishedCouponDuplication: true,
            publishedCouponAutoPublish: true,
            publishedCouponUseTypeLimit: true,
            publishedCouponUseType: 'BBBBBB',
            publishedCouponUsePriceLimit: true,
            publishedCouponUsePrice: 1,
            publishedCouponUseExpireLimit: true,
            publishedCouponUseExpireMonth: 1,
            publishedCouponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT),
            publishedCouponAmountNum: 1,
            publishedCouponSoldNum: 1,
            couponState: 'BBBBBB',
            couponPublishedHistoriesId: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            publishedCouponCreateDt: currentDate,
            publishedCouponUpdateDt: currentDate,
            publishedCouponCurrentPublishedDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a PublishedCouponInfo', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
