package com.intuit.invoice_aggregator.invoice.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


/**
 * Created by sgurram on 8/27/17.
 */
@NoRepositoryBean
public interface PagingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    @Query("SELECT COUNT(t.id) FROM #{#entityName} t")
    int countByID();

}
