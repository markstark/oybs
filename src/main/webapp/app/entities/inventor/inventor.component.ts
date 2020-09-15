import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IInventor } from 'app/shared/model/inventor.model';
import { InventorService } from './inventor.service';
import { InventorDeleteDialogComponent } from './inventor-delete-dialog.component';

@Component({
  selector: 'jhi-inventor',
  templateUrl: './inventor.component.html',
})
export class InventorComponent implements OnInit, OnDestroy {
  inventors?: IInventor[];
  eventSubscriber?: Subscription;

  constructor(protected inventorService: InventorService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.inventorService.query().subscribe((res: HttpResponse<IInventor[]>) => (this.inventors = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInInventors();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IInventor): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInInventors(): void {
    this.eventSubscriber = this.eventManager.subscribe('inventorListModification', () => this.loadAll());
  }

  delete(inventor: IInventor): void {
    const modalRef = this.modalService.open(InventorDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.inventor = inventor;
  }
}
