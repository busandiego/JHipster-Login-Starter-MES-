import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ICoupon } from '@/shared/model/coupon.model';

const baseApiUrl = 'api/coupons';

export default class CouponService {
  public find(id: number): Promise<ICoupon> {
    return new Promise<ICoupon>(resolve => {
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

  public create(entity: ICoupon): Promise<ICoupon> {
    return new Promise<ICoupon>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: ICoupon): Promise<ICoupon> {
    return new Promise<ICoupon>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
