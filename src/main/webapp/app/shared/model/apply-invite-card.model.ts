export const enum ApplyInviteCardState {
  APPROVE = 'APPROVE',
  DELETE = 'DELETE',
  WAITING = 'WAITING'
}

export interface IApplyInviteCard {
  id?: number;
  inviteName?: string;
  applyCardDt?: Date;
  managerName?: string;
  accommodationName?: string;
  managerPhoneNum?: string;
  applyAmountNum?: number;
  managerId?: number;
  accommodationId?: number;
  applyInviteCardState?: ApplyInviteCardState;
}

export class ApplyInviteCard implements IApplyInviteCard {
  constructor(
    public id?: number,
    public inviteName?: string,
    public applyCardDt?: Date,
    public managerName?: string,
    public accommodationName?: string,
    public managerPhoneNum?: string,
    public applyAmountNum?: number,
    public managerId?: number,
    public accommodationId?: number,
    public applyInviteCardState?: ApplyInviteCardState
  ) {}
}
