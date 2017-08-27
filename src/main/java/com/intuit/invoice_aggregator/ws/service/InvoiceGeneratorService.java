package com.intuit.invoice_aggregator.ws.service;

import com.intuit.invoice_aggregator.invoice.entity.InvoiceRepository;
import com.intuit.invoice_aggregator.ws.model.InvoicePOJO;

/**
 * Created by sgurram on 8/25/17.
 */
public interface InvoiceGeneratorService {

    public InvoicePOJO createInvoice(InvoicePOJO invpoicePOJO) throws Exception;
}
