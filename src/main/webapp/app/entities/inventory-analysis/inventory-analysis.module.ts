import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OybsSharedModule } from 'app/shared/shared.module';
import { InventoryAnalysisComponent } from './inventory-analysis.component';
import { InventoryAnalysisDetailComponent } from './inventory-analysis-detail.component';
import { InventoryAnalysisUpdateComponent } from './inventory-analysis-update.component';
import { InventoryAnalysisDeleteDialogComponent } from './inventory-analysis-delete-dialog.component';
import { inventoryAnalysisRoute } from './inventory-analysis.route';

@NgModule({
  imports: [OybsSharedModule, RouterModule.forChild(inventoryAnalysisRoute)],
  declarations: [
    InventoryAnalysisComponent,
    InventoryAnalysisDetailComponent,
    InventoryAnalysisUpdateComponent,
    InventoryAnalysisDeleteDialogComponent,
  ],
  entryComponents: [InventoryAnalysisDeleteDialogComponent],
})
export class OybsInventoryAnalysisModule {}
