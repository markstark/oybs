import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OybsTestModule } from '../../../test.module';
import { InventorDetailComponent } from 'app/entities/inventor/inventor-detail.component';
import { Inventor } from 'app/shared/model/inventor.model';

describe('Component Tests', () => {
  describe('Inventor Management Detail Component', () => {
    let comp: InventorDetailComponent;
    let fixture: ComponentFixture<InventorDetailComponent>;
    const route = ({ data: of({ inventor: new Inventor(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OybsTestModule],
        declarations: [InventorDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(InventorDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(InventorDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load inventor on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.inventor).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
