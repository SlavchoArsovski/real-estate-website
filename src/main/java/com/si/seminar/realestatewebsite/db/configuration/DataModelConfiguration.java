package com.si.seminar.realestatewebsite.db.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 * Spring configuration for the transakt integration data model.
 */
@Configuration
//@ComponentScan(
//    basePackageClasses = {
//        TransaktIntegrationDAOComponents.class,
//        TransaktIntegrationRepositoryComponents.class
//    })
@Import({
        JpaPropertiesProvider.class,
        BasicDataSourceProvider.class,
        EntityManagerFactoryProvider.class,
        JpaTransactionManagerProvider.class
})
public class DataModelConfiguration {

}