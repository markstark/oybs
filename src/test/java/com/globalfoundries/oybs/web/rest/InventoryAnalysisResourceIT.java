package com.globalfoundries.oybs.web.rest;

import com.globalfoundries.oybs.OybsApp;
import com.globalfoundries.oybs.domain.InventoryAnalysis;
import com.globalfoundries.oybs.repository.InventoryAnalysisRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link InventoryAnalysisResource} REST controller.
 */
@SpringBootTest(classes = OybsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class InventoryAnalysisResourceIT {

    private static final String DEFAULT_DETAIL_ORG = "AAAAAAAAAA";
    private static final String UPDATED_DETAIL_ORG = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ACCOUNTING_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ACCOUNTING_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_TRX_WEEK = "AAAAAAAAAA";
    private static final String UPDATED_TRX_WEEK = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_TYP = "AAAAAAAAAA";
    private static final String UPDATED_TRX_TYP = "BBBBBBBBBB";

    private static final String DEFAULT_COST_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_COST_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_MO_NO = "AAAAAAAAAA";
    private static final String UPDATED_MO_NO = "BBBBBBBBBB";

    private static final String DEFAULT_PART_NO = "AAAAAAAAAA";
    private static final String UPDATED_PART_NO = "BBBBBBBBBB";

    private static final String DEFAULT_TOOL_ID = "AAAAAAAAAA";
    private static final String UPDATED_TOOL_ID = "BBBBBBBBBB";

    private static final String DEFAULT_STATION_FAMILY = "AAAAAAAAAA";
    private static final String UPDATED_STATION_FAMILY = "BBBBBBBBBB";

    private static final Integer DEFAULT_TRX_QTY = 1;
    private static final Integer UPDATED_TRX_QTY = 2;

    private static final String DEFAULT_TRX_UOM = "AAAAAAAAAA";
    private static final String UPDATED_TRX_UOM = "BBBBBBBBBB";

    private static final String DEFAULT_UNIT_COST = "AAAAAAAAAA";
    private static final String UPDATED_UNIT_COST = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNTED_AMT = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNTED_AMT = "BBBBBBBBBB";

    private static final String DEFAULT_PART_DESCR = "AAAAAAAAAA";
    private static final String UPDATED_PART_DESCR = "BBBBBBBBBB";

    private static final String DEFAULT_NATURAL_ACCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_NATURAL_ACCOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_VENDOR_NAME = "AAAAAAAAAA";
    private static final String UPDATED_VENDOR_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER_CLASSIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER_CLASSIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_GL_LINE_DESCR = "AAAAAAAAAA";
    private static final String UPDATED_GL_LINE_DESCR = "BBBBBBBBBB";

    private static final String DEFAULT_SUMMARY_ORG = "AAAAAAAAAA";
    private static final String UPDATED_SUMMARY_ORG = "BBBBBBBBBB";

    private static final String DEFAULT_COST_CENTER_ID = "AAAAAAAAAA";
    private static final String UPDATED_COST_CENTER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_COST_CENTER = "AAAAAAAAAA";
    private static final String UPDATED_COST_CENTER = "BBBBBBBBBB";

    private static final String DEFAULT_SUMMARY_ACCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_SUMMARY_ACCOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_ACCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_ACCOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNT_ID = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNT_ID = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TRX_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRX_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final String DEFAULT_ORG_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ORG_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_LOT_NO = "AAAAAAAAAA";
    private static final String UPDATED_LOT_NO = "BBBBBBBBBB";

    private static final String DEFAULT_PO_ITEM_CAT = "AAAAAAAAAA";
    private static final String UPDATED_PO_ITEM_CAT = "BBBBBBBBBB";

    private static final Integer DEFAULT_MO_LINE_NO = 1;
    private static final Integer UPDATED_MO_LINE_NO = 2;

    private static final String DEFAULT_PO_NO = "AAAAAAAAAA";
    private static final String UPDATED_PO_NO = "BBBBBBBBBB";

    private static final String DEFAULT_PO_LINE_NO = "AAAAAAAAAA";
    private static final String UPDATED_PO_LINE_NO = "BBBBBBBBBB";

    private static final String DEFAULT_JE_BATCH_NAME = "AAAAAAAAAA";
    private static final String UPDATED_JE_BATCH_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_JE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_JE_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_JE_LINE_NO = 1;
    private static final Integer UPDATED_JE_LINE_NO = 2;

    private static final String DEFAULT_TRX_ACC = "AAAAAAAAAA";
    private static final String UPDATED_TRX_ACC = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_NATURAL_ACC = "AAAAAAAAAA";
    private static final String UPDATED_TRX_NATURAL_ACC = "BBBBBBBBBB";

    private static final String DEFAULT_GL_ACC = "AAAAAAAAAA";
    private static final String UPDATED_GL_ACC = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY = "BBBBBBBBBB";

    private static final String DEFAULT_ENTERED_AMT = "AAAAAAAAAA";
    private static final String UPDATED_ENTERED_AMT = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_PERIOD = "AAAAAAAAAA";
    private static final String UPDATED_PERIOD = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_ID = "AAAAAAAAAA";
    private static final String UPDATED_TRX_ID = "BBBBBBBBBB";

    private static final String DEFAULT_UNIQUE_ID = "AAAAAAAAAA";
    private static final String UPDATED_UNIQUE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_REVIEW = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_REVIEW = "BBBBBBBBBB";

    private static final String DEFAULT_PART_LIFETIME = "AAAAAAAAAA";
    private static final String UPDATED_PART_LIFETIME = "BBBBBBBBBB";

    private static final String DEFAULT_PART_FIXED_PROBLEM = "AAAAAAAAAA";
    private static final String UPDATED_PART_FIXED_PROBLEM = "BBBBBBBBBB";

    private static final String DEFAULT_RETURN_TO_STORES = "AAAAAAAAAA";
    private static final String UPDATED_RETURN_TO_STORES = "BBBBBBBBBB";

    private static final String DEFAULT_REPEAT_FAIL = "AAAAAAAAAA";
    private static final String UPDATED_REPEAT_FAIL = "BBBBBBBBBB";

    private static final String DEFAULT_WARRANTY_CLAIM = "AAAAAAAAAA";
    private static final String UPDATED_WARRANTY_CLAIM = "BBBBBBBBBB";

    private static final String DEFAULT_SUBMIT_FOR_WARRANTY = "AAAAAAAAAA";
    private static final String UPDATED_SUBMIT_FOR_WARRANTY = "BBBBBBBBBB";

    private static final String DEFAULT_REPAIRABLE_PART = "AAAAAAAAAA";
    private static final String UPDATED_REPAIRABLE_PART = "BBBBBBBBBB";

    private static final String DEFAULT_SUBMIT_FOR_REPAIR = "AAAAAAAAAA";
    private static final String UPDATED_SUBMIT_FOR_REPAIR = "BBBBBBBBBB";

    private static final String DEFAULT_PART_SOURCING = "AAAAAAAAAA";
    private static final String UPDATED_PART_SOURCING = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT_FOLLOWUP = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT_FOLLOWUP = "BBBBBBBBBB";

    private static final String DEFAULT_FOLLOWUP_COMPLETE = "AAAAAAAAAA";
    private static final String UPDATED_FOLLOWUP_COMPLETE = "BBBBBBBBBB";

    @Autowired
    private InventoryAnalysisRepository inventoryAnalysisRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInventoryAnalysisMockMvc;

    private InventoryAnalysis inventoryAnalysis;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InventoryAnalysis createEntity(EntityManager em) {
        InventoryAnalysis inventoryAnalysis = new InventoryAnalysis()
            .detailOrg(DEFAULT_DETAIL_ORG)
            .accountingDate(DEFAULT_ACCOUNTING_DATE)
            .trxWeek(DEFAULT_TRX_WEEK)
            .trxTyp(DEFAULT_TRX_TYP)
            .costGroup(DEFAULT_COST_GROUP)
            .moNo(DEFAULT_MO_NO)
            .partNo(DEFAULT_PART_NO)
            .toolId(DEFAULT_TOOL_ID)
            .stationFamily(DEFAULT_STATION_FAMILY)
            .trxQty(DEFAULT_TRX_QTY)
            .trxUom(DEFAULT_TRX_UOM)
            .unitCost(DEFAULT_UNIT_COST)
            .accountedAmt(DEFAULT_ACCOUNTED_AMT)
            .partDescr(DEFAULT_PART_DESCR)
            .naturalAccount(DEFAULT_NATURAL_ACCOUNT)
            .vendorName(DEFAULT_VENDOR_NAME)
            .supplierClassification(DEFAULT_SUPPLIER_CLASSIFICATION)
            .description(DEFAULT_DESCRIPTION)
            .glLineDescr(DEFAULT_GL_LINE_DESCR)
            .summaryOrg(DEFAULT_SUMMARY_ORG)
            .costCenterId(DEFAULT_COST_CENTER_ID)
            .costCenter(DEFAULT_COST_CENTER)
            .summaryAccount(DEFAULT_SUMMARY_ACCOUNT)
            .parentAccount(DEFAULT_PARENT_ACCOUNT)
            .accountId(DEFAULT_ACCOUNT_ID)
            .trxDate(DEFAULT_TRX_DATE)
            .createdBy(DEFAULT_CREATED_BY)
            .orgCode(DEFAULT_ORG_CODE)
            .lotNo(DEFAULT_LOT_NO)
            .poItemCat(DEFAULT_PO_ITEM_CAT)
            .moLineNo(DEFAULT_MO_LINE_NO)
            .poNo(DEFAULT_PO_NO)
            .poLineNo(DEFAULT_PO_LINE_NO)
            .jeBatchName(DEFAULT_JE_BATCH_NAME)
            .jeName(DEFAULT_JE_NAME)
            .jeLineNo(DEFAULT_JE_LINE_NO)
            .trxAcc(DEFAULT_TRX_ACC)
            .trxNaturalAcc(DEFAULT_TRX_NATURAL_ACC)
            .glAcc(DEFAULT_GL_ACC)
            .currency(DEFAULT_CURRENCY)
            .enteredAmt(DEFAULT_ENTERED_AMT)
            .source(DEFAULT_SOURCE)
            .period(DEFAULT_PERIOD)
            .trxId(DEFAULT_TRX_ID)
            .uniqueId(DEFAULT_UNIQUE_ID)
            .entityReview(DEFAULT_ENTITY_REVIEW)
            .partLifetime(DEFAULT_PART_LIFETIME)
            .partFixedProblem(DEFAULT_PART_FIXED_PROBLEM)
            .returnToStores(DEFAULT_RETURN_TO_STORES)
            .repeatFail(DEFAULT_REPEAT_FAIL)
            .warrantyClaim(DEFAULT_WARRANTY_CLAIM)
            .submitForWarranty(DEFAULT_SUBMIT_FOR_WARRANTY)
            .repairablePart(DEFAULT_REPAIRABLE_PART)
            .submitForRepair(DEFAULT_SUBMIT_FOR_REPAIR)
            .partSourcing(DEFAULT_PART_SOURCING)
            .commentFollowup(DEFAULT_COMMENT_FOLLOWUP)
            .followupComplete(DEFAULT_FOLLOWUP_COMPLETE);
        return inventoryAnalysis;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InventoryAnalysis createUpdatedEntity(EntityManager em) {
        InventoryAnalysis inventoryAnalysis = new InventoryAnalysis()
            .detailOrg(UPDATED_DETAIL_ORG)
            .accountingDate(UPDATED_ACCOUNTING_DATE)
            .trxWeek(UPDATED_TRX_WEEK)
            .trxTyp(UPDATED_TRX_TYP)
            .costGroup(UPDATED_COST_GROUP)
            .moNo(UPDATED_MO_NO)
            .partNo(UPDATED_PART_NO)
            .toolId(UPDATED_TOOL_ID)
            .stationFamily(UPDATED_STATION_FAMILY)
            .trxQty(UPDATED_TRX_QTY)
            .trxUom(UPDATED_TRX_UOM)
            .unitCost(UPDATED_UNIT_COST)
            .accountedAmt(UPDATED_ACCOUNTED_AMT)
            .partDescr(UPDATED_PART_DESCR)
            .naturalAccount(UPDATED_NATURAL_ACCOUNT)
            .vendorName(UPDATED_VENDOR_NAME)
            .supplierClassification(UPDATED_SUPPLIER_CLASSIFICATION)
            .description(UPDATED_DESCRIPTION)
            .glLineDescr(UPDATED_GL_LINE_DESCR)
            .summaryOrg(UPDATED_SUMMARY_ORG)
            .costCenterId(UPDATED_COST_CENTER_ID)
            .costCenter(UPDATED_COST_CENTER)
            .summaryAccount(UPDATED_SUMMARY_ACCOUNT)
            .parentAccount(UPDATED_PARENT_ACCOUNT)
            .accountId(UPDATED_ACCOUNT_ID)
            .trxDate(UPDATED_TRX_DATE)
            .createdBy(UPDATED_CREATED_BY)
            .orgCode(UPDATED_ORG_CODE)
            .lotNo(UPDATED_LOT_NO)
            .poItemCat(UPDATED_PO_ITEM_CAT)
            .moLineNo(UPDATED_MO_LINE_NO)
            .poNo(UPDATED_PO_NO)
            .poLineNo(UPDATED_PO_LINE_NO)
            .jeBatchName(UPDATED_JE_BATCH_NAME)
            .jeName(UPDATED_JE_NAME)
            .jeLineNo(UPDATED_JE_LINE_NO)
            .trxAcc(UPDATED_TRX_ACC)
            .trxNaturalAcc(UPDATED_TRX_NATURAL_ACC)
            .glAcc(UPDATED_GL_ACC)
            .currency(UPDATED_CURRENCY)
            .enteredAmt(UPDATED_ENTERED_AMT)
            .source(UPDATED_SOURCE)
            .period(UPDATED_PERIOD)
            .trxId(UPDATED_TRX_ID)
            .uniqueId(UPDATED_UNIQUE_ID)
            .entityReview(UPDATED_ENTITY_REVIEW)
            .partLifetime(UPDATED_PART_LIFETIME)
            .partFixedProblem(UPDATED_PART_FIXED_PROBLEM)
            .returnToStores(UPDATED_RETURN_TO_STORES)
            .repeatFail(UPDATED_REPEAT_FAIL)
            .warrantyClaim(UPDATED_WARRANTY_CLAIM)
            .submitForWarranty(UPDATED_SUBMIT_FOR_WARRANTY)
            .repairablePart(UPDATED_REPAIRABLE_PART)
            .submitForRepair(UPDATED_SUBMIT_FOR_REPAIR)
            .partSourcing(UPDATED_PART_SOURCING)
            .commentFollowup(UPDATED_COMMENT_FOLLOWUP)
            .followupComplete(UPDATED_FOLLOWUP_COMPLETE);
        return inventoryAnalysis;
    }

    @BeforeEach
    public void initTest() {
        inventoryAnalysis = createEntity(em);
    }

    @Test
    @Transactional
    public void createInventoryAnalysis() throws Exception {
        int databaseSizeBeforeCreate = inventoryAnalysisRepository.findAll().size();
        // Create the InventoryAnalysis
        restInventoryAnalysisMockMvc.perform(post("/api/inventory-analyses").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(inventoryAnalysis)))
            .andExpect(status().isCreated());

        // Validate the InventoryAnalysis in the database
        List<InventoryAnalysis> inventoryAnalysisList = inventoryAnalysisRepository.findAll();
        assertThat(inventoryAnalysisList).hasSize(databaseSizeBeforeCreate + 1);
        InventoryAnalysis testInventoryAnalysis = inventoryAnalysisList.get(inventoryAnalysisList.size() - 1);
        assertThat(testInventoryAnalysis.getDetailOrg()).isEqualTo(DEFAULT_DETAIL_ORG);
        assertThat(testInventoryAnalysis.getAccountingDate()).isEqualTo(DEFAULT_ACCOUNTING_DATE);
        assertThat(testInventoryAnalysis.getTrxWeek()).isEqualTo(DEFAULT_TRX_WEEK);
        assertThat(testInventoryAnalysis.getTrxTyp()).isEqualTo(DEFAULT_TRX_TYP);
        assertThat(testInventoryAnalysis.getCostGroup()).isEqualTo(DEFAULT_COST_GROUP);
        assertThat(testInventoryAnalysis.getMoNo()).isEqualTo(DEFAULT_MO_NO);
        assertThat(testInventoryAnalysis.getPartNo()).isEqualTo(DEFAULT_PART_NO);
        assertThat(testInventoryAnalysis.getToolId()).isEqualTo(DEFAULT_TOOL_ID);
        assertThat(testInventoryAnalysis.getStationFamily()).isEqualTo(DEFAULT_STATION_FAMILY);
        assertThat(testInventoryAnalysis.getTrxQty()).isEqualTo(DEFAULT_TRX_QTY);
        assertThat(testInventoryAnalysis.getTrxUom()).isEqualTo(DEFAULT_TRX_UOM);
        assertThat(testInventoryAnalysis.getUnitCost()).isEqualTo(DEFAULT_UNIT_COST);
        assertThat(testInventoryAnalysis.getAccountedAmt()).isEqualTo(DEFAULT_ACCOUNTED_AMT);
        assertThat(testInventoryAnalysis.getPartDescr()).isEqualTo(DEFAULT_PART_DESCR);
        assertThat(testInventoryAnalysis.getNaturalAccount()).isEqualTo(DEFAULT_NATURAL_ACCOUNT);
        assertThat(testInventoryAnalysis.getVendorName()).isEqualTo(DEFAULT_VENDOR_NAME);
        assertThat(testInventoryAnalysis.getSupplierClassification()).isEqualTo(DEFAULT_SUPPLIER_CLASSIFICATION);
        assertThat(testInventoryAnalysis.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testInventoryAnalysis.getGlLineDescr()).isEqualTo(DEFAULT_GL_LINE_DESCR);
        assertThat(testInventoryAnalysis.getSummaryOrg()).isEqualTo(DEFAULT_SUMMARY_ORG);
        assertThat(testInventoryAnalysis.getCostCenterId()).isEqualTo(DEFAULT_COST_CENTER_ID);
        assertThat(testInventoryAnalysis.getCostCenter()).isEqualTo(DEFAULT_COST_CENTER);
        assertThat(testInventoryAnalysis.getSummaryAccount()).isEqualTo(DEFAULT_SUMMARY_ACCOUNT);
        assertThat(testInventoryAnalysis.getParentAccount()).isEqualTo(DEFAULT_PARENT_ACCOUNT);
        assertThat(testInventoryAnalysis.getAccountId()).isEqualTo(DEFAULT_ACCOUNT_ID);
        assertThat(testInventoryAnalysis.getTrxDate()).isEqualTo(DEFAULT_TRX_DATE);
        assertThat(testInventoryAnalysis.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testInventoryAnalysis.getOrgCode()).isEqualTo(DEFAULT_ORG_CODE);
        assertThat(testInventoryAnalysis.getLotNo()).isEqualTo(DEFAULT_LOT_NO);
        assertThat(testInventoryAnalysis.getPoItemCat()).isEqualTo(DEFAULT_PO_ITEM_CAT);
        assertThat(testInventoryAnalysis.getMoLineNo()).isEqualTo(DEFAULT_MO_LINE_NO);
        assertThat(testInventoryAnalysis.getPoNo()).isEqualTo(DEFAULT_PO_NO);
        assertThat(testInventoryAnalysis.getPoLineNo()).isEqualTo(DEFAULT_PO_LINE_NO);
        assertThat(testInventoryAnalysis.getJeBatchName()).isEqualTo(DEFAULT_JE_BATCH_NAME);
        assertThat(testInventoryAnalysis.getJeName()).isEqualTo(DEFAULT_JE_NAME);
        assertThat(testInventoryAnalysis.getJeLineNo()).isEqualTo(DEFAULT_JE_LINE_NO);
        assertThat(testInventoryAnalysis.getTrxAcc()).isEqualTo(DEFAULT_TRX_ACC);
        assertThat(testInventoryAnalysis.getTrxNaturalAcc()).isEqualTo(DEFAULT_TRX_NATURAL_ACC);
        assertThat(testInventoryAnalysis.getGlAcc()).isEqualTo(DEFAULT_GL_ACC);
        assertThat(testInventoryAnalysis.getCurrency()).isEqualTo(DEFAULT_CURRENCY);
        assertThat(testInventoryAnalysis.getEnteredAmt()).isEqualTo(DEFAULT_ENTERED_AMT);
        assertThat(testInventoryAnalysis.getSource()).isEqualTo(DEFAULT_SOURCE);
        assertThat(testInventoryAnalysis.getPeriod()).isEqualTo(DEFAULT_PERIOD);
        assertThat(testInventoryAnalysis.getTrxId()).isEqualTo(DEFAULT_TRX_ID);
        assertThat(testInventoryAnalysis.getUniqueId()).isEqualTo(DEFAULT_UNIQUE_ID);
        assertThat(testInventoryAnalysis.getEntityReview()).isEqualTo(DEFAULT_ENTITY_REVIEW);
        assertThat(testInventoryAnalysis.getPartLifetime()).isEqualTo(DEFAULT_PART_LIFETIME);
        assertThat(testInventoryAnalysis.getPartFixedProblem()).isEqualTo(DEFAULT_PART_FIXED_PROBLEM);
        assertThat(testInventoryAnalysis.getReturnToStores()).isEqualTo(DEFAULT_RETURN_TO_STORES);
        assertThat(testInventoryAnalysis.getRepeatFail()).isEqualTo(DEFAULT_REPEAT_FAIL);
        assertThat(testInventoryAnalysis.getWarrantyClaim()).isEqualTo(DEFAULT_WARRANTY_CLAIM);
        assertThat(testInventoryAnalysis.getSubmitForWarranty()).isEqualTo(DEFAULT_SUBMIT_FOR_WARRANTY);
        assertThat(testInventoryAnalysis.getRepairablePart()).isEqualTo(DEFAULT_REPAIRABLE_PART);
        assertThat(testInventoryAnalysis.getSubmitForRepair()).isEqualTo(DEFAULT_SUBMIT_FOR_REPAIR);
        assertThat(testInventoryAnalysis.getPartSourcing()).isEqualTo(DEFAULT_PART_SOURCING);
        assertThat(testInventoryAnalysis.getCommentFollowup()).isEqualTo(DEFAULT_COMMENT_FOLLOWUP);
        assertThat(testInventoryAnalysis.getFollowupComplete()).isEqualTo(DEFAULT_FOLLOWUP_COMPLETE);
    }

    @Test
    @Transactional
    public void createInventoryAnalysisWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = inventoryAnalysisRepository.findAll().size();

        // Create the InventoryAnalysis with an existing ID
        inventoryAnalysis.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInventoryAnalysisMockMvc.perform(post("/api/inventory-analyses").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(inventoryAnalysis)))
            .andExpect(status().isBadRequest());

        // Validate the InventoryAnalysis in the database
        List<InventoryAnalysis> inventoryAnalysisList = inventoryAnalysisRepository.findAll();
        assertThat(inventoryAnalysisList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllInventoryAnalyses() throws Exception {
        // Initialize the database
        inventoryAnalysisRepository.saveAndFlush(inventoryAnalysis);

        // Get all the inventoryAnalysisList
        restInventoryAnalysisMockMvc.perform(get("/api/inventory-analyses?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(inventoryAnalysis.getId().intValue())))
            .andExpect(jsonPath("$.[*].detailOrg").value(hasItem(DEFAULT_DETAIL_ORG)))
            .andExpect(jsonPath("$.[*].accountingDate").value(hasItem(DEFAULT_ACCOUNTING_DATE.toString())))
            .andExpect(jsonPath("$.[*].trxWeek").value(hasItem(DEFAULT_TRX_WEEK)))
            .andExpect(jsonPath("$.[*].trxTyp").value(hasItem(DEFAULT_TRX_TYP)))
            .andExpect(jsonPath("$.[*].costGroup").value(hasItem(DEFAULT_COST_GROUP)))
            .andExpect(jsonPath("$.[*].moNo").value(hasItem(DEFAULT_MO_NO)))
            .andExpect(jsonPath("$.[*].partNo").value(hasItem(DEFAULT_PART_NO)))
            .andExpect(jsonPath("$.[*].toolId").value(hasItem(DEFAULT_TOOL_ID)))
            .andExpect(jsonPath("$.[*].stationFamily").value(hasItem(DEFAULT_STATION_FAMILY)))
            .andExpect(jsonPath("$.[*].trxQty").value(hasItem(DEFAULT_TRX_QTY)))
            .andExpect(jsonPath("$.[*].trxUom").value(hasItem(DEFAULT_TRX_UOM)))
            .andExpect(jsonPath("$.[*].unitCost").value(hasItem(DEFAULT_UNIT_COST)))
            .andExpect(jsonPath("$.[*].accountedAmt").value(hasItem(DEFAULT_ACCOUNTED_AMT)))
            .andExpect(jsonPath("$.[*].partDescr").value(hasItem(DEFAULT_PART_DESCR)))
            .andExpect(jsonPath("$.[*].naturalAccount").value(hasItem(DEFAULT_NATURAL_ACCOUNT)))
            .andExpect(jsonPath("$.[*].vendorName").value(hasItem(DEFAULT_VENDOR_NAME)))
            .andExpect(jsonPath("$.[*].supplierClassification").value(hasItem(DEFAULT_SUPPLIER_CLASSIFICATION)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].glLineDescr").value(hasItem(DEFAULT_GL_LINE_DESCR)))
            .andExpect(jsonPath("$.[*].summaryOrg").value(hasItem(DEFAULT_SUMMARY_ORG)))
            .andExpect(jsonPath("$.[*].costCenterId").value(hasItem(DEFAULT_COST_CENTER_ID)))
            .andExpect(jsonPath("$.[*].costCenter").value(hasItem(DEFAULT_COST_CENTER)))
            .andExpect(jsonPath("$.[*].summaryAccount").value(hasItem(DEFAULT_SUMMARY_ACCOUNT)))
            .andExpect(jsonPath("$.[*].parentAccount").value(hasItem(DEFAULT_PARENT_ACCOUNT)))
            .andExpect(jsonPath("$.[*].accountId").value(hasItem(DEFAULT_ACCOUNT_ID)))
            .andExpect(jsonPath("$.[*].trxDate").value(hasItem(DEFAULT_TRX_DATE.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].orgCode").value(hasItem(DEFAULT_ORG_CODE)))
            .andExpect(jsonPath("$.[*].lotNo").value(hasItem(DEFAULT_LOT_NO)))
            .andExpect(jsonPath("$.[*].poItemCat").value(hasItem(DEFAULT_PO_ITEM_CAT)))
            .andExpect(jsonPath("$.[*].moLineNo").value(hasItem(DEFAULT_MO_LINE_NO)))
            .andExpect(jsonPath("$.[*].poNo").value(hasItem(DEFAULT_PO_NO)))
            .andExpect(jsonPath("$.[*].poLineNo").value(hasItem(DEFAULT_PO_LINE_NO)))
            .andExpect(jsonPath("$.[*].jeBatchName").value(hasItem(DEFAULT_JE_BATCH_NAME)))
            .andExpect(jsonPath("$.[*].jeName").value(hasItem(DEFAULT_JE_NAME)))
            .andExpect(jsonPath("$.[*].jeLineNo").value(hasItem(DEFAULT_JE_LINE_NO)))
            .andExpect(jsonPath("$.[*].trxAcc").value(hasItem(DEFAULT_TRX_ACC)))
            .andExpect(jsonPath("$.[*].trxNaturalAcc").value(hasItem(DEFAULT_TRX_NATURAL_ACC)))
            .andExpect(jsonPath("$.[*].glAcc").value(hasItem(DEFAULT_GL_ACC)))
            .andExpect(jsonPath("$.[*].currency").value(hasItem(DEFAULT_CURRENCY)))
            .andExpect(jsonPath("$.[*].enteredAmt").value(hasItem(DEFAULT_ENTERED_AMT)))
            .andExpect(jsonPath("$.[*].source").value(hasItem(DEFAULT_SOURCE)))
            .andExpect(jsonPath("$.[*].period").value(hasItem(DEFAULT_PERIOD)))
            .andExpect(jsonPath("$.[*].trxId").value(hasItem(DEFAULT_TRX_ID)))
            .andExpect(jsonPath("$.[*].uniqueId").value(hasItem(DEFAULT_UNIQUE_ID)))
            .andExpect(jsonPath("$.[*].entityReview").value(hasItem(DEFAULT_ENTITY_REVIEW)))
            .andExpect(jsonPath("$.[*].partLifetime").value(hasItem(DEFAULT_PART_LIFETIME)))
            .andExpect(jsonPath("$.[*].partFixedProblem").value(hasItem(DEFAULT_PART_FIXED_PROBLEM)))
            .andExpect(jsonPath("$.[*].returnToStores").value(hasItem(DEFAULT_RETURN_TO_STORES)))
            .andExpect(jsonPath("$.[*].repeatFail").value(hasItem(DEFAULT_REPEAT_FAIL)))
            .andExpect(jsonPath("$.[*].warrantyClaim").value(hasItem(DEFAULT_WARRANTY_CLAIM)))
            .andExpect(jsonPath("$.[*].submitForWarranty").value(hasItem(DEFAULT_SUBMIT_FOR_WARRANTY)))
            .andExpect(jsonPath("$.[*].repairablePart").value(hasItem(DEFAULT_REPAIRABLE_PART)))
            .andExpect(jsonPath("$.[*].submitForRepair").value(hasItem(DEFAULT_SUBMIT_FOR_REPAIR)))
            .andExpect(jsonPath("$.[*].partSourcing").value(hasItem(DEFAULT_PART_SOURCING)))
            .andExpect(jsonPath("$.[*].commentFollowup").value(hasItem(DEFAULT_COMMENT_FOLLOWUP)))
            .andExpect(jsonPath("$.[*].followupComplete").value(hasItem(DEFAULT_FOLLOWUP_COMPLETE)));
    }
    
    @Test
    @Transactional
    public void getInventoryAnalysis() throws Exception {
        // Initialize the database
        inventoryAnalysisRepository.saveAndFlush(inventoryAnalysis);

        // Get the inventoryAnalysis
        restInventoryAnalysisMockMvc.perform(get("/api/inventory-analyses/{id}", inventoryAnalysis.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(inventoryAnalysis.getId().intValue()))
            .andExpect(jsonPath("$.detailOrg").value(DEFAULT_DETAIL_ORG))
            .andExpect(jsonPath("$.accountingDate").value(DEFAULT_ACCOUNTING_DATE.toString()))
            .andExpect(jsonPath("$.trxWeek").value(DEFAULT_TRX_WEEK))
            .andExpect(jsonPath("$.trxTyp").value(DEFAULT_TRX_TYP))
            .andExpect(jsonPath("$.costGroup").value(DEFAULT_COST_GROUP))
            .andExpect(jsonPath("$.moNo").value(DEFAULT_MO_NO))
            .andExpect(jsonPath("$.partNo").value(DEFAULT_PART_NO))
            .andExpect(jsonPath("$.toolId").value(DEFAULT_TOOL_ID))
            .andExpect(jsonPath("$.stationFamily").value(DEFAULT_STATION_FAMILY))
            .andExpect(jsonPath("$.trxQty").value(DEFAULT_TRX_QTY))
            .andExpect(jsonPath("$.trxUom").value(DEFAULT_TRX_UOM))
            .andExpect(jsonPath("$.unitCost").value(DEFAULT_UNIT_COST))
            .andExpect(jsonPath("$.accountedAmt").value(DEFAULT_ACCOUNTED_AMT))
            .andExpect(jsonPath("$.partDescr").value(DEFAULT_PART_DESCR))
            .andExpect(jsonPath("$.naturalAccount").value(DEFAULT_NATURAL_ACCOUNT))
            .andExpect(jsonPath("$.vendorName").value(DEFAULT_VENDOR_NAME))
            .andExpect(jsonPath("$.supplierClassification").value(DEFAULT_SUPPLIER_CLASSIFICATION))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.glLineDescr").value(DEFAULT_GL_LINE_DESCR))
            .andExpect(jsonPath("$.summaryOrg").value(DEFAULT_SUMMARY_ORG))
            .andExpect(jsonPath("$.costCenterId").value(DEFAULT_COST_CENTER_ID))
            .andExpect(jsonPath("$.costCenter").value(DEFAULT_COST_CENTER))
            .andExpect(jsonPath("$.summaryAccount").value(DEFAULT_SUMMARY_ACCOUNT))
            .andExpect(jsonPath("$.parentAccount").value(DEFAULT_PARENT_ACCOUNT))
            .andExpect(jsonPath("$.accountId").value(DEFAULT_ACCOUNT_ID))
            .andExpect(jsonPath("$.trxDate").value(DEFAULT_TRX_DATE.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.orgCode").value(DEFAULT_ORG_CODE))
            .andExpect(jsonPath("$.lotNo").value(DEFAULT_LOT_NO))
            .andExpect(jsonPath("$.poItemCat").value(DEFAULT_PO_ITEM_CAT))
            .andExpect(jsonPath("$.moLineNo").value(DEFAULT_MO_LINE_NO))
            .andExpect(jsonPath("$.poNo").value(DEFAULT_PO_NO))
            .andExpect(jsonPath("$.poLineNo").value(DEFAULT_PO_LINE_NO))
            .andExpect(jsonPath("$.jeBatchName").value(DEFAULT_JE_BATCH_NAME))
            .andExpect(jsonPath("$.jeName").value(DEFAULT_JE_NAME))
            .andExpect(jsonPath("$.jeLineNo").value(DEFAULT_JE_LINE_NO))
            .andExpect(jsonPath("$.trxAcc").value(DEFAULT_TRX_ACC))
            .andExpect(jsonPath("$.trxNaturalAcc").value(DEFAULT_TRX_NATURAL_ACC))
            .andExpect(jsonPath("$.glAcc").value(DEFAULT_GL_ACC))
            .andExpect(jsonPath("$.currency").value(DEFAULT_CURRENCY))
            .andExpect(jsonPath("$.enteredAmt").value(DEFAULT_ENTERED_AMT))
            .andExpect(jsonPath("$.source").value(DEFAULT_SOURCE))
            .andExpect(jsonPath("$.period").value(DEFAULT_PERIOD))
            .andExpect(jsonPath("$.trxId").value(DEFAULT_TRX_ID))
            .andExpect(jsonPath("$.uniqueId").value(DEFAULT_UNIQUE_ID))
            .andExpect(jsonPath("$.entityReview").value(DEFAULT_ENTITY_REVIEW))
            .andExpect(jsonPath("$.partLifetime").value(DEFAULT_PART_LIFETIME))
            .andExpect(jsonPath("$.partFixedProblem").value(DEFAULT_PART_FIXED_PROBLEM))
            .andExpect(jsonPath("$.returnToStores").value(DEFAULT_RETURN_TO_STORES))
            .andExpect(jsonPath("$.repeatFail").value(DEFAULT_REPEAT_FAIL))
            .andExpect(jsonPath("$.warrantyClaim").value(DEFAULT_WARRANTY_CLAIM))
            .andExpect(jsonPath("$.submitForWarranty").value(DEFAULT_SUBMIT_FOR_WARRANTY))
            .andExpect(jsonPath("$.repairablePart").value(DEFAULT_REPAIRABLE_PART))
            .andExpect(jsonPath("$.submitForRepair").value(DEFAULT_SUBMIT_FOR_REPAIR))
            .andExpect(jsonPath("$.partSourcing").value(DEFAULT_PART_SOURCING))
            .andExpect(jsonPath("$.commentFollowup").value(DEFAULT_COMMENT_FOLLOWUP))
            .andExpect(jsonPath("$.followupComplete").value(DEFAULT_FOLLOWUP_COMPLETE));
    }
    @Test
    @Transactional
    public void getNonExistingInventoryAnalysis() throws Exception {
        // Get the inventoryAnalysis
        restInventoryAnalysisMockMvc.perform(get("/api/inventory-analyses/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInventoryAnalysis() throws Exception {
        // Initialize the database
        inventoryAnalysisRepository.saveAndFlush(inventoryAnalysis);

        int databaseSizeBeforeUpdate = inventoryAnalysisRepository.findAll().size();

        // Update the inventoryAnalysis
        InventoryAnalysis updatedInventoryAnalysis = inventoryAnalysisRepository.findById(inventoryAnalysis.getId()).get();
        // Disconnect from session so that the updates on updatedInventoryAnalysis are not directly saved in db
        em.detach(updatedInventoryAnalysis);
        updatedInventoryAnalysis
            .detailOrg(UPDATED_DETAIL_ORG)
            .accountingDate(UPDATED_ACCOUNTING_DATE)
            .trxWeek(UPDATED_TRX_WEEK)
            .trxTyp(UPDATED_TRX_TYP)
            .costGroup(UPDATED_COST_GROUP)
            .moNo(UPDATED_MO_NO)
            .partNo(UPDATED_PART_NO)
            .toolId(UPDATED_TOOL_ID)
            .stationFamily(UPDATED_STATION_FAMILY)
            .trxQty(UPDATED_TRX_QTY)
            .trxUom(UPDATED_TRX_UOM)
            .unitCost(UPDATED_UNIT_COST)
            .accountedAmt(UPDATED_ACCOUNTED_AMT)
            .partDescr(UPDATED_PART_DESCR)
            .naturalAccount(UPDATED_NATURAL_ACCOUNT)
            .vendorName(UPDATED_VENDOR_NAME)
            .supplierClassification(UPDATED_SUPPLIER_CLASSIFICATION)
            .description(UPDATED_DESCRIPTION)
            .glLineDescr(UPDATED_GL_LINE_DESCR)
            .summaryOrg(UPDATED_SUMMARY_ORG)
            .costCenterId(UPDATED_COST_CENTER_ID)
            .costCenter(UPDATED_COST_CENTER)
            .summaryAccount(UPDATED_SUMMARY_ACCOUNT)
            .parentAccount(UPDATED_PARENT_ACCOUNT)
            .accountId(UPDATED_ACCOUNT_ID)
            .trxDate(UPDATED_TRX_DATE)
            .createdBy(UPDATED_CREATED_BY)
            .orgCode(UPDATED_ORG_CODE)
            .lotNo(UPDATED_LOT_NO)
            .poItemCat(UPDATED_PO_ITEM_CAT)
            .moLineNo(UPDATED_MO_LINE_NO)
            .poNo(UPDATED_PO_NO)
            .poLineNo(UPDATED_PO_LINE_NO)
            .jeBatchName(UPDATED_JE_BATCH_NAME)
            .jeName(UPDATED_JE_NAME)
            .jeLineNo(UPDATED_JE_LINE_NO)
            .trxAcc(UPDATED_TRX_ACC)
            .trxNaturalAcc(UPDATED_TRX_NATURAL_ACC)
            .glAcc(UPDATED_GL_ACC)
            .currency(UPDATED_CURRENCY)
            .enteredAmt(UPDATED_ENTERED_AMT)
            .source(UPDATED_SOURCE)
            .period(UPDATED_PERIOD)
            .trxId(UPDATED_TRX_ID)
            .uniqueId(UPDATED_UNIQUE_ID)
            .entityReview(UPDATED_ENTITY_REVIEW)
            .partLifetime(UPDATED_PART_LIFETIME)
            .partFixedProblem(UPDATED_PART_FIXED_PROBLEM)
            .returnToStores(UPDATED_RETURN_TO_STORES)
            .repeatFail(UPDATED_REPEAT_FAIL)
            .warrantyClaim(UPDATED_WARRANTY_CLAIM)
            .submitForWarranty(UPDATED_SUBMIT_FOR_WARRANTY)
            .repairablePart(UPDATED_REPAIRABLE_PART)
            .submitForRepair(UPDATED_SUBMIT_FOR_REPAIR)
            .partSourcing(UPDATED_PART_SOURCING)
            .commentFollowup(UPDATED_COMMENT_FOLLOWUP)
            .followupComplete(UPDATED_FOLLOWUP_COMPLETE);

        restInventoryAnalysisMockMvc.perform(put("/api/inventory-analyses").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedInventoryAnalysis)))
            .andExpect(status().isOk());

        // Validate the InventoryAnalysis in the database
        List<InventoryAnalysis> inventoryAnalysisList = inventoryAnalysisRepository.findAll();
        assertThat(inventoryAnalysisList).hasSize(databaseSizeBeforeUpdate);
        InventoryAnalysis testInventoryAnalysis = inventoryAnalysisList.get(inventoryAnalysisList.size() - 1);
        assertThat(testInventoryAnalysis.getDetailOrg()).isEqualTo(UPDATED_DETAIL_ORG);
        assertThat(testInventoryAnalysis.getAccountingDate()).isEqualTo(UPDATED_ACCOUNTING_DATE);
        assertThat(testInventoryAnalysis.getTrxWeek()).isEqualTo(UPDATED_TRX_WEEK);
        assertThat(testInventoryAnalysis.getTrxTyp()).isEqualTo(UPDATED_TRX_TYP);
        assertThat(testInventoryAnalysis.getCostGroup()).isEqualTo(UPDATED_COST_GROUP);
        assertThat(testInventoryAnalysis.getMoNo()).isEqualTo(UPDATED_MO_NO);
        assertThat(testInventoryAnalysis.getPartNo()).isEqualTo(UPDATED_PART_NO);
        assertThat(testInventoryAnalysis.getToolId()).isEqualTo(UPDATED_TOOL_ID);
        assertThat(testInventoryAnalysis.getStationFamily()).isEqualTo(UPDATED_STATION_FAMILY);
        assertThat(testInventoryAnalysis.getTrxQty()).isEqualTo(UPDATED_TRX_QTY);
        assertThat(testInventoryAnalysis.getTrxUom()).isEqualTo(UPDATED_TRX_UOM);
        assertThat(testInventoryAnalysis.getUnitCost()).isEqualTo(UPDATED_UNIT_COST);
        assertThat(testInventoryAnalysis.getAccountedAmt()).isEqualTo(UPDATED_ACCOUNTED_AMT);
        assertThat(testInventoryAnalysis.getPartDescr()).isEqualTo(UPDATED_PART_DESCR);
        assertThat(testInventoryAnalysis.getNaturalAccount()).isEqualTo(UPDATED_NATURAL_ACCOUNT);
        assertThat(testInventoryAnalysis.getVendorName()).isEqualTo(UPDATED_VENDOR_NAME);
        assertThat(testInventoryAnalysis.getSupplierClassification()).isEqualTo(UPDATED_SUPPLIER_CLASSIFICATION);
        assertThat(testInventoryAnalysis.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testInventoryAnalysis.getGlLineDescr()).isEqualTo(UPDATED_GL_LINE_DESCR);
        assertThat(testInventoryAnalysis.getSummaryOrg()).isEqualTo(UPDATED_SUMMARY_ORG);
        assertThat(testInventoryAnalysis.getCostCenterId()).isEqualTo(UPDATED_COST_CENTER_ID);
        assertThat(testInventoryAnalysis.getCostCenter()).isEqualTo(UPDATED_COST_CENTER);
        assertThat(testInventoryAnalysis.getSummaryAccount()).isEqualTo(UPDATED_SUMMARY_ACCOUNT);
        assertThat(testInventoryAnalysis.getParentAccount()).isEqualTo(UPDATED_PARENT_ACCOUNT);
        assertThat(testInventoryAnalysis.getAccountId()).isEqualTo(UPDATED_ACCOUNT_ID);
        assertThat(testInventoryAnalysis.getTrxDate()).isEqualTo(UPDATED_TRX_DATE);
        assertThat(testInventoryAnalysis.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testInventoryAnalysis.getOrgCode()).isEqualTo(UPDATED_ORG_CODE);
        assertThat(testInventoryAnalysis.getLotNo()).isEqualTo(UPDATED_LOT_NO);
        assertThat(testInventoryAnalysis.getPoItemCat()).isEqualTo(UPDATED_PO_ITEM_CAT);
        assertThat(testInventoryAnalysis.getMoLineNo()).isEqualTo(UPDATED_MO_LINE_NO);
        assertThat(testInventoryAnalysis.getPoNo()).isEqualTo(UPDATED_PO_NO);
        assertThat(testInventoryAnalysis.getPoLineNo()).isEqualTo(UPDATED_PO_LINE_NO);
        assertThat(testInventoryAnalysis.getJeBatchName()).isEqualTo(UPDATED_JE_BATCH_NAME);
        assertThat(testInventoryAnalysis.getJeName()).isEqualTo(UPDATED_JE_NAME);
        assertThat(testInventoryAnalysis.getJeLineNo()).isEqualTo(UPDATED_JE_LINE_NO);
        assertThat(testInventoryAnalysis.getTrxAcc()).isEqualTo(UPDATED_TRX_ACC);
        assertThat(testInventoryAnalysis.getTrxNaturalAcc()).isEqualTo(UPDATED_TRX_NATURAL_ACC);
        assertThat(testInventoryAnalysis.getGlAcc()).isEqualTo(UPDATED_GL_ACC);
        assertThat(testInventoryAnalysis.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testInventoryAnalysis.getEnteredAmt()).isEqualTo(UPDATED_ENTERED_AMT);
        assertThat(testInventoryAnalysis.getSource()).isEqualTo(UPDATED_SOURCE);
        assertThat(testInventoryAnalysis.getPeriod()).isEqualTo(UPDATED_PERIOD);
        assertThat(testInventoryAnalysis.getTrxId()).isEqualTo(UPDATED_TRX_ID);
        assertThat(testInventoryAnalysis.getUniqueId()).isEqualTo(UPDATED_UNIQUE_ID);
        assertThat(testInventoryAnalysis.getEntityReview()).isEqualTo(UPDATED_ENTITY_REVIEW);
        assertThat(testInventoryAnalysis.getPartLifetime()).isEqualTo(UPDATED_PART_LIFETIME);
        assertThat(testInventoryAnalysis.getPartFixedProblem()).isEqualTo(UPDATED_PART_FIXED_PROBLEM);
        assertThat(testInventoryAnalysis.getReturnToStores()).isEqualTo(UPDATED_RETURN_TO_STORES);
        assertThat(testInventoryAnalysis.getRepeatFail()).isEqualTo(UPDATED_REPEAT_FAIL);
        assertThat(testInventoryAnalysis.getWarrantyClaim()).isEqualTo(UPDATED_WARRANTY_CLAIM);
        assertThat(testInventoryAnalysis.getSubmitForWarranty()).isEqualTo(UPDATED_SUBMIT_FOR_WARRANTY);
        assertThat(testInventoryAnalysis.getRepairablePart()).isEqualTo(UPDATED_REPAIRABLE_PART);
        assertThat(testInventoryAnalysis.getSubmitForRepair()).isEqualTo(UPDATED_SUBMIT_FOR_REPAIR);
        assertThat(testInventoryAnalysis.getPartSourcing()).isEqualTo(UPDATED_PART_SOURCING);
        assertThat(testInventoryAnalysis.getCommentFollowup()).isEqualTo(UPDATED_COMMENT_FOLLOWUP);
        assertThat(testInventoryAnalysis.getFollowupComplete()).isEqualTo(UPDATED_FOLLOWUP_COMPLETE);
    }

    @Test
    @Transactional
    public void updateNonExistingInventoryAnalysis() throws Exception {
        int databaseSizeBeforeUpdate = inventoryAnalysisRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInventoryAnalysisMockMvc.perform(put("/api/inventory-analyses").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(inventoryAnalysis)))
            .andExpect(status().isBadRequest());

        // Validate the InventoryAnalysis in the database
        List<InventoryAnalysis> inventoryAnalysisList = inventoryAnalysisRepository.findAll();
        assertThat(inventoryAnalysisList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInventoryAnalysis() throws Exception {
        // Initialize the database
        inventoryAnalysisRepository.saveAndFlush(inventoryAnalysis);

        int databaseSizeBeforeDelete = inventoryAnalysisRepository.findAll().size();

        // Delete the inventoryAnalysis
        restInventoryAnalysisMockMvc.perform(delete("/api/inventory-analyses/{id}", inventoryAnalysis.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<InventoryAnalysis> inventoryAnalysisList = inventoryAnalysisRepository.findAll();
        assertThat(inventoryAnalysisList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
