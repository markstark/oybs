package com.globalfoundries.oybs.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Inventor.
 */
@Entity
@Table(name = "inventor")
public class Inventor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "trx_day")
    private String trxDay;

    @Column(name = "trx_month")
    private String trxMonth;

    @Column(name = "trx_week")
    private String trxWeek;

    @Column(name = "tool_id")
    private String toolId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public Inventor vendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getTrxDay() {
        return trxDay;
    }

    public Inventor trxDay(String trxDay) {
        this.trxDay = trxDay;
        return this;
    }

    public void setTrxDay(String trxDay) {
        this.trxDay = trxDay;
    }

    public String getTrxMonth() {
        return trxMonth;
    }

    public Inventor trxMonth(String trxMonth) {
        this.trxMonth = trxMonth;
        return this;
    }

    public void setTrxMonth(String trxMonth) {
        this.trxMonth = trxMonth;
    }

    public String getTrxWeek() {
        return trxWeek;
    }

    public Inventor trxWeek(String trxWeek) {
        this.trxWeek = trxWeek;
        return this;
    }

    public void setTrxWeek(String trxWeek) {
        this.trxWeek = trxWeek;
    }

    public String getToolId() {
        return toolId;
    }

    public Inventor toolId(String toolId) {
        this.toolId = toolId;
        return this;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inventor)) {
            return false;
        }
        return id != null && id.equals(((Inventor) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Inventor{" +
            "id=" + getId() +
            ", vendorName='" + getVendorName() + "'" +
            ", trxDay='" + getTrxDay() + "'" +
            ", trxMonth='" + getTrxMonth() + "'" +
            ", trxWeek='" + getTrxWeek() + "'" +
            ", toolId='" + getToolId() + "'" +
            "}";
    }
}
