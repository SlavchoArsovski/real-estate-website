package com.si.seminar.realestatewebsite.db.configuration;

import com.si.seminar.realestatewebsite.db.repository.RepositoryComponents;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Spring configuration for the data model.
 */
@Configuration
@Import({
        JpaPropertiesProvider.class,
        BasicDataSourceProvider.class,
        EntityManagerFactoryProvider.class,
        JpaTransactionManagerProvider.class
})
@ComponentScan(
    basePackageClasses = {
        RepositoryComponents.class
    })
@EnableJpaRepositories(basePackageClasses = { RepositoryComponents.class })
@EnableTransactionManagement
public class DataModelConfiguration {
}