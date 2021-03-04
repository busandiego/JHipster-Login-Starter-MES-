export const enum CouponType {
  AFFILIATECOUPON = 'AFFILIATECOUPON',
  ABSOLUTECOUPON = 'ABSOLUTECOUPON'
}

export const enum CouponAmountType {
  ONETHOUSAND = 'ONETHOUSAND',
  THREETHOUSAND = 'THREETHOUSAND',
  FIVETHOUSAND = 'FIVETHOUSAND',
  SEVENTHOUSAND = 'SEVENTHOUSAND',
  TENTHOUSAND = 'TENTHOUSAND'
}

export const enum CouponUseType {
  DAYUSE = 'DAYUSE',
  FULLRENT = 'FULLRENT',
  RELAYRENT = 'RELAYRENT'
}

export const enum StateCoupon {
  NORMAL = 'NORMAL',
  ABNORMAL = 'ABNORMAL',
  DELETE = 'DELETE'
}

export interface ICoupon {
  id?: number;
  couponName?: string;
  couponType?: CouponType;
  couponAllUse?: boolean;
  couponUseAffiliateId?: number;
  couponAmountType?: CouponAmountType;
  couponDuplication?: boolean;
  couponAutoPublish?: boolean;
  couponUseTypeLimit?: boolean;
  couponUseType?: CouponUseType;
  couponUsePriceLimit?: boolean;
  couponUsePrice?: number;
  couponUseExpireLimit?: boolean;
  couponUseExpireMonth?: number;
  couponCreateDt?: Date;
  couponUpdateDt?: Date;
  couponCurrentPublishedDt?: Date;
  couponState?: StateCoupon;
}

export class Coupon implements ICoupon {
  constructor(
    public id?: number,
    public couponName?: string,
    public couponType?: CouponType,
    public couponAllUse?: boolean,
    public couponUseAffiliateId?: number,
    public couponAmountType?: CouponAmountType,
    public couponDuplication?: boolean,
    public couponAutoPublish?: boolean,
    public couponUseTypeLimit?: boolean,
    public couponUseType?: CouponUseType,
    public couponUsePriceLimit?: boolean,
    public couponUsePrice?: number,
    public couponUseExpireLimit?: boolean,
    public couponUseExpireMonth?: number,
    public couponCreateDt?: Date,
    public couponUpdateDt?: Date,
    public couponCurrentPublishedDt?: Date,
    public couponState?: StateCoupon
  ) {
    this.couponAllUse = this.couponAllUse || false;
    this.couponDuplication = this.couponDuplication || false;
    this.couponAutoPublish = this.couponAutoPublish || false;
    this.couponUseTypeLimit = this.couponUseTypeLimit || false;
    this.couponUsePriceLimit = this.couponUsePriceLimit || false;
    this.couponUseExpireLimit = this.couponUseExpireLimit || false;
  }
}
