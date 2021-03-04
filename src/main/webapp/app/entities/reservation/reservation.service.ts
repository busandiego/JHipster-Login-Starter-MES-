import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IReservation } from '@/shared/model/reservation.model';

const baseApiUrl = 'api/reservations';

export default class ReservationService {
  public find(id: number): Promise<IReservation> {
    return new Promise<IReservation>(resolve => {
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

  public create(entity: IReservation): Promise<IReservation> {
    return new Promise<IReservation>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: IReservation): Promise<IReservation> {
    return new Promise<IReservation>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
