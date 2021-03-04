/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import CouponPublishedHistoriesService from '@/entities/coupon-published-histories/coupon-published-histories.service';
import { CouponPublishedHistories, CouponPublishedHistoriesState } from '@/shared/model/coupon-published-histories.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('CouponPublishedHistories Service', () => {
    let service: CouponPublishedHistoriesService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new CouponPublishedHistoriesService();
      currentDate = new Date();

      elemDefault = new CouponPublishedHistories(
        0,
        'AAAAAAA',
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        currentDate,
        currentDate,
        CouponPublishedHistoriesState.NORMAL
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            publishedDt: format(currentDate, DATE_TIME_FORMAT),
            expireDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a CouponPublishedHistories', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            publishedDt: format(currentDate, DATE_TIME_FORMAT),
            expireDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            publishedDt: currentDate,
            expireDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a CouponPublishedHistories', async () => {
        const returnedFromService = Object.assign(
          {
            publishedName: 'BBBBBB',
            totalPublishedNum: 1,
            oneThousandNum: 1,
            threeThousandNum: 1,
            fiveThousandNum: 1,
            sevenThousandNum: 1,
            tenThousandNum: 1,
            autoPublishedNum: 1,
            totalPublishedPrice: 1,
            publishedDt: format(currentDate, DATE_TIME_FORMAT),
            expireDt: format(currentDate, DATE_TIME_FORMAT),
            CouponPublishedHistoriesState: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            publishedDt: currentDate,
            expireDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of CouponPublishedHistories', async () => {
        const returnedFromService = Object.assign(
          {
            publishedName: 'BBBBBB',
            totalPublishedNum: 1,
            oneThousandNum: 1,
            threeThousandNum: 1,
            fiveThousandNum: 1,
            sevenThousandNum: 1,
            tenThousandNum: 1,
            autoPublishedNum: 1,
            totalPublishedPrice: 1,
            publishedDt: format(currentDate, DATE_TIME_FORMAT),
            expireDt: format(currentDate, DATE_TIME_FORMAT),
            CouponPublishedHistoriesState: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            publishedDt: currentDate,
            expireDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a CouponPublishedHistories', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
