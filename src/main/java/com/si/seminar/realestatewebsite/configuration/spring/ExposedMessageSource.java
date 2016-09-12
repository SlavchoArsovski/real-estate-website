package com.si.seminar.realestatewebsite.configuration.spring;

import com.google.common.collect.Maps;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Created by sarsovsk on 12.09.2016.
 */
public class ExposedMessageSource extends ReloadableResourceBundleMessageSource {


    public Map<String, String> getAllMessages(Locale locale) {

        Map<String, String> messages = Maps.newHashMap();

        Set<Map.Entry<Object, Object>> entries = getMergedProperties(locale).getProperties().entrySet();
        entries.forEach(entry -> {
            messages.put((String) entry.getKey(), (String) entry.getValue());
        });

        return messages;
    }
}
