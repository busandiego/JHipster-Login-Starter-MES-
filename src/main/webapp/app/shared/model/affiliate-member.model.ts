export const enum StateAffiliateMember {
  NORMAL = 'NORMAL',
  ABNORMAL = 'ABNORMAL',
  DELETE = 'DELETE'
}

export interface IAffiliateMember {
  id?: number;
  affiliateMemberLoginId?: string;
  affiliateMemberPassword?: string;
  affiliateMemberName?: string;
  affiliateMemberPhoneNum?: string;
  affiliateMemberMemo?: string;
  pushToken?: string;
  createDt?: Date;
  updateDt?: Date;
  affiliateMemberState?: StateAffiliateMember;
  affiliateId?: number;
}

export class AffiliateMember implements IAffiliateMember {
  constructor(
    public id?: number,
    public affiliateMemberLoginId?: string,
    public affiliateMemberPassword?: string,
    public affiliateMemberName?: string,
    public affiliateMemberPhoneNum?: string,
    public affiliateMemberMemo?: string,
    public pushToken?: string,
    public createDt?: Date,
    public updateDt?: Date,
    public affiliateMemberState?: StateAffiliateMember,
    public affiliateId?: number
  ) {}
}
