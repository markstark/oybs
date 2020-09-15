import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OybsTestModule } from '../../../test.module';
import { InventorUpdateComponent } from 'app/entities/inventor/inventor-update.component';
import { InventorService } from 'app/entities/inventor/inventor.service';
import { Inventor } from 'app/shared/model/inventor.model';

describe('Component Tests', () => {
  describe('Inventor Management Update Component', () => {
    let comp: InventorUpdateComponent;
    let fixture: ComponentFixture<InventorUpdateComponent>;
    let service: InventorService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OybsTestModule],
        declarations: [InventorUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(InventorUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(InventorUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(InventorService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Inventor(123);
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
        const entity = new Inventor();
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
