export interface IAccommodationSales {
  id?: number;
  accommodationId?: number;
  adminUserId?: number;
}

export class AccommodationSales implements IAccommodationSales {
  constructor(public id?: number, public accommodationId?: number, public adminUserId?: number) {}
}
