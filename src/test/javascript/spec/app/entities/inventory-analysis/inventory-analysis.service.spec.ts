import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { InventoryAnalysisService } from 'app/entities/inventory-analysis/inventory-analysis.service';
import { IInventoryAnalysis, InventoryAnalysis } from 'app/shared/model/inventory-analysis.model';

describe('Service Tests', () => {
  describe('InventoryAnalysis Service', () => {
    let injector: TestBed;
    let service: InventoryAnalysisService;
    let httpMock: HttpTestingController;
    let elemDefault: IInventoryAnalysis;
    let expectedResult: IInventoryAnalysis | IInventoryAnalysis[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(InventoryAnalysisService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new InventoryAnalysis(
        0,
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            accountingDate: currentDate.format(DATE_FORMAT),
            trxDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a InventoryAnalysis', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            accountingDate: currentDate.format(DATE_FORMAT),
            trxDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            accountingDate: currentDate,
            trxDate: currentDate,
          },
          returnedFromService
        );

        service.create(new InventoryAnalysis()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a InventoryAnalysis', () => {
        const returnedFromService = Object.assign(
          {
            detailOrg: 'BBBBBB',
            accountingDate: currentDate.format(DATE_FORMAT),
            trxWeek: 'BBBBBB',
            trxTyp: 'BBBBBB',
            costGroup: 'BBBBBB',
            moNo: 'BBBBBB',
            partNo: 'BBBBBB',
            toolId: 'BBBBBB',
            stationFamily: 'BBBBBB',
            trxQty: 1,
            trxUom: 'BBBBBB',
            unitCost: 'BBBBBB',
            accountedAmt: 'BBBBBB',
            partDescr: 'BBBBBB',
            naturalAccount: 'BBBBBB',
            vendorName: 'BBBBBB',
            supplierClassification: 'BBBBBB',
            description: 'BBBBBB',
            glLineDescr: 'BBBBBB',
            summaryOrg: 'BBBBBB',
            costCenterId: 'BBBBBB',
            costCenter: 'BBBBBB',
            summaryAccount: 'BBBBBB',
            parentAccount: 'BBBBBB',
            accountId: 'BBBBBB',
            trxDate: currentDate.format(DATE_FORMAT),
            createdBy: 'BBBBBB',
            orgCode: 'BBBBBB',
            lotNo: 'BBBBBB',
            poItemCat: 'BBBBBB',
            moLineNo: 1,
            poNo: 'BBBBBB',
            poLineNo: 'BBBBBB',
            jeBatchName: 'BBBBBB',
            jeName: 'BBBBBB',
            jeLineNo: 1,
            trxAcc: 'BBBBBB',
            trxNaturalAcc: 'BBBBBB',
            glAcc: 'BBBBBB',
            currency: 'BBBBBB',
            enteredAmt: 'BBBBBB',
            source: 'BBBBBB',
            period: 'BBBBBB',
            trxId: 'BBBBBB',
            uniqueId: 'BBBBBB',
            entityReview: 'BBBBBB',
            partLifetime: 'BBBBBB',
            partFixedProblem: 'BBBBBB',
            returnToStores: 'BBBBBB',
            repeatFail: 'BBBBBB',
            warrantyClaim: 'BBBBBB',
            submitForWarranty: 'BBBBBB',
            repairablePart: 'BBBBBB',
            submitForRepair: 'BBBBBB',
            partSourcing: 'BBBBBB',
            commentFollowup: 'BBBBBB',
            followupComplete: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            accountingDate: currentDate,
            trxDate: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of InventoryAnalysis', () => {
        const returnedFromService = Object.assign(
          {
            detailOrg: 'BBBBBB',
            accountingDate: currentDate.format(DATE_FORMAT),
            trxWeek: 'BBBBBB',
            trxTyp: 'BBBBBB',
            costGroup: 'BBBBBB',
            moNo: 'BBBBBB',
            partNo: 'BBBBBB',
            toolId: 'BBBBBB',
            stationFamily: 'BBBBBB',
            trxQty: 1,
            trxUom: 'BBBBBB',
            unitCost: 'BBBBBB',
            accountedAmt: 'BBBBBB',
            partDescr: 'BBBBBB',
            naturalAccount: 'BBBBBB',
            vendorName: 'BBBBBB',
            supplierClassification: 'BBBBBB',
            description: 'BBBBBB',
            glLineDescr: 'BBBBBB',
            summaryOrg: 'BBBBBB',
            costCenterId: 'BBBBBB',
            costCenter: 'BBBBBB',
            summaryAccount: 'BBBBBB',
            parentAccount: 'BBBBBB',
            accountId: 'BBBBBB',
            trxDate: currentDate.format(DATE_FORMAT),
            createdBy: 'BBBBBB',
            orgCode: 'BBBBBB',
            lotNo: 'BBBBBB',
            poItemCat: 'BBBBBB',
            moLineNo: 1,
            poNo: 'BBBBBB',
            poLineNo: 'BBBBBB',
            jeBatchName: 'BBBBBB',
            jeName: 'BBBBBB',
            jeLineNo: 1,
            trxAcc: 'BBBBBB',
            trxNaturalAcc: 'BBBBBB',
            glAcc: 'BBBBBB',
            currency: 'BBBBBB',
            enteredAmt: 'BBBBBB',
            source: 'BBBBBB',
            period: 'BBBBBB',
            trxId: 'BBBBBB',
            uniqueId: 'BBBBBB',
            entityReview: 'BBBBBB',
            partLifetime: 'BBBBBB',
            partFixedProblem: 'BBBBBB',
            returnToStores: 'BBBBBB',
            repeatFail: 'BBBBBB',
            warrantyClaim: 'BBBBBB',
            submitForWarranty: 'BBBBBB',
            repairablePart: 'BBBBBB',
            submitForRepair: 'BBBBBB',
            partSourcing: 'BBBBBB',
            commentFollowup: 'BBBBBB',
            followupComplete: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            accountingDate: currentDate,
            trxDate: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a InventoryAnalysis', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
