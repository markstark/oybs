import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IInventoryAnalysis } from 'app/shared/model/inventory-analysis.model';

@Component({
  selector: 'jhi-inventory-analysis-detail',
  templateUrl: './inventory-analysis-detail.component.html',
})
export class InventoryAnalysisDetailComponent implements OnInit {
  inventoryAnalysis: IInventoryAnalysis | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ inventoryAnalysis }) => (this.inventoryAnalysis = inventoryAnalysis));
  }

  previousState(): void {
    window.history.back();
  }
}
