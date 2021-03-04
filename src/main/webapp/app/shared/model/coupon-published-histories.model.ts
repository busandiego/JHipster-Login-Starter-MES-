export const enum CouponPublishedHistoriesState {
  NORMAL = 'NORMAL',
  ABNORMAL = 'ABNORMAL'
}

export interface ICouponPublishedHistories {
  id?: number;
  publishedName?: string;
  totalPublishedNum?: number;
  oneThousandNum?: number;
  threeThousandNum?: number;
  fiveThousandNum?: number;
  sevenThousandNum?: number;
  tenThousandNum?: number;
  autoPublishedNum?: number;
  totalPublishedPrice?: number;
  publishedDt?: Date;
  expireDt?: Date;
  CouponPublishedHistoriesState?: CouponPublishedHistoriesState;
}

export class CouponPublishedHistories implements ICouponPublishedHistories {
  constructor(
    public id?: number,
    public publishedName?: string,
    public totalPublishedNum?: number,
    public oneThousandNum?: number,
    public threeThousandNum?: number,
    public fiveThousandNum?: number,
    public sevenThousandNum?: number,
    public tenThousandNum?: number,
    public autoPublishedNum?: number,
    public totalPublishedPrice?: number,
    public publishedDt?: Date,
    public expireDt?: Date,
    public CouponPublishedHistoriesState?: CouponPublishedHistoriesState
  ) {}
}
