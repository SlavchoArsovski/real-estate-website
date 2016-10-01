package com.si.seminar.realestatewebsite.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Message resolver service
 */
@Service
public class MessageResolverService implements ApplicationContextAware {

    private ApplicationContext appContext;

    public String getResourceMessage(String key) {

        Locale locale = LocaleContextHolder.getLocale();

        return appContext.getMessage(
                key,
                new Object[]{},
                locale);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }
}
