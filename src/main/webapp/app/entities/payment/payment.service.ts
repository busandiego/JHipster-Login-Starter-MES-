import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IPayment } from '@/shared/model/payment.model';

const baseApiUrl = 'api/payments';

export default class PaymentService {
  public find(id: number): Promise<IPayment> {
    return new Promise<IPayment>(resolve => {
      axios.get(`${baseApiUrl}/${id}`).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public retrieve(paginationQuery?: any): Promise<any> {
    return new Promise<any>(resolve => {
      axios.get(baseApiUrl + `?${buildPaginationQueryOpts(paginationQuery)}`).then(function(res) {
        resolve(res);
      });
    });
  }

  public delete(id: number): Promise<any> {
    return new Promise<any>(resolve => {
      axios.delete(`${baseApiUrl}/${id}`).then(function(res) {
        resolve(res);
      });
    });
  }

  public create(entity: IPayment): Promise<IPayment> {
    return new Promise<IPayment>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IPayment): Promise<IPayment> {
    return new Promise<IPayment>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
