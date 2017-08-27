package com.intuit.invoice_aggregator.configuration;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by sgurram on 3/16/17.
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value ={
        "classpath:application.properties"
})
public class InvoiceConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(Boolean.TRUE);
        try {
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
            org.springframework.core.io.Resource[] resources = pathMatchingResourcePatternResolver.getResources("application.properties");

            propertySourcesPlaceholderConfigurer.setLocations(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean(name = "inputDataSource")
    public DataSource idpsDataSource() throws Throwable{

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(environment.getProperty("input.jdbc.driverClassName"));
        dataSource.setUsername(environment.getProperty("input.jdbc.username"));
        dataSource.setPassword(environment.getProperty("input.jdbc.password"));
        dataSource.setUrl(environment.getProperty("input.jdbc.url"));

        return dataSource;

    }

}
