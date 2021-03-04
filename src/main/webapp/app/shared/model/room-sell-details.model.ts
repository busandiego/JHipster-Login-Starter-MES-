export const enum SellState {
  NORMAL = 'NORMAL',
  ABNORMAL = 'ABNORMAL',
  DELETE = 'DELETE'
}

export interface IRoomSellDetails {
  id?: number;
  sellDt?: Date;
  sellAmount?: number;
  sellSoldNum?: number;
  sellStartTime?: number;
  sellEndTime?: number;
  sellUseTime?: number;
  couponBoolean?: number;
  sellState?: SellState;
}

export class RoomSellDetails implements IRoomSellDetails {
  constructor(
    public id?: number,
    public sellDt?: Date,
    public sellAmount?: number,
    public sellSoldNum?: number,
    public sellStartTime?: number,
    public sellEndTime?: number,
    public sellUseTime?: number,
    public couponBoolean?: number,
    public sellState?: SellState
  ) {}
}
