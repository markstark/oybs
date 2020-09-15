import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IInventoryAnalysis } from 'app/shared/model/inventory-analysis.model';
import { InventoryAnalysisService } from './inventory-analysis.service';
import { InventoryAnalysisDeleteDialogComponent } from './inventory-analysis-delete-dialog.component';

@Component({
  selector: 'jhi-inventory-analysis',
  templateUrl: './inventory-analysis.component.html',
})
export class InventoryAnalysisComponent implements OnInit, OnDestroy {
  inventoryAnalyses?: IInventoryAnalysis[];
  eventSubscriber?: Subscription;

  constructor(
    protected inventoryAnalysisService: InventoryAnalysisService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.inventoryAnalysisService.query().subscribe((res: HttpResponse<IInventoryAnalysis[]>) => (this.inventoryAnalyses = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInInventoryAnalyses();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IInventoryAnalysis): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInInventoryAnalyses(): void {
    this.eventSubscriber = this.eventManager.subscribe('inventoryAnalysisListModification', () => this.loadAll());
  }

  delete(inventoryAnalysis: IInventoryAnalysis): void {
    const modalRef = this.modalService.open(InventoryAnalysisDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.inventoryAnalysis = inventoryAnalysis;
  }
}
