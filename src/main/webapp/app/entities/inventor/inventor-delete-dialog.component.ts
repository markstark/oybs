import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IInventor } from 'app/shared/model/inventor.model';
import { InventorService } from './inventor.service';

@Component({
  templateUrl: './inventor-delete-dialog.component.html',
})
export class InventorDeleteDialogComponent {
  inventor?: IInventor;

  constructor(protected inventorService: InventorService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.inventorService.delete(id).subscribe(() => {
      this.eventManager.broadcast('inventorListModification');
      this.activeModal.close();
    });
  }
}
