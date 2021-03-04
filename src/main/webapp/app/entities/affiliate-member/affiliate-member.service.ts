import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IAffiliateMember } from '@/shared/model/affiliate-member.model';

const baseApiUrl = 'api/affiliate-members';

export default class AffiliateMemberService {
  public find(id: number): Promise<IAffiliateMember> {
    return new Promise<IAffiliateMember>(resolve => {
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

  public create(entity: IAffiliateMember): Promise<IAffiliateMember> {
    return new Promise<IAffiliateMember>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IAffiliateMember): Promise<IAffiliateMember> {
    return new Promise<IAffiliateMember>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
