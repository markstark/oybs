import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IInventoryAnalysis, InventoryAnalysis } from 'app/shared/model/inventory-analysis.model';
import { InventoryAnalysisService } from './inventory-analysis.service';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';

@Component({
  selector: 'jhi-inventory-analysis-update',
  templateUrl: './inventory-analysis-update.component.html',
})
export class InventoryAnalysisUpdateComponent implements OnInit {
  isSaving = false;
  users: IUser[] = [];
  accountingDateDp: any;
  trxDateDp: any;

  editForm = this.fb.group({
    id: [],
    detailOrg: [],
    accountingDate: [],
    trxWeek: [],
    trxTyp: [],
    costGroup: [],
    moNo: [],
    partNo: [],
    toolId: [],
    stationFamily: [],
    trxQty: [],
    trxUom: [],
    unitCost: [],
    accountedAmt: [],
    partDescr: [],
    naturalAccount: [],
    vendorName: [],
    supplierClassification: [],
    description: [],
    glLineDescr: [],
    summaryOrg: [],
    costCenterId: [],
    costCenter: [],
    summaryAccount: [],
    parentAccount: [],
    accountId: [],
    trxDate: [],
    createdBy: [],
    orgCode: [],
    lotNo: [],
    poItemCat: [],
    moLineNo: [],
    poNo: [],
    poLineNo: [],
    jeBatchName: [],
    jeName: [],
    jeLineNo: [],
    trxAcc: [],
    trxNaturalAcc: [],
    glAcc: [],
    currency: [],
    enteredAmt: [],
    source: [],
    period: [],
    trxId: [],
    uniqueId: [],
    entityReview: [],
    partLifetime: [],
    partFixedProblem: [],
    returnToStores: [],
    repeatFail: [],
    warrantyClaim: [],
    submitForWarranty: [],
    repairablePart: [],
    submitForRepair: [],
    partSourcing: [],
    commentFollowup: [],
    followupComplete: [],
    user: [],
  });

