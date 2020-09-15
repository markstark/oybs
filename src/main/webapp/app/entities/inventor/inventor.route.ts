import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IInventor, Inventor } from 'app/shared/model/inventor.model';
import { InventorService } from './inventor.service';
import { InventorComponent } from './inventor.component';
import { InventorDetailComponent } from './inventor-detail.component';
import { InventorUpdateComponent } from './inventor-update.component';

@Injectable({ providedIn: 'root' })
export class InventorResolve implements Resolve<IInventor> {
  constructor(private service: InventorService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IInventor> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((inventor: HttpResponse<Inventor>) => {
          if (inventor.body) {
            return of(inventor.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Inventor());
  }
}

export const inventorRoute: Routes = [
  {
    path: '',
    component: InventorComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Inventors',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: InventorDetailComponent,
    resolve: {
      inventor: InventorResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Inventors',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: InventorUpdateComponent,
    resolve: {
      inventor: InventorResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Inventors',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: InventorUpdateComponent,
    resolve: {
      inventor: InventorResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Inventors',
    },
    canActivate: [UserRouteAccessService],
  },
];
