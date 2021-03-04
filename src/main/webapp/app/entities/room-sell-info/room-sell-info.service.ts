import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IRoomSellInfo } from '@/shared/model/room-sell-info.model';

const baseApiUrl = 'api/room-sell-infos';

export default class RoomSellInfoService {
  public find(id: number): Promise<IRoomSellInfo> {
    return new Promise<IRoomSellInfo>(resolve => {
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

  public create(entity: IRoomSellInfo): Promise<IRoomSellInfo> {
    return new Promise<IRoomSellInfo>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IRoomSellInfo): Promise<IRoomSellInfo> {
    return new Promise<IRoomSellInfo>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
