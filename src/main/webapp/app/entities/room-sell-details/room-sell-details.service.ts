import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IRoomSellDetails } from '@/shared/model/room-sell-details.model';

const baseApiUrl = 'api/room-sell-details';

export default class RoomSellDetailsService {
  public find(id: number): Promise<IRoomSellDetails> {
    return new Promise<IRoomSellDetails>(resolve => {
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

  public create(entity: IRoomSellDetails): Promise<IRoomSellDetails> {
    return new Promise<IRoomSellDetails>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IRoomSellDetails): Promise<IRoomSellDetails> {
    return new Promise<IRoomSellDetails>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
