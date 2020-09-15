import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IInventoryAnalysis, InventoryAnalysis } from 'app/shared/model/inventory-analysis.model';
import { InventoryAnalysisService } from './inventory-analysis.service';
import { InventoryAnalysisComponent } from './inventory-analysis.component';
import { InventoryAnalysisDetailComponent } from './inventory-analysis-detail.component';
import { InventoryAnalysisUpdateComponent } from './inventory-analysis-update.component';

@Injectable({ providedIn: 'root' })
export class InventoryAnalysisResolve implements Resolve<IInventoryAnalysis> {
  constructor(private service: InventoryAnalysisService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IInventoryAnalysis> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((inventoryAnalysis: HttpResponse<InventoryAnalysis>) => {
          if (inventoryAnalysis.body) {
            return of(inventoryAnalysis.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new InventoryAnalysis());
  }
}

export const inventoryAnalysisRoute: Routes = [
  {
    path: '',
    component: InventoryAnalysisComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'InventoryAnalyses',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: InventoryAnalysisDetailComponent,
    resolve: {
      inventoryAnalysis: InventoryAnalysisResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'InventoryAnalyses',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: InventoryAnalysisUpdateComponent,
    resolve: {
      inventoryAnalysis: InventoryAnalysisResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'InventoryAnalyses',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: InventoryAnalysisUpdateComponent,
    resolve: {
      inventoryAnalysis: InventoryAnalysisResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'InventoryAnalyses',
    },
    canActivate: [UserRouteAccessService],
  },
];
