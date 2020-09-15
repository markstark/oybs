import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { OybsTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { InventoryAnalysisDeleteDialogComponent } from 'app/entities/inventory-analysis/inventory-analysis-delete-dialog.component';
import { InventoryAnalysisService } from 'app/entities/inventory-analysis/inventory-analysis.service';

describe('Component Tests', () => {
  describe('InventoryAnalysis Management Delete Component', () => {
    let comp: InventoryAnalysisDeleteDialogComponent;
    let fixture: ComponentFixture<InventoryAnalysisDeleteDialogComponent>;
    let service: InventoryAnalysisService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OybsTestModule],
        declarations: [InventoryAnalysisDeleteDialogComponent],
      })
        .overrideTemplate(InventoryAnalysisDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(InventoryAnalysisDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(InventoryAnalysisService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