  constructor(
    protected inventoryAnalysisService: InventoryAnalysisService,
    protected userService: UserService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ inventoryAnalysis }) => {
      this.updateForm(inventoryAnalysis);

      this.userService.query().subscribe((res: HttpResponse<IUser[]>) => (this.users = res.body || []));
    });
  }

  updateForm(inventoryAnalysis: IInventoryAnalysis): void {
    this.editForm.patchValue({
      id: inventoryAnalysis.id,
      detailOrg: inventoryAnalysis.detailOrg,
      accountingDate: inventoryAnalysis.accountingDate,
      trxWeek: inventoryAnalysis.trxWeek,
      trxTyp: inventoryAnalysis.trxTyp,
      costGroup: inventoryAnalysis.costGroup,
      moNo: inventoryAnalysis.moNo,
      partNo: inventoryAnalysis.partNo,
      toolId: inventoryAnalysis.toolId,
      stationFamily: inventoryAnalysis.stationFamily,
      trxQty: inventoryAnalysis.trxQty,
      trxUom: inventoryAnalysis.trxUom,
      unitCost: inventoryAnalysis.unitCost,
      accountedAmt: inventoryAnalysis.accountedAmt,
      partDescr: inventoryAnalysis.partDescr,
      naturalAccount: inventoryAnalysis.naturalAccount,
      vendorName: inventoryAnalysis.vendorName,
      supplierClassification: inventoryAnalysis.supplierClassification,
      description: inventoryAnalysis.description,
      glLineDescr: inventoryAnalysis.glLineDescr,
      summaryOrg: inventoryAnalysis.summaryOrg,
      costCenterId: inventoryAnalysis.costCenterId,
      costCenter: inventoryAnalysis.costCenter,
      summaryAccount: inventoryAnalysis.summaryAccount,
      parentAccount: inventoryAnalysis.parentAccount,
      accountId: inventoryAnalysis.accountId,
      trxDate: inventoryAnalysis.trxDate,
      createdBy: inventoryAnalysis.createdBy,
      orgCode: inventoryAnalysis.orgCode,
      lotNo: inventoryAnalysis.lotNo,
      poItemCat: inventoryAnalysis.poItemCat,
      moLineNo: inventoryAnalysis.moLineNo,
      poNo: inventoryAnalysis.poNo,
      poLineNo: inventoryAnalysis.poLineNo,
      jeBatchName: inventoryAnalysis.jeBatchName,
      jeName: inventoryAnalysis.jeName,
      jeLineNo: inventoryAnalysis.jeLineNo,
      trxAcc: inventoryAnalysis.trxAcc,
      trxNaturalAcc: inventoryAnalysis.trxNaturalAcc,
      glAcc: inventoryAnalysis.glAcc,
      currency: inventoryAnalysis.currency,
      enteredAmt: inventoryAnalysis.enteredAmt,
      source: inventoryAnalysis.source,
      period: inventoryAnalysis.period,
      trxId: inventoryAnalysis.trxId,
      uniqueId: inventoryAnalysis.uniqueId,
      entityReview: inventoryAnalysis.entityReview,
      partLifetime: inventoryAnalysis.partLifetime,
      partFixedProblem: inventoryAnalysis.partFixedProblem,
      returnToStores: inventoryAnalysis.returnToStores,
      repeatFail: inventoryAnalysis.repeatFail,
      warrantyClaim: inventoryAnalysis.warrantyClaim,
      submitForWarranty: inventoryAnalysis.submitForWarranty,
      repairablePart: inventoryAnalysis.repairablePart,
      submitForRepair: inventoryAnalysis.submitForRepair,
      partSourcing: inventoryAnalysis.partSourcing,
      commentFollowup: inventoryAnalysis.commentFollowup,
      followupComplete: inventoryAnalysis.followupComplete,
      user: inventoryAnalysis.user,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const inventoryAnalysis = this.createFromForm();
    if (inventoryAnalysis.id !== undefined) {
      this.subscribeToSaveResponse(this.inventoryAnalysisService.update(inventoryAnalysis));
    } else {
      this.subscribeToSaveResponse(this.inventoryAnalysisService.create(inventoryAnalysis));
    }
  }

  private createFromForm(): IInventoryAnalysis {
    return {
      ...new InventoryAnalysis(),
      id: this.editForm.get(['id'])!.value,
      detailOrg: this.editForm.get(['detailOrg'])!.value,
      accountingDate: this.editForm.get(['accountingDate'])!.value,
      trxWeek: this.editForm.get(['trxWeek'])!.value,
      trxTyp: this.editForm.get(['trxTyp'])!.value,
      costGroup: this.editForm.get(['costGroup'])!.value,
      moNo: this.editForm.get(['moNo'])!.value,
      partNo: this.editForm.get(['partNo'])!.value,
      toolId: this.editForm.get(['toolId'])!.value,
      stationFamily: this.editForm.get(['stationFamily'])!.value,
      trxQty: this.editForm.get(['trxQty'])!.value,
      trxUom: this.editForm.get(['trxUom'])!.value,
      unitCost: this.editForm.get(['unitCost'])!.value,
      accountedAmt: this.editForm.get(['accountedAmt'])!.value,
      partDescr: this.editForm.get(['partDescr'])!.value,
      naturalAccount: this.editForm.get(['naturalAccount'])!.value,
      vendorName: this.editForm.get(['vendorName'])!.value,
      supplierClassification: this.editForm.get(['supplierClassification'])!.value,
      description: this.editForm.get(['description'])!.value,
      glLineDescr: this.editForm.get(['glLineDescr'])!.value,
      summaryOrg: this.editForm.get(['summaryOrg'])!.value,
      costCenterId: this.editForm.get(['costCenterId'])!.value,
      costCenter: this.editForm.get(['costCenter'])!.value,
      summaryAccount: this.editForm.get(['summaryAccount'])!.value,
      parentAccount: this.editForm.get(['parentAccount'])!.value,
      accountId: this.editForm.get(['accountId'])!.value,
      trxDate: this.editForm.get(['trxDate'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      orgCode: this.editForm.get(['orgCode'])!.value,
      lotNo: this.editForm.get(['lotNo'])!.value,
      poItemCat: this.editForm.get(['poItemCat'])!.value,
      moLineNo: this.editForm.get(['moLineNo'])!.value,
      poNo: this.editForm.get(['poNo'])!.value,
      poLineNo: this.editForm.get(['poLineNo'])!.value,
      jeBatchName: this.editForm.get(['jeBatchName'])!.value,
      jeName: this.editForm.get(['jeName'])!.value,
      jeLineNo: this.editForm.get(['jeLineNo'])!.value,
      trxAcc: this.editForm.get(['trxAcc'])!.value,
      trxNaturalAcc: this.editForm.get(['trxNaturalAcc'])!.value,
      glAcc: this.editForm.get(['glAcc'])!.value,
      currency: this.editForm.get(['currency'])!.value,
      enteredAmt: this.editForm.get(['enteredAmt'])!.value,
      source: this.editForm.get(['source'])!.value,
      period: this.editForm.get(['period'])!.value,
      trxId: this.editForm.get(['trxId'])!.value,
      uniqueId: this.editForm.get(['uniqueId'])!.value,
      entityReview: this.editForm.get(['entityReview'])!.value,
      partLifetime: this.editForm.get(['partLifetime'])!.value,
      partFixedProblem: this.editForm.get(['partFixedProblem'])!.value,
      returnToStores: this.editForm.get(['returnToStores'])!.value,
      repeatFail: this.editForm.get(['repeatFail'])!.value,
      warrantyClaim: this.editForm.get(['warrantyClaim'])!.value,
      submitForWarranty: this.editForm.get(['submitForWarranty'])!.value,
      repairablePart: this.editForm.get(['repairablePart'])!.value,
      submitForRepair: this.editForm.get(['submitForRepair'])!.value,
      partSourcing: this.editForm.get(['partSourcing'])!.value,
      commentFollowup: this.editForm.get(['commentFollowup'])!.value,
      followupComplete: this.editForm.get(['followupComplete'])!.value,
      user: this.editForm.get(['user'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IInventoryAnalysis>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IUser): any {
    return item.id;
  }
}
