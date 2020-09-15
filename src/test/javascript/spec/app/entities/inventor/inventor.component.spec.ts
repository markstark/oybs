import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OybsTestModule } from '../../../test.module';
import { InventorComponent } from 'app/entities/inventor/inventor.component';
import { InventorService } from 'app/entities/inventor/inventor.service';
import { Inventor } from 'app/shared/model/inventor.model';

describe('Component Tests', () => {
  describe('Inventor Management Component', () => {
    let comp: InventorComponent;
    let fixture: ComponentFixture<InventorComponent>;
    let service: InventorService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OybsTestModule],
        declarations: [InventorComponent],
      })
        .overrideTemplate(InventorComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(InventorComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(InventorService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Inventor(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.inventors && comp.inventors[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
