export interface IBusiness {
  id?: number;
  businessName?: string;
  businessRepresentative?: string;
  businessRegistrationNum?: string;
  businessContactNum?: string;
  businessType?: string;
  businessAddress?: string;
  businessCategory?: string;
  businessFaxNum?: string;
  isHeadquarter?: boolean;
  createdDate?: Date;
}

export class Business implements IBusiness {
  constructor(
    public id?: number,
    public businessName?: string,
    public businessRepresentative?: string,
    public businessRegistrationNum?: string,
    public businessContactNum?: string,
    public businessType?: string,
    public businessAddress?: string,
    public businessCategory?: string,
    public businessFaxNum?: string,
    public isHeadquarter?: boolean,
    public createdDate?: Date
  ) {
    this.isHeadquarter = this.isHeadquarter || false;
  }
}
