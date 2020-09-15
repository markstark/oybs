import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IInventoryAnalysis } from 'app/shared/model/inventory-analysis.model';

type EntityResponseType = HttpResponse<IInventoryAnalysis>;
type EntityArrayResponseType = HttpResponse<IInventoryAnalysis[]>;

@Injectable({ providedIn: 'root' })
export class InventoryAnalysisService {
  public resourceUrl = SERVER_API_URL + 'api/inventory-analyses';

  constructor(protected http: HttpClient) {}

  create(inventoryAnalysis: IInventoryAnalysis): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(inventoryAnalysis);
    return this.http
      .post<IInventoryAnalysis>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(inventoryAnalysis: IInventoryAnalysis): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(inventoryAnalysis);
    return this.http
      .put<IInventoryAnalysis>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IInventoryAnalysis>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IInventoryAnalysis[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(inventoryAnalysis: IInventoryAnalysis): IInventoryAnalysis {
    const copy: IInventoryAnalysis = Object.assign({}, inventoryAnalysis, {
      accountingDate:
        inventoryAnalysis.accountingDate && inventoryAnalysis.accountingDate.isValid()
          ? inventoryAnalysis.accountingDate.format(DATE_FORMAT)
          : undefined,
      trxDate: inventoryAnalysis.trxDate && inventoryAnalysis.trxDate.isValid() ? inventoryAnalysis.trxDate.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.accountingDate = res.body.accountingDate ? moment(res.body.accountingDate) : undefined;
      res.body.trxDate = res.body.trxDate ? moment(res.body.trxDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((inventoryAnalysis: IInventoryAnalysis) => {
        inventoryAnalysis.accountingDate = inventoryAnalysis.accountingDate ? moment(inventoryAnalysis.accountingDate) : undefined;
        inventoryAnalysis.trxDate = inventoryAnalysis.trxDate ? moment(inventoryAnalysis.trxDate) : undefined;
      });
    }
    return res;
  }
}
