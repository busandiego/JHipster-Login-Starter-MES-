import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IInviteCard } from '@/shared/model/invite-card.model';

const baseApiUrl = 'api/invite-cards';

export default class InviteCardService {
  public find(id: number): Promise<IInviteCard> {
    return new Promise<IInviteCard>(resolve => {
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

  public create(entity: IInviteCard): Promise<IInviteCard> {
    return new Promise<IInviteCard>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IInviteCard): Promise<IInviteCard> {
    return new Promise<IInviteCard>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
