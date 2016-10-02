package com.si.seminar.realestatewebsite.web.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Phone Validator.
 */
@Component
public class PhoneValidator {

    private static final String PHONE_PATTERN = "07[0125678][0-9]{6}";

    private static final Pattern pattern = Pattern.compile(PHONE_PATTERN);
    private Matcher matcher;

    /**
     * Validate hex with regular expression.
     *
     * @param hex the hex for validation.
     * @return true valid hex, false invalid hex.
     */
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
}
