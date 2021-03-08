import axios from 'axios';

import { IBusiness } from '@/shared/model/business.model';

const baseApiUrl = 'api/businesses';

export default class BusinessService {
  public find(id: number): Promise<IBusiness> {
    return new Promise<IBusiness>(resolve => {
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

  public create(entity: IBusiness): Promise<IBusiness> {
    return new Promise<IBusiness>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IBusiness): Promise<IBusiness> {
    return new Promise<IBusiness>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
