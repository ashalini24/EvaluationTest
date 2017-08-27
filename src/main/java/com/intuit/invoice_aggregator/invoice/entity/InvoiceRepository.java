package com.intuit.invoice_aggregator.invoice.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sgurram on 8/23/17.
 */
public interface InvoiceRepository extends PagingRepository<InvoiceEntity, Long>{

}
