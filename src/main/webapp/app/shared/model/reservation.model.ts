export const enum StateOrder {
  DEPOSITWAIT = 'DEPOSITWAIT',
  RESERVATIONOK = ' RESERVATIONOK',
  USEOK = ' USEOK',
  RESERVATIONFAIL = ' RESERVATIONFAIL',
  RESERVATIONCANCEL = ' RESERVATIONCANCEL'
}

export interface IReservation {
  id?: number;
  orderUniqNum?: string;
  orderUserName?: string;
  orderUserNum?: string;
  transportation?: string;
  accommodationName?: string;
  roomName?: string;
  reservationPrice?: number;
  roomDiscountPer?: number;
  couponApply?: boolean;
  couponName?: string;
  couponDiscountPrice?: number;
  couponType?: string;
  paymentPrice?: number;
  paymentType?: string;
  affiliateCommission?: number;
  managerCommission?: number;
  investmentCommission?: number;
  useStartTime?: Date;
  useEndTime?: Date;
  orderCreateDt?: Date;
  checkInDt?: Date;
  checkOutDt?: Date;
  orderState?: StateOrder;
  hoMemberId?: number;
  managerId?: number;
  affiliateId?: number;
  accommodationId?: number;
}

export class Reservation implements IReservation {
  constructor(
    public id?: number,
    public orderUniqNum?: string,
    public orderUserName?: string,
    public orderUserNum?: string,
    public transportation?: string,
    public accommodationName?: string,
    public roomName?: string,
    public reservationPrice?: number,
    public roomDiscountPer?: number,
    public couponApply?: boolean,
    public couponName?: string,
    public couponDiscountPrice?: number,
    public couponType?: string,
    public paymentPrice?: number,
    public paymentType?: string,
    public affiliateCommission?: number,
    public managerCommission?: number,
    public investmentCommission?: number,
    public useStartTime?: Date,
    public useEndTime?: Date,
    public orderCreateDt?: Date,
    public checkInDt?: Date,
    public checkOutDt?: Date,
    public orderState?: StateOrder,
    public hoMemberId?: number,
    public managerId?: number,
    public affiliateId?: number,
    public accommodationId?: number
  ) {
    this.couponApply = this.couponApply || false;
  }
}
