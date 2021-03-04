/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import RoomSellDetailsService from '@/entities/room-sell-details/room-sell-details.service';
import { RoomSellDetails, SellState } from '@/shared/model/room-sell-details.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('RoomSellDetails Service', () => {
    let service: RoomSellDetailsService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new RoomSellDetailsService();
      currentDate = new Date();

      elemDefault = new RoomSellDetails(0, currentDate, 0, 0, 0, 0, 0, 0, SellState.NORMAL);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            sellDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a RoomSellDetails', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            sellDt: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            sellDt: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a RoomSellDetails', async () => {
        const returnedFromService = Object.assign(
          {
            sellDt: format(currentDate, DATE_TIME_FORMAT),
            sellAmount: 1,
            sellSoldNum: 1,
            sellStartTime: 1,
            sellEndTime: 1,
            sellUseTime: 1,
            couponBoolean: 1,
            sellState: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            sellDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of RoomSellDetails', async () => {
        const returnedFromService = Object.assign(
          {
            sellDt: format(currentDate, DATE_TIME_FORMAT),
            sellAmount: 1,
            sellSoldNum: 1,
            sellStartTime: 1,
            sellEndTime: 1,
            sellUseTime: 1,
            couponBoolean: 1,
            sellState: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            sellDt: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a RoomSellDetails', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
