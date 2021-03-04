import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IApplyInviteCard } from '@/shared/model/apply-invite-card.model';

const baseApiUrl = 'api/apply-invite-cards';

export default class ApplyInviteCardService {
  public find(id: number): Promise<IApplyInviteCard> {
    return new Promise<IApplyInviteCard>(resolve => {
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

  public create(entity: IApplyInviteCard): Promise<IApplyInviteCard> {
    return new Promise<IApplyInviteCard>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IApplyInviteCard): Promise<IApplyInviteCard> {
    return new Promise<IApplyInviteCard>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
