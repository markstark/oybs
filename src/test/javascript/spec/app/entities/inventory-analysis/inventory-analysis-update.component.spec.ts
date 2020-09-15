import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OybsTestModule } from '../../../test.module';
import { InventoryAnalysisUpdateComponent } from 'app/entities/inventory-analysis/inventory-analysis-update.component';
import { InventoryAnalysisService } from 'app/entities/inventory-analysis/inventory-analysis.service';
import { InventoryAnalysis } from 'app/shared/model/inventory-analysis.model';

describe('Component Tests', () => {
  describe('InventoryAnalysis Management Update Component', () => {
    let comp: InventoryAnalysisUpdateComponent;
    let fixture: ComponentFixture<InventoryAnalysisUpdateComponent>;
    let service: InventoryAnalysisService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OybsTestModule],
        declarations: [InventoryAnalysisUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(InventoryAnalysisUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(InventoryAnalysisUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(InventoryAnalysisService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new InventoryAnalysis(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new InventoryAnalysis();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
