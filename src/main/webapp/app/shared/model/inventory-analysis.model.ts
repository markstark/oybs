import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';

export interface IInventoryAnalysis {
  id?: number;
  detailOrg?: string;
  accountingDate?: Moment;
  trxWeek?: string;
  trxTyp?: string;
  costGroup?: string;
  moNo?: string;
  partNo?: string;
  toolId?: string;
  stationFamily?: string;
  trxQty?: number;
  trxUom?: string;
  unitCost?: string;
  accountedAmt?: string;
  partDescr?: string;
  naturalAccount?: string;
  vendorName?: string;
  supplierClassification?: string;
  description?: string;
  glLineDescr?: string;
  summaryOrg?: string;
  costCenterId?: string;
  costCenter?: string;
  summaryAccount?: string;
  parentAccount?: string;
  accountId?: string;
  trxDate?: Moment;
  createdBy?: string;
  orgCode?: string;
  lotNo?: string;
  poItemCat?: string;
  moLineNo?: number;
  poNo?: string;
  poLineNo?: string;
  jeBatchName?: string;
  jeName?: string;
  jeLineNo?: number;
  trxAcc?: string;
  trxNaturalAcc?: string;
  glAcc?: string;
  currency?: string;
  enteredAmt?: string;
  source?: string;
  period?: string;
  trxId?: string;
  uniqueId?: string;
  entityReview?: string;
  partLifetime?: string;
  partFixedProblem?: string;
  returnToStores?: string;
  repeatFail?: string;
  warrantyClaim?: string;
  submitForWarranty?: string;
  repairablePart?: string;
  submitForRepair?: string;
  partSourcing?: string;
  commentFollowup?: string;
  followupComplete?: string;
  user?: IUser;
}

export class InventoryAnalysis implements IInventoryAnalysis {
  constructor(
    public id?: number,
    public detailOrg?: string,
    public accountingDate?: Moment,
    public trxWeek?: string,
    public trxTyp?: string,
    public costGroup?: string,
    public moNo?: string,
    public partNo?: string,
    public toolId?: string,
    public stationFamily?: string,
    public trxQty?: number,
    public trxUom?: string,
    public unitCost?: string,
    public accountedAmt?: string,
    public partDescr?: string,
    public naturalAccount?: string,
    public vendorName?: string,
    public supplierClassification?: string,
    public description?: string,
    public glLineDescr?: string,
    public summaryOrg?: string,
    public costCenterId?: string,
    public costCenter?: string,
    public summaryAccount?: string,
    public parentAccount?: string,
    public accountId?: string,
    public trxDate?: Moment,
    public createdBy?: string,
    public orgCode?: string,
    public lotNo?: string,
    public poItemCat?: string,
    public moLineNo?: number,
    public poNo?: string,
    public poLineNo?: string,
    public jeBatchName?: string,
    public jeName?: string,
    public jeLineNo?: number,
    public trxAcc?: string,
    public trxNaturalAcc?: string,
    public glAcc?: string,
    public currency?: string,
    public enteredAmt?: string,
    public source?: string,
    public period?: string,
    public trxId?: string,
    public uniqueId?: string,
    public entityReview?: string,
    public partLifetime?: string,
    public partFixedProblem?: string,
    public returnToStores?: string,
    public repeatFail?: string,
    public warrantyClaim?: string,
    public submitForWarranty?: string,
    public repairablePart?: string,
    public submitForRepair?: string,
    public partSourcing?: string,
    public commentFollowup?: string,
    public followupComplete?: string,
    public user?: IUser
  ) {}
}
