import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IInventoryAnalysis } from 'app/shared/model/inventory-analysis.model';
import { InventoryAnalysisService } from './inventory-analysis.service';

@Component({
  templateUrl: './inventory-analysis-delete-dialog.component.html',
})
export class InventoryAnalysisDeleteDialogComponent {
  inventoryAnalysis?: IInventoryAnalysis;

  constructor(
    protected inventoryAnalysisService: InventoryAnalysisService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.inventoryAnalysisService.delete(id).subscribe(() => {
      this.eventManager.broadcast('inventoryAnalysisListModification');
      this.activeModal.close();
    });
  }
}
