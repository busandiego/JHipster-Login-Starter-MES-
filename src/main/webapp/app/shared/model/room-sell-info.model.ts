export const enum RoomSalesType {
  DAYUSE = 'DAYUSE',
  FULLRENT = 'FULLRENT'
}

export interface IRoomSellInfo {
  id?: number;
  roomSalesType?: RoomSalesType;
  roomId?: number;
}

export class RoomSellInfo implements IRoomSellInfo {
  constructor(public id?: number, public roomSalesType?: RoomSalesType, public roomId?: number) {}
}
