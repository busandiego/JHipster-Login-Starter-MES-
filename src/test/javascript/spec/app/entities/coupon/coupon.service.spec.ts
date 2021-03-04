/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import CouponService from '@/entities/coupon/coupon.service';
import { Coupon, CouponAmountType, CouponType, CouponUseType, StateCoupon } from '@/shared/model/coupon.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('Coupon Service', () => {
    let service: CouponService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new CouponService();
      currentDate = new Date();

      elemDefault = new Coupon(
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
        StateCoupon.NORMAL
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            couponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            couponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            couponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a Coupon', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            couponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            couponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            couponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            couponCreateDt: currentDate,
            couponUpdateDt: currentDate,
            couponCurrentPublishedDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a Coupon', async () => {
        const returnedFromService = Object.assign(
          {
            couponName: 'BBBBBB',
            couponType: 'BBBBBB',
            couponAllUse: true,
            couponUseAffiliateId: 1,
            couponAmountType: 'BBBBBB',
            couponDuplication: true,
            couponAutoPublish: true,
            couponUseTypeLimit: true,
            couponUseType: 'BBBBBB',
            couponUsePriceLimit: true,
            couponUsePrice: 1,
            couponUseExpireLimit: true,
            couponUseExpireMonth: 1,
            couponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            couponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            couponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT),
            couponState: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            couponCreateDt: currentDate,
            couponUpdateDt: currentDate,
            couponCurrentPublishedDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of Coupon', async () => {
        const returnedFromService = Object.assign(
          {
            couponName: 'BBBBBB',
            couponType: 'BBBBBB',
            couponAllUse: true,
            couponUseAffiliateId: 1,
            couponAmountType: 'BBBBBB',
            couponDuplication: true,
            couponAutoPublish: true,
            couponUseTypeLimit: true,
            couponUseType: 'BBBBBB',
            couponUsePriceLimit: true,
            couponUsePrice: 1,
            couponUseExpireLimit: true,
            couponUseExpireMonth: 1,
            couponCreateDt: format(currentDate, DATE_TIME_FORMAT),
            couponUpdateDt: format(currentDate, DATE_TIME_FORMAT),
            couponCurrentPublishedDt: format(currentDate, DATE_TIME_FORMAT),
            couponState: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            couponCreateDt: currentDate,
            couponUpdateDt: currentDate,
            couponCurrentPublishedDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a Coupon', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
