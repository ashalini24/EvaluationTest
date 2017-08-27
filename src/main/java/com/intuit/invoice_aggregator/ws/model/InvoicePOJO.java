package com.intuit.invoice_aggregator.ws.model;

import com.intuit.invoice_aggregator.invoice.entity.InvoicetransactionEntity;

import java.sql.Time;
import java.util.List;

/**
 * Created by sgurram on 8/24/17.
 */
public class InvoicePOJO {

    private long id;
    private String name;
    private String email;
    private Time duedate;
    private List<InvoicetransactionEntity> invoicetransactionEntityList;

    public InvoicePOJO(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Time getDuedate() {
        return duedate;
    }

    public void setDuedate(Time duedate) {
        this.duedate = duedate;
    }

    public List<InvoicetransactionEntity> getInvoicetransactionEntityList() {
        return invoicetransactionEntityList;
    }

    public void setInvoicetransactionEntityList(List<InvoicetransactionEntity> invoicetransactionEntityList) {
        this.invoicetransactionEntityList = invoicetransactionEntityList;
    }
}
