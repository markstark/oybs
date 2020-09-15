import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OybsTestModule } from '../../../test.module';
import { InventoryAnalysisDetailComponent } from 'app/entities/inventory-analysis/inventory-analysis-detail.component';
import { InventoryAnalysis } from 'app/shared/model/inventory-analysis.model';

describe('Component Tests', () => {
  describe('InventoryAnalysis Management Detail Component', () => {
    let comp: InventoryAnalysisDetailComponent;
    let fixture: ComponentFixture<InventoryAnalysisDetailComponent>;
    const route = ({ data: of({ inventoryAnalysis: new InventoryAnalysis(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OybsTestModule],
        declarations: [InventoryAnalysisDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(InventoryAnalysisDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(InventoryAnalysisDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load inventoryAnalysis on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.inventoryAnalysis).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
