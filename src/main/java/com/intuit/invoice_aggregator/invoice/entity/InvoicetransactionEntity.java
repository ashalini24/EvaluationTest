package com.intuit.invoice_aggregator.invoice.entity;

import javax.persistence.*;

/**
 * Created by sgurram on 8/26/17.
 */
@Entity
@Table(name = "INVOICETRANSACTION", schema = "IHUB_OWNER", catalog = "")
public class InvoicetransactionEntity {
    private  @GeneratedValue long id;
    private String description;
    private Long amount;
    private long merchanteid;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "AMOUNT", nullable = true, precision = 0)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "MERCHANTEID", nullable = false, precision = 0)
    public long getMerchanteid() {
        return merchanteid;
    }

    public void setMerchanteid(long merchanteid) {
        this.merchanteid = merchanteid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoicetransactionEntity that = (InvoicetransactionEntity) o;

        if (id != that.id) return false;
        if (merchanteid != that.merchanteid) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (int) (merchanteid ^ (merchanteid >>> 32));
        return result;
    }
}
