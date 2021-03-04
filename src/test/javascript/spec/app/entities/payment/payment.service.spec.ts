/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import PaymentService from '@/entities/payment/payment.service';
import { Payment, StatePayment } from '@/shared/model/payment.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('Payment Service', () => {
    let service: PaymentService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new PaymentService();
      currentDate = new Date();

      elemDefault = new Payment(0, 0, 0, 0, 'AAAAAAA', currentDate, 0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 0, StatePayment.NORMAL);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            paymentDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a Payment', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            paymentDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            paymentDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a Payment', async () => {
        const returnedFromService = Object.assign(
          {
            sellingPrice: 1,
            commission: 1,
            paymentMoney: 1,
            paymentType: 'BBBBBB',
            paymentDt: format(currentDate, DATE_TIME_FORMAT),
            couponDiscount: 1,
            transactionNum: 'BBBBBB',
            paymentMethod: 'BBBBBB',
            remark: 'BBBBBB',
            reservationId: 1,
            paymentState: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            paymentDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of Payment', async () => {
        const returnedFromService = Object.assign(
          {
            sellingPrice: 1,
            commission: 1,
            paymentMoney: 1,
            paymentType: 'BBBBBB',
            paymentDt: format(currentDate, DATE_TIME_FORMAT),
            couponDiscount: 1,
            transactionNum: 'BBBBBB',
            paymentMethod: 'BBBBBB',
            remark: 'BBBBBB',
            reservationId: 1,
            paymentState: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            paymentDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a Payment', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
