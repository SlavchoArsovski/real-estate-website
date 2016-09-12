package com.si.seminar.realestatewebsite.web.viewmodel;

import java.util.Map;

/**
 * View model with fe messages.
 */
public class ViewModelWithMessage {

    private Map<String, String> messages;

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    public void addMessage(String key, String value) {
        this.messages.put(key, value);
    }
}
