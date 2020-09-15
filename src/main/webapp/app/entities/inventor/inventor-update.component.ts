import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IInventor, Inventor } from 'app/shared/model/inventor.model';
import { InventorService } from './inventor.service';

@Component({
  selector: 'jhi-inventor-update',
  templateUrl: './inventor-update.component.html',
})
export class InventorUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    vendorName: [],
    trxDay: [],
    trxMonth: [],
    trxWeek: [],
    toolId: [],
  });

  constructor(protected inventorService: InventorService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ inventor }) => {
      this.updateForm(inventor);
    });
  }

  updateForm(inventor: IInventor): void {
    this.editForm.patchValue({
      id: inventor.id,
      vendorName: inventor.vendorName,
      trxDay: inventor.trxDay,
      trxMonth: inventor.trxMonth,
      trxWeek: inventor.trxWeek,
      toolId: inventor.toolId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const inventor = this.createFromForm();
    if (inventor.id !== undefined) {
      this.subscribeToSaveResponse(this.inventorService.update(inventor));
    } else {
      this.subscribeToSaveResponse(this.inventorService.create(inventor));
    }
  }

  private createFromForm(): IInventor {
    return {
      ...new Inventor(),
      id: this.editForm.get(['id'])!.value,
      vendorName: this.editForm.get(['vendorName'])!.value,
      trxDay: this.editForm.get(['trxDay'])!.value,
      trxMonth: this.editForm.get(['trxMonth'])!.value,
      trxWeek: this.editForm.get(['trxWeek'])!.value,
      toolId: this.editForm.get(['toolId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IInventor>>): void {
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
}
