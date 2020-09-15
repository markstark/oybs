export interface IInventor {
  id?: number;
  vendorName?: string;
  trxDay?: string;
  trxMonth?: string;
  trxWeek?: string;
  toolId?: string;
}

export class Inventor implements IInventor {
  constructor(
    public id?: number,
    public vendorName?: string,
    public trxDay?: string,
    public trxMonth?: string,
    public trxWeek?: string,
    public toolId?: string
  ) {}
}
