import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ICouponPublishedHistories } from '@/shared/model/coupon-published-histories.model';

const baseApiUrl = 'api/coupon-published-histories';

export default class CouponPublishedHistoriesService {
  public find(id: number): Promise<ICouponPublishedHistories> {
    return new Promise<ICouponPublishedHistories>(resolve => {
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

  public create(entity: ICouponPublishedHistories): Promise<ICouponPublishedHistories> {
    return new Promise<ICouponPublishedHistories>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: ICouponPublishedHistories): Promise<ICouponPublishedHistories> {
    return new Promise<ICouponPublishedHistories>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
