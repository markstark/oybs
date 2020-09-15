import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OybsSharedModule } from 'app/shared/shared.module';
import { InventorComponent } from './inventor.component';
import { InventorDetailComponent } from './inventor-detail.component';
import { InventorUpdateComponent } from './inventor-update.component';
import { InventorDeleteDialogComponent } from './inventor-delete-dialog.component';
import { inventorRoute } from './inventor.route';

@NgModule({
  imports: [OybsSharedModule, RouterModule.forChild(inventorRoute)],
  declarations: [InventorComponent, InventorDetailComponent, InventorUpdateComponent, InventorDeleteDialogComponent],
  entryComponents: [InventorDeleteDialogComponent],
})
export class OybsInventorModule {}
