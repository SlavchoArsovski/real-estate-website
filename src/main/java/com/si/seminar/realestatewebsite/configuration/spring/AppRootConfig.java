package com.si.seminar.realestatewebsite.configuration.spring;

import com.si.seminar.realestatewebsite.db.configuration.DataModelConfiguration;
import com.si.seminar.realestatewebsite.services.ServiceComponents;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;

/**
 * App root spring configuration.
 */
@Configuration
@Import({ DataModelConfiguration.class })
@ComponentScan( basePackageClasses = { ServiceComponents.class} )
public class AppRootConfig  implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {

        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();

        Resource resource = applicationContext.getResource("classpath:config.properties");
        propertyPlaceholderConfigurer.setLocations(resource);

        return propertyPlaceholderConfigurer;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
