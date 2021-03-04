/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import ReservationService from '@/entities/reservation/reservation.service';
import { Reservation, StateOrder } from '@/shared/model/reservation.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('Reservation Service', () => {
    let service: ReservationService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new ReservationService();
      currentDate = new Date();

      elemDefault = new Reservation(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        false,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        0,
        0,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        StateOrder.DEPOSITWAIT,
        0,
        0,
        0,
        0
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            useStartTime: format(currentDate, DATE_TIME_FORMAT),
            useEndTime: format(currentDate, DATE_TIME_FORMAT),
            orderCreateDt: format(currentDate, DATE_TIME_FORMAT),
            checkInDt: format(currentDate, DATE_TIME_FORMAT),
            checkOutDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a Reservation', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            useStartTime: format(currentDate, DATE_TIME_FORMAT),
            useEndTime: format(currentDate, DATE_TIME_FORMAT),
            orderCreateDt: format(currentDate, DATE_TIME_FORMAT),
            checkInDt: format(currentDate, DATE_TIME_FORMAT),
            checkOutDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            useStartTime: currentDate,
            useEndTime: currentDate,
            orderCreateDt: currentDate,
            checkInDt: currentDate,
            checkOutDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a Reservation', async () => {
        const returnedFromService = Object.assign(
          {
            orderUniqNum: 'BBBBBB',
            orderUserName: 'BBBBBB',
            orderUserNum: 'BBBBBB',
            transportation: 'BBBBBB',
            accommodationName: 'BBBBBB',
            roomName: 'BBBBBB',
            reservationPrice: 1,
            roomDiscountPer: 1,
            couponApply: true,
            couponName: 'BBBBBB',
            couponDiscountPrice: 1,
            couponType: 'BBBBBB',
            paymentPrice: 1,
            paymentType: 'BBBBBB',
            affiliateCommission: 1,
            managerCommission: 1,
            investmentCommission: 1,
            useStartTime: format(currentDate, DATE_TIME_FORMAT),
            useEndTime: format(currentDate, DATE_TIME_FORMAT),
            orderCreateDt: format(currentDate, DATE_TIME_FORMAT),
            checkInDt: format(currentDate, DATE_TIME_FORMAT),
            checkOutDt: format(currentDate, DATE_TIME_FORMAT),
            orderState: 'BBBBBB',
            hoMemberId: 1,
            managerId: 1,
            affiliateId: 1,
            accommodationId: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            useStartTime: currentDate,
            useEndTime: currentDate,
            orderCreateDt: currentDate,
            checkInDt: currentDate,
            checkOutDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of Reservation', async () => {
        const returnedFromService = Object.assign(
          {
            orderUniqNum: 'BBBBBB',
            orderUserName: 'BBBBBB',
            orderUserNum: 'BBBBBB',
            transportation: 'BBBBBB',
            accommodationName: 'BBBBBB',
            roomName: 'BBBBBB',
            reservationPrice: 1,
            roomDiscountPer: 1,
            couponApply: true,
            couponName: 'BBBBBB',
            couponDiscountPrice: 1,
            couponType: 'BBBBBB',
            paymentPrice: 1,
            paymentType: 'BBBBBB',
            affiliateCommission: 1,
            managerCommission: 1,
            investmentCommission: 1,
            useStartTime: format(currentDate, DATE_TIME_FORMAT),
            useEndTime: format(currentDate, DATE_TIME_FORMAT),
            orderCreateDt: format(currentDate, DATE_TIME_FORMAT),
            checkInDt: format(currentDate, DATE_TIME_FORMAT),
            checkOutDt: format(currentDate, DATE_TIME_FORMAT),
            orderState: 'BBBBBB',
            hoMemberId: 1,
            managerId: 1,
            affiliateId: 1,
            accommodationId: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            useStartTime: currentDate,
            useEndTime: currentDate,
            orderCreateDt: currentDate,
            checkInDt: currentDate,
            checkOutDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a Reservation', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
