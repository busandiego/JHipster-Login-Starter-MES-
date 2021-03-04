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

export interface IPublishedCouponInfo {
  id?: number;
  publishedCouponName?: string;
  publishedCouponType?: CouponType;
  publishedCouponAllUse?: boolean;
  publishedCouponUseAffiliateId?: number;
  publishedCouponAmountType?: CouponAmountType;
  publishedCouponDuplication?: boolean;
  publishedCouponAutoPublish?: boolean;
  publishedCouponUseTypeLimit?: boolean;
  publishedCouponUseType?: CouponUseType;
  publishedCouponUsePriceLimit?: boolean;
  publishedCouponUsePrice?: number;
  publishedCouponUseExpireLimit?: boolean;
  publishedCouponUseExpireMonth?: number;
  publishedCouponCreateDt?: Date;
  publishedCouponUpdateDt?: Date;
  publishedCouponCurrentPublishedDt?: Date;
  publishedCouponAmountNum?: number;
  publishedCouponSoldNum?: number;
  couponState?: StateCoupon;
  couponPublishedHistoriesId?: number;
}

export class PublishedCouponInfo implements IPublishedCouponInfo {
  constructor(
    public id?: number,
    public publishedCouponName?: string,
    public publishedCouponType?: CouponType,
    public publishedCouponAllUse?: boolean,
    public publishedCouponUseAffiliateId?: number,
    public publishedCouponAmountType?: CouponAmountType,
    public publishedCouponDuplication?: boolean,
    public publishedCouponAutoPublish?: boolean,
    public publishedCouponUseTypeLimit?: boolean,
    public publishedCouponUseType?: CouponUseType,
    public publishedCouponUsePriceLimit?: boolean,
    public publishedCouponUsePrice?: number,
    public publishedCouponUseExpireLimit?: boolean,
    public publishedCouponUseExpireMonth?: number,
    public publishedCouponCreateDt?: Date,
    public publishedCouponUpdateDt?: Date,
    public publishedCouponCurrentPublishedDt?: Date,
    public publishedCouponAmountNum?: number,
    public publishedCouponSoldNum?: number,
    public couponState?: StateCoupon,
    public couponPublishedHistoriesId?: number
  ) {
    this.publishedCouponAllUse = this.publishedCouponAllUse || false;
    this.publishedCouponDuplication = this.publishedCouponDuplication || false;
    this.publishedCouponAutoPublish = this.publishedCouponAutoPublish || false;
    this.publishedCouponUseTypeLimit = this.publishedCouponUseTypeLimit || false;
    this.publishedCouponUsePriceLimit = this.publishedCouponUsePriceLimit || false;
    this.publishedCouponUseExpireLimit = this.publishedCouponUseExpireLimit || false;
  }
}
