package com.si.seminar.realestatewebsite.configuration.spring;

import com.si.seminar.realestatewebsite.db.configuration.DataModelConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;

/**
 * Created by sarsovsk on 03.09.2016.
 */
@Configuration
@Import({ DataModelConfiguration.class })
public class AppRootConfig  implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {

        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();

        Resource resource = applicationContext.getResource("classpath:config.properties");
        propertyPlaceholderConfigurer.setLocations(resource);

        return propertyPlaceholderConfigurer;
    }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource() {

        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages/messages");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
