package com.intuit.invoice_aggregator.invoice.entity;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by sgurram on 8/23/17.
 */
public interface InvoicetransactionRepository extends PagingRepository<InvoicetransactionEntity, Long> {

    InvoicetransactionEntity findByMerchanteid(Long merchantEid);
}
