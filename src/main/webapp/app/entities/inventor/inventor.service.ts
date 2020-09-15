import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IInventor } from 'app/shared/model/inventor.model';

type EntityResponseType = HttpResponse<IInventor>;
type EntityArrayResponseType = HttpResponse<IInventor[]>;

@Injectable({ providedIn: 'root' })
export class InventorService {
  public resourceUrl = SERVER_API_URL + 'api/inventors';

  constructor(protected http: HttpClient) {}

  create(inventor: IInventor): Observable<EntityResponseType> {
    return this.http.post<IInventor>(this.resourceUrl, inventor, { observe: 'response' });
  }

  update(inventor: IInventor): Observable<EntityResponseType> {
    return this.http.put<IInventor>(this.resourceUrl, inventor, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IInventor>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IInventor[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
