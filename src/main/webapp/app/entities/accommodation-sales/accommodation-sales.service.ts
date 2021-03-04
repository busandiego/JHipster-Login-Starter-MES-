import axios from 'axios';

import { IAccommodationSales } from '@/shared/model/accommodation-sales.model';

const baseApiUrl = 'api/accommodation-sales';

export default class AccommodationSalesService {
  public find(id: number): Promise<IAccommodationSales> {
    return new Promise<IAccommodationSales>(resolve => {
      axios.get(`${baseApiUrl}/${id}`).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>(resolve => {
      axios.get(baseApiUrl).then(function(res) {
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

  public create(entity: IAccommodationSales): Promise<IAccommodationSales> {
    return new Promise<IAccommodationSales>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IAccommodationSales): Promise<IAccommodationSales> {
    return new Promise<IAccommodationSales>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
