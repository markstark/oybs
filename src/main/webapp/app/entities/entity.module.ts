import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'inventory-analysis',
        loadChildren: () => import('./inventory-analysis/inventory-analysis.module').then(m => m.OybsInventoryAnalysisModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class OybsEntityModule {}
