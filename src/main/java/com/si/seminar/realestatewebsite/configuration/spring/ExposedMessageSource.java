package com.si.seminar.realestatewebsite.configuration.spring;

import com.google.common.collect.Maps;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Exposed Message source.
 */
public class ExposedMessageSource extends ReloadableResourceBundleMessageSource {

    public Map<String, String> getAllMessages() {

        Locale locale = LocaleContextHolder.getLocale();

        Map<String, String> messages = Maps.newHashMap();

        Set<Map.Entry<Object, Object>> entries = getMergedProperties(locale).getProperties().entrySet();
        entries.forEach(entry -> {
            messages.put((String) entry.getKey(), (String) entry.getValue());
        });

        return messages;
    }
}
