export const enum CouponAmountType {
  ONETHOUSAND = 'ONETHOUSAND',
  THREETHOUSAND = 'THREETHOUSAND',
  FIVETHOUSAND = 'FIVETHOUSAND',
  SEVENTHOUSAND = 'SEVENTHOUSAND',
  TENTHOUSAND = 'TENTHOUSAND'
}

export interface IPublishedCouponHistories {
  id?: number;
  publishedUniqCode?: string;
  publishedCouponAmountType?: CouponAmountType;
  useDt?: Date;
  publishedCouponAllUse?: boolean;
  publishedCouponUseAffiliateId?: number;
  publishedDt?: Date;
  useCheck?: boolean;
  couponPublishedHistoriesId?: number;
}

export class PublishedCouponHistories implements IPublishedCouponHistories {
  constructor(
    public id?: number,
    public publishedUniqCode?: string,
    public publishedCouponAmountType?: CouponAmountType,
    public useDt?: Date,
    public publishedCouponAllUse?: boolean,
    public publishedCouponUseAffiliateId?: number,
    public publishedDt?: Date,
    public useCheck?: boolean,
    public couponPublishedHistoriesId?: number
  ) {
    this.publishedCouponAllUse = this.publishedCouponAllUse || false;
    this.useCheck = this.useCheck || false;
  }
}
