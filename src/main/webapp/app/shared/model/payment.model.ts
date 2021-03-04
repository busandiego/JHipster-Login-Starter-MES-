export const enum StatePayment {
  NORMAL = 'NORMAL',
  ABNORMAL = 'ABNORMAL',
  DELETE = 'DELETE'
}

export interface IPayment {
  id?: number;
  sellingPrice?: number;
  commission?: number;
  paymentMoney?: number;
  paymentType?: string;
  paymentDt?: Date;
  couponDiscount?: number;
  transactionNum?: string;
  paymentMethod?: string;
  remark?: string;
  reservationId?: number;
  paymentState?: StatePayment;
}

export class Payment implements IPayment {
  constructor(
    public id?: number,
    public sellingPrice?: number,
    public commission?: number,
    public paymentMoney?: number,
    public paymentType?: string,
    public paymentDt?: Date,
    public couponDiscount?: number,
    public transactionNum?: string,
    public paymentMethod?: string,
    public remark?: string,
    public reservationId?: number,
    public paymentState?: StatePayment
  ) {}
}
