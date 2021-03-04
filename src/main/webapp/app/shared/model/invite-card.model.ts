export const enum InviteCardState {
  NORMAL = 'NORMAL',
  ABNORMAL = 'ABNORMAL',
  DELETE = 'DELETE',
  WAITING = 'WAITING'
}

export interface IInviteCard {
  id?: number;
  inviteName?: string;
  inviteSerial?: string;
  inviteCreateDt?: Date;
  inviteExpirationDt?: Date;
  managerName?: string;
  accommodationName?: string;
  inflowNum?: number;
  reservationNum?: number;
  managerId?: number;
  accommodationId?: number;
  inviteCardState?: InviteCardState;
}

export class InviteCard implements IInviteCard {
  constructor(
    public id?: number,
    public inviteName?: string,
    public inviteSerial?: string,
    public inviteCreateDt?: Date,
    public inviteExpirationDt?: Date,
    public managerName?: string,
    public accommodationName?: string,
    public inflowNum?: number,
    public reservationNum?: number,
    public managerId?: number,
    public accommodationId?: number,
    public inviteCardState?: InviteCardState
  ) {}
}
