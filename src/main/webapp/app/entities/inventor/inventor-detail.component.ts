import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IInventor } from 'app/shared/model/inventor.model';

@Component({
  selector: 'jhi-inventor-detail',
  templateUrl: './inventor-detail.component.html',
})
export class InventorDetailComponent implements OnInit {
  inventor: IInventor | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ inventor }) => (this.inventor = inventor));
  }

  previousState(): void {
    window.history.back();
  }
}
