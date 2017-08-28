package com.intuit.invoice_aggregator.ws.service;

import com.intuit.invoice_aggregator.exception.NoEmailException;
import com.intuit.invoice_aggregator.exception.NoNameException;
import com.intuit.invoice_aggregator.exception.NoTransactionException;
import com.intuit.invoice_aggregator.invoice.entity.*;
import com.intuit.invoice_aggregator.ws.model.InvoicePOJO;
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sgurram on 8/27/17.
 *
 * This Service Implements Creation of an Invoice. and Plcaholder for Getting an Invoice and Updating an Invoice.
 *

 */
@Service
public class InvoiceGeneratorServiceImpl implements InvoiceGeneratorService{

    private Logger logger = LoggerFactory.getLogger(InvoiceGeneratorServiceImpl.class);

    @Autowired
    @Qualifier("inputDataSource")
    private DataSource oasisDataSource;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoicetransactionRepository invoicetransactionRepository;

    @Override
    public InvoicePOJO createInvoice(InvoicePOJO invoicePOJO) throws Exception{

        String method = "createInvoice(Invoice)";
        logger.info(method + " entering");

        Log.info("Saving the Invoice Details");

        try {
            if (invoicePOJO == null) {
                Log.info("no Invoice to save");
                return null;
            }

            InvoiceEntity invoiceEntity = new InvoiceEntity();
            List<InvoicetransactionEntity> invoicetransactionEntityList = new ArrayList<InvoicetransactionEntity>();
            InvoicetransactionEntity invoicetransactionEntity = new InvoicetransactionEntity();
            int invoiceSequence = invoiceRepository.countByID();
            int invoiceTransactionSequence = invoicetransactionRepository.countByID();

            if(invoicePOJO.getName().equals(null)){
                throw new NoNameException();
            }
            else {
                invoiceEntity.setName(invoicePOJO.getName());
            }

            if(invoiceEntity.getEmail().equals(null)){
                throw new NoEmailException();
            }
            else{
                invoiceEntity.setEmail(invoiceEntity.getEmail());
            }

            if(invoiceEntity.getEmail().equals(null)){
                throw new NoEmailException();
            }
            else{
                invoiceEntity.setDuedate(invoiceEntity.getDuedate());
            }

            if(invoiceEntity.getEmail().equals(null)){
                throw new NoEmailException();
            }
            else{
                invoiceEntity.setId(invoiceSequence+1);
            }


            // Inserting the Merhcant information
            if (invoiceEntity != null) {
                invoiceRepository.save(invoiceEntity);
            }

            // Handiling Error if trnasaction infomation is not passed on
            if (invoicePOJO.getInvoicetransactionEntityList() == null){
                throw new NoTransactionException();
            }

            // Inserting the transaction information
            for (InvoicetransactionEntity invoicetransactionEntity1 : invoicePOJO.getInvoicetransactionEntityList()) {

                invoicetransactionEntity.setAmount(invoicetransactionEntity1.getAmount());
                invoicetransactionEntity.setDescription(invoicetransactionEntity1.getDescription());
                invoicetransactionEntity.setMerchanteid(invoiceEntity.getId());
                invoicetransactionEntity.setId(invoiceTransactionSequence+1);

                if (invoicetransactionEntity != null) {
                    invoicetransactionRepository.save(invoicetransactionEntity);
                }
            }

            return invoicePOJO;
        } finally {
            logger.info(method + "exiting");
        }

    }

}
