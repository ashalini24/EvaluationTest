package com.intuit.invoice_aggregator.ws.web.api;

import com.intuit.invoice_aggregator.ws.model.InvoicePOJO;
import com.intuit.invoice_aggregator.ws.service.InvoiceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sgurram on 8/24/17.
 *
 * *
 * This Service Implements Creation of an Invoice. and Placeholder for Getting an Invoice and Updating an Invoice.
 *
 */

@RestController
public class InvoiceResource {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceResource.class);

    @Autowired
    InvoiceGeneratorService invoiceGeneratorService;

    @RequestMapping(value = "/api/invoice",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoicePOJO> createInvoice(@RequestBody InvoicePOJO newinvoice) throws Exception{

        InvoicePOJO saveInvoice= invoiceGeneratorService.createInvoice(newinvoice);

        if(saveInvoice== null){
            return new ResponseEntity<InvoicePOJO>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<InvoicePOJO>(saveInvoice, HttpStatus.CREATED);

    }

    /**
     * Tplace holder for 'GET' method to get the saved invoices.
     */
    @RequestMapping(value = "//api/invoice/{eid}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoicePOJO> getRetrievalRequest(@PathVariable("eid") Long eid){
        return null;
    }

    /**
     * Tplace holder for 'PUT' method to update Existing Invoice.
     */
    @RequestMapping(value = "/api/retrievalrequest/{eid}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoicePOJO> updateretrievalrequest(@RequestBody InvoicePOJO updateInvoice){
        return null;

    }

}
