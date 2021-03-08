/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import BusinessService from '@/entities/business/business.service';
import { Business } from '@/shared/model/business.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('Business Service', () => {
    let service: BusinessService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new BusinessService();
      currentDate = new Date();

      elemDefault = new Business(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        currentDate
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            createdDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a Business', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            createdDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createdDate: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a Business', async () => {
        const returnedFromService = Object.assign(
          {
            businessName: 'BBBBBB',
            businessRepresentative: 'BBBBBB',
            businessRegistrationNum: 'BBBBBB',
            businessContactNum: 'BBBBBB',
            businessType: 'BBBBBB',
            businessAddress: 'BBBBBB',
            businessCategory: 'BBBBBB',
            businessFaxNum: 'BBBBBB',
            isHeadquarter: true,
            createdDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createdDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of Business', async () => {
        const returnedFromService = Object.assign(
          {
            businessName: 'BBBBBB',
            businessRepresentative: 'BBBBBB',
            businessRegistrationNum: 'BBBBBB',
            businessContactNum: 'BBBBBB',
            businessType: 'BBBBBB',
            businessAddress: 'BBBBBB',
            businessCategory: 'BBBBBB',
            businessFaxNum: 'BBBBBB',
            isHeadquarter: true,
            createdDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createdDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a Business', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
