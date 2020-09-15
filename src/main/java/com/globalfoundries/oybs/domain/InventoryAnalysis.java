package com.globalfoundries.oybs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A InventoryAnalysis.
 */
@Entity
@Table(name = "inventory_analysis")
public class InventoryAnalysis implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "detail_org")
    private String detailOrg;

    @Column(name = "accounting_date")
    private LocalDate accountingDate;

    @Column(name = "trx_week")
    private String trxWeek;

    @Column(name = "trx_typ")
    private String trxTyp;

    @Column(name = "cost_group")
    private String costGroup;

    @Column(name = "mo_no")
    private String moNo;

    @Column(name = "part_no")
    private String partNo;

    @Column(name = "tool_id")
    private String toolId;

    @Column(name = "station_family")
    private String stationFamily;

    @Column(name = "trx_qty")
    private Integer trxQty;

    @Column(name = "trx_uom")
    private String trxUom;

    @Column(name = "unit_cost")
    private String unitCost;

    @Column(name = "accounted_amt")
    private String accountedAmt;

    @Column(name = "part_descr")
    private String partDescr;

    @Column(name = "natural_account")
    private String naturalAccount;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "supplier_classification")
    private String supplierClassification;

    @Column(name = "description")
    private String description;

    @Column(name = "gl_line_descr")
    private String glLineDescr;

    @Column(name = "summary_org")
    private String summaryOrg;

    @Column(name = "cost_center_id")
    private String costCenterId;

    @Column(name = "cost_center")
    private String costCenter;

    @Column(name = "summary_account")
    private String summaryAccount;

    @Column(name = "parent_account")
    private String parentAccount;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "trx_date")
    private LocalDate trxDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "org_code")
    private String orgCode;

    @Column(name = "lot_no")
    private String lotNo;

    @Column(name = "po_item_cat")
    private String poItemCat;

    @Column(name = "mo_line_no")
    private Integer moLineNo;

    @Column(name = "po_no")
    private String poNo;

    @Column(name = "po_line_no")
    private String poLineNo;

    @Column(name = "je_batch_name")
    private String jeBatchName;

    @Column(name = "je_name")
    private String jeName;

    @Column(name = "je_line_no")
    private Integer jeLineNo;

    @Column(name = "trx_acc")
    private String trxAcc;

    @Column(name = "trx_natural_acc")
    private String trxNaturalAcc;

    @Column(name = "gl_acc")
    private String glAcc;

    @Column(name = "currency")
    private String currency;

    @Column(name = "entered_amt")
    private String enteredAmt;

    @Column(name = "source")
    private String source;

    @Column(name = "period")
    private String period;

    @Column(name = "trx_id")
    private String trxId;

    @Column(name = "unique_id")
    private String uniqueId;

    @Column(name = "entity_review")
    private String entityReview;

    @Column(name = "part_lifetime")
    private String partLifetime;

    @Column(name = "part_fixed_problem")
    private String partFixedProblem;

    @Column(name = "return_to_stores")
    private String returnToStores;

    @Column(name = "repeat_fail")
    private String repeatFail;

    @Column(name = "warranty_claim")
    private String warrantyClaim;

    @Column(name = "submit_for_warranty")
    private String submitForWarranty;

    @Column(name = "repairable_part")
    private String repairablePart;

    @Column(name = "submit_for_repair")
    private String submitForRepair;

    @Column(name = "part_sourcing")
    private String partSourcing;

    @Column(name = "comment_followup")
    private String commentFollowup;

    @Column(name = "followup_complete")
    private String followupComplete;

    @ManyToOne
    @JsonIgnoreProperties(value = "inventoryAnalyses", allowSetters = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetailOrg() {
        return detailOrg;
    }

    public InventoryAnalysis detailOrg(String detailOrg) {
        this.detailOrg = detailOrg;
        return this;
    }

    public void setDetailOrg(String detailOrg) {
        this.detailOrg = detailOrg;
    }

    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    public InventoryAnalysis accountingDate(LocalDate accountingDate) {
        this.accountingDate = accountingDate;
        return this;
    }

    public void setAccountingDate(LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getTrxWeek() {
        return trxWeek;
    }

    public InventoryAnalysis trxWeek(String trxWeek) {
        this.trxWeek = trxWeek;
        return this;
    }

    public void setTrxWeek(String trxWeek) {
        this.trxWeek = trxWeek;
    }

    public String getTrxTyp() {
        return trxTyp;
    }

    public InventoryAnalysis trxTyp(String trxTyp) {
        this.trxTyp = trxTyp;
        return this;
    }

    public void setTrxTyp(String trxTyp) {
        this.trxTyp = trxTyp;
    }

    public String getCostGroup() {
        return costGroup;
    }

    public InventoryAnalysis costGroup(String costGroup) {
        this.costGroup = costGroup;
        return this;
    }

    public void setCostGroup(String costGroup) {
        this.costGroup = costGroup;
    }

    public String getMoNo() {
        return moNo;
    }

    public InventoryAnalysis moNo(String moNo) {
        this.moNo = moNo;
        return this;
    }

    public void setMoNo(String moNo) {
        this.moNo = moNo;
    }

    public String getPartNo() {
        return partNo;
    }

    public InventoryAnalysis partNo(String partNo) {
        this.partNo = partNo;
        return this;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getToolId() {
        return toolId;
    }

    public InventoryAnalysis toolId(String toolId) {
        this.toolId = toolId;
        return this;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getStationFamily() {
        return stationFamily;
    }

    public InventoryAnalysis stationFamily(String stationFamily) {
        this.stationFamily = stationFamily;
        return this;
    }

    public void setStationFamily(String stationFamily) {
        this.stationFamily = stationFamily;
    }

    public Integer getTrxQty() {
        return trxQty;
    }

    public InventoryAnalysis trxQty(Integer trxQty) {
        this.trxQty = trxQty;
        return this;
    }

    public void setTrxQty(Integer trxQty) {
        this.trxQty = trxQty;
    }

    public String getTrxUom() {
        return trxUom;
    }

    public InventoryAnalysis trxUom(String trxUom) {
        this.trxUom = trxUom;
        return this;
    }

    public void setTrxUom(String trxUom) {
        this.trxUom = trxUom;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public InventoryAnalysis unitCost(String unitCost) {
        this.unitCost = unitCost;
        return this;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getAccountedAmt() {
        return accountedAmt;
    }

    public InventoryAnalysis accountedAmt(String accountedAmt) {
        this.accountedAmt = accountedAmt;
        return this;
    }

    public void setAccountedAmt(String accountedAmt) {
        this.accountedAmt = accountedAmt;
    }

    public String getPartDescr() {
        return partDescr;
    }

    public InventoryAnalysis partDescr(String partDescr) {
        this.partDescr = partDescr;
        return this;
    }

    public void setPartDescr(String partDescr) {
        this.partDescr = partDescr;
    }

    public String getNaturalAccount() {
        return naturalAccount;
    }

    public InventoryAnalysis naturalAccount(String naturalAccount) {
        this.naturalAccount = naturalAccount;
        return this;
    }

    public void setNaturalAccount(String naturalAccount) {
        this.naturalAccount = naturalAccount;
    }

    public String getVendorName() {
        return vendorName;
    }

    public InventoryAnalysis vendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getSupplierClassification() {
        return supplierClassification;
    }

    public InventoryAnalysis supplierClassification(String supplierClassification) {
        this.supplierClassification = supplierClassification;
        return this;
    }

    public void setSupplierClassification(String supplierClassification) {
        this.supplierClassification = supplierClassification;
    }

    public String getDescription() {
        return description;
    }

    public InventoryAnalysis description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGlLineDescr() {
        return glLineDescr;
    }

    public InventoryAnalysis glLineDescr(String glLineDescr) {
        this.glLineDescr = glLineDescr;
        return this;
    }

    public void setGlLineDescr(String glLineDescr) {
        this.glLineDescr = glLineDescr;
    }

    public String getSummaryOrg() {
        return summaryOrg;
    }

    public InventoryAnalysis summaryOrg(String summaryOrg) {
        this.summaryOrg = summaryOrg;
        return this;
    }

    public void setSummaryOrg(String summaryOrg) {
        this.summaryOrg = summaryOrg;
    }

    public String getCostCenterId() {
        return costCenterId;
    }

    public InventoryAnalysis costCenterId(String costCenterId) {
        this.costCenterId = costCenterId;
        return this;
    }

    public void setCostCenterId(String costCenterId) {
        this.costCenterId = costCenterId;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public InventoryAnalysis costCenter(String costCenter) {
        this.costCenter = costCenter;
        return this;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getSummaryAccount() {
        return summaryAccount;
    }

    public InventoryAnalysis summaryAccount(String summaryAccount) {
        this.summaryAccount = summaryAccount;
        return this;
    }

    public void setSummaryAccount(String summaryAccount) {
        this.summaryAccount = summaryAccount;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public InventoryAnalysis parentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
        return this;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getAccountId() {
        return accountId;
    }

    public InventoryAnalysis accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDate getTrxDate() {
        return trxDate;
    }

    public InventoryAnalysis trxDate(LocalDate trxDate) {
        this.trxDate = trxDate;
        return this;
    }

    public void setTrxDate(LocalDate trxDate) {
        this.trxDate = trxDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public InventoryAnalysis createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public InventoryAnalysis orgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getLotNo() {
        return lotNo;
    }

    public InventoryAnalysis lotNo(String lotNo) {
        this.lotNo = lotNo;
        return this;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getPoItemCat() {
        return poItemCat;
    }

    public InventoryAnalysis poItemCat(String poItemCat) {
        this.poItemCat = poItemCat;
        return this;
    }

    public void setPoItemCat(String poItemCat) {
        this.poItemCat = poItemCat;
    }

    public Integer getMoLineNo() {
        return moLineNo;
    }

    public InventoryAnalysis moLineNo(Integer moLineNo) {
        this.moLineNo = moLineNo;
        return this;
    }

    public void setMoLineNo(Integer moLineNo) {
        this.moLineNo = moLineNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public InventoryAnalysis poNo(String poNo) {
        this.poNo = poNo;
        return this;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getPoLineNo() {
        return poLineNo;
    }

    public InventoryAnalysis poLineNo(String poLineNo) {
        this.poLineNo = poLineNo;
        return this;
    }

    public void setPoLineNo(String poLineNo) {
        this.poLineNo = poLineNo;
    }

    public String getJeBatchName() {
        return jeBatchName;
    }

    public InventoryAnalysis jeBatchName(String jeBatchName) {
        this.jeBatchName = jeBatchName;
        return this;
    }

    public void setJeBatchName(String jeBatchName) {
        this.jeBatchName = jeBatchName;
    }

    public String getJeName() {
        return jeName;
    }

    public InventoryAnalysis jeName(String jeName) {
        this.jeName = jeName;
        return this;
    }

    public void setJeName(String jeName) {
        this.jeName = jeName;
    }

    public Integer getJeLineNo() {
        return jeLineNo;
    }

    public InventoryAnalysis jeLineNo(Integer jeLineNo) {
        this.jeLineNo = jeLineNo;
        return this;
    }

    public void setJeLineNo(Integer jeLineNo) {
        this.jeLineNo = jeLineNo;
    }

    public String getTrxAcc() {
        return trxAcc;
    }

    public InventoryAnalysis trxAcc(String trxAcc) {
        this.trxAcc = trxAcc;
        return this;
    }

    public void setTrxAcc(String trxAcc) {
        this.trxAcc = trxAcc;
    }

    public String getTrxNaturalAcc() {
        return trxNaturalAcc;
    }

    public InventoryAnalysis trxNaturalAcc(String trxNaturalAcc) {
        this.trxNaturalAcc = trxNaturalAcc;
        return this;
    }

    public void setTrxNaturalAcc(String trxNaturalAcc) {
        this.trxNaturalAcc = trxNaturalAcc;
    }

    public String getGlAcc() {
        return glAcc;
    }

    public InventoryAnalysis glAcc(String glAcc) {
        this.glAcc = glAcc;
        return this;
    }

    public void setGlAcc(String glAcc) {
        this.glAcc = glAcc;
    }

    public String getCurrency() {
        return currency;
    }

    public InventoryAnalysis currency(String currency) {
        this.currency = currency;
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnteredAmt() {
        return enteredAmt;
    }

    public InventoryAnalysis enteredAmt(String enteredAmt) {
        this.enteredAmt = enteredAmt;
        return this;
    }

    public void setEnteredAmt(String enteredAmt) {
        this.enteredAmt = enteredAmt;
    }

    public String getSource() {
        return source;
    }

    public InventoryAnalysis source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPeriod() {
        return period;
    }

    public InventoryAnalysis period(String period) {
        this.period = period;
        return this;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTrxId() {
        return trxId;
    }

    public InventoryAnalysis trxId(String trxId) {
        this.trxId = trxId;
        return this;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public InventoryAnalysis uniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        return this;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getEntityReview() {
        return entityReview;
    }

    public InventoryAnalysis entityReview(String entityReview) {
        this.entityReview = entityReview;
        return this;
    }

    public void setEntityReview(String entityReview) {
        this.entityReview = entityReview;
    }

    public String getPartLifetime() {
        return partLifetime;
    }

    public InventoryAnalysis partLifetime(String partLifetime) {
        this.partLifetime = partLifetime;
        return this;
    }

    public void setPartLifetime(String partLifetime) {
        this.partLifetime = partLifetime;
    }

    public String getPartFixedProblem() {
        return partFixedProblem;
    }

    public InventoryAnalysis partFixedProblem(String partFixedProblem) {
        this.partFixedProblem = partFixedProblem;
        return this;
    }

    public void setPartFixedProblem(String partFixedProblem) {
        this.partFixedProblem = partFixedProblem;
    }

    public String getReturnToStores() {
        return returnToStores;
    }

    public InventoryAnalysis returnToStores(String returnToStores) {
        this.returnToStores = returnToStores;
        return this;
    }

    public void setReturnToStores(String returnToStores) {
        this.returnToStores = returnToStores;
    }

    public String getRepeatFail() {
        return repeatFail;
    }

    public InventoryAnalysis repeatFail(String repeatFail) {
        this.repeatFail = repeatFail;
        return this;
    }

    public void setRepeatFail(String repeatFail) {
        this.repeatFail = repeatFail;
    }

    public String getWarrantyClaim() {
        return warrantyClaim;
    }

    public InventoryAnalysis warrantyClaim(String warrantyClaim) {
        this.warrantyClaim = warrantyClaim;
        return this;
    }

    public void setWarrantyClaim(String warrantyClaim) {
        this.warrantyClaim = warrantyClaim;
    }

    public String getSubmitForWarranty() {
        return submitForWarranty;
    }

    public InventoryAnalysis submitForWarranty(String submitForWarranty) {
        this.submitForWarranty = submitForWarranty;
        return this;
    }

    public void setSubmitForWarranty(String submitForWarranty) {
        this.submitForWarranty = submitForWarranty;
    }

    public String getRepairablePart() {
        return repairablePart;
    }

    public InventoryAnalysis repairablePart(String repairablePart) {
        this.repairablePart = repairablePart;
        return this;
    }

    public void setRepairablePart(String repairablePart) {
        this.repairablePart = repairablePart;
    }

    public String getSubmitForRepair() {
        return submitForRepair;
    }

    public InventoryAnalysis submitForRepair(String submitForRepair) {
        this.submitForRepair = submitForRepair;
        return this;
    }

    public void setSubmitForRepair(String submitForRepair) {
        this.submitForRepair = submitForRepair;
    }

    public String getPartSourcing() {
        return partSourcing;
    }

    public InventoryAnalysis partSourcing(String partSourcing) {
        this.partSourcing = partSourcing;
        return this;
    }

    public void setPartSourcing(String partSourcing) {
        this.partSourcing = partSourcing;
    }

    public String getCommentFollowup() {
        return commentFollowup;
    }

    public InventoryAnalysis commentFollowup(String commentFollowup) {
        this.commentFollowup = commentFollowup;
        return this;
    }

    public void setCommentFollowup(String commentFollowup) {
        this.commentFollowup = commentFollowup;
    }

    public String getFollowupComplete() {
        return followupComplete;
    }

    public InventoryAnalysis followupComplete(String followupComplete) {
        this.followupComplete = followupComplete;
        return this;
    }

    public void setFollowupComplete(String followupComplete) {
        this.followupComplete = followupComplete;
    }

    public User getUser() {
        return user;
    }

    public InventoryAnalysis user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InventoryAnalysis)) {
            return false;
        }
        return id != null && id.equals(((InventoryAnalysis) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InventoryAnalysis{" +
            "id=" + getId() +
            ", detailOrg='" + getDetailOrg() + "'" +
            ", accountingDate='" + getAccountingDate() + "'" +
            ", trxWeek='" + getTrxWeek() + "'" +
            ", trxTyp='" + getTrxTyp() + "'" +
            ", costGroup='" + getCostGroup() + "'" +
            ", moNo='" + getMoNo() + "'" +
            ", partNo='" + getPartNo() + "'" +
            ", toolId='" + getToolId() + "'" +
            ", stationFamily='" + getStationFamily() + "'" +
            ", trxQty=" + getTrxQty() +
            ", trxUom='" + getTrxUom() + "'" +
            ", unitCost='" + getUnitCost() + "'" +
            ", accountedAmt='" + getAccountedAmt() + "'" +
            ", partDescr='" + getPartDescr() + "'" +
            ", naturalAccount='" + getNaturalAccount() + "'" +
            ", vendorName='" + getVendorName() + "'" +
            ", supplierClassification='" + getSupplierClassification() + "'" +
            ", description='" + getDescription() + "'" +
            ", glLineDescr='" + getGlLineDescr() + "'" +
            ", summaryOrg='" + getSummaryOrg() + "'" +
            ", costCenterId='" + getCostCenterId() + "'" +
            ", costCenter='" + getCostCenter() + "'" +
            ", summaryAccount='" + getSummaryAccount() + "'" +
            ", parentAccount='" + getParentAccount() + "'" +
            ", accountId='" + getAccountId() + "'" +
            ", trxDate='" + getTrxDate() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", orgCode='" + getOrgCode() + "'" +
            ", lotNo='" + getLotNo() + "'" +
            ", poItemCat='" + getPoItemCat() + "'" +
            ", moLineNo=" + getMoLineNo() +
            ", poNo='" + getPoNo() + "'" +
            ", poLineNo='" + getPoLineNo() + "'" +
            ", jeBatchName='" + getJeBatchName() + "'" +
            ", jeName='" + getJeName() + "'" +
            ", jeLineNo=" + getJeLineNo() +
            ", trxAcc='" + getTrxAcc() + "'" +
            ", trxNaturalAcc='" + getTrxNaturalAcc() + "'" +
            ", glAcc='" + getGlAcc() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", enteredAmt='" + getEnteredAmt() + "'" +
            ", source='" + getSource() + "'" +
            ", period='" + getPeriod() + "'" +
            ", trxId='" + getTrxId() + "'" +
            ", uniqueId='" + getUniqueId() + "'" +
            ", entityReview='" + getEntityReview() + "'" +
            ", partLifetime='" + getPartLifetime() + "'" +
            ", partFixedProblem='" + getPartFixedProblem() + "'" +
            ", returnToStores='" + getReturnToStores() + "'" +
            ", repeatFail='" + getRepeatFail() + "'" +
            ", warrantyClaim='" + getWarrantyClaim() + "'" +
            ", submitForWarranty='" + getSubmitForWarranty() + "'" +
            ", repairablePart='" + getRepairablePart() + "'" +
            ", submitForRepair='" + getSubmitForRepair() + "'" +
            ", partSourcing='" + getPartSourcing() + "'" +
            ", commentFollowup='" + getCommentFollowup() + "'" +
            ", followupComplete='" + getFollowupComplete() + "'" +
            "}";
    }
}
