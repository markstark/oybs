import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OybsTestModule } from '../../../test.module';
import { InventoryAnalysisComponent } from 'app/entities/inventory-analysis/inventory-analysis.component';
import { InventoryAnalysisService } from 'app/entities/inventory-analysis/inventory-analysis.service';
import { InventoryAnalysis } from 'app/shared/model/inventory-analysis.model';

describe('Component Tests', () => {
  describe('InventoryAnalysis Management Component', () => {
    let comp: InventoryAnalysisComponent;
    let fixture: ComponentFixture<InventoryAnalysisComponent>;
    let service: InventoryAnalysisService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OybsTestModule],
        declarations: [InventoryAnalysisComponent],
      })
        .overrideTemplate(InventoryAnalysisComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(InventoryAnalysisComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(InventoryAnalysisService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new InventoryAnalysis(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.inventoryAnalyses && comp.inventoryAnalyses[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
