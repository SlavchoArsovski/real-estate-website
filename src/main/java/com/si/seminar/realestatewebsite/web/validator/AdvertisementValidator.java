package com.si.seminar.realestatewebsite.web.validator;

import com.si.seminar.realestatewebsite.web.viewmodel.AdvertisementViewModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Advertisement Form Validator.
 */
@Component
public class AdvertisementValidator implements Validator {

    private static final String ERROR_MESSAGES_PREFIX = "realestatewebsite.fe.messages.addAdvertisement.";
    private static final String EMPTY_DESCRIPTION_MESSAGE = ERROR_MESSAGES_PREFIX + "description.error.NotEmpty";
    private static final String EMPTY_ADDRESS_MESSAGE = ERROR_MESSAGES_PREFIX + "address.error.NotEmpty";
    private static final String EMPTY_PRICE_MESSAGE = ERROR_MESSAGES_PREFIX + "price.error.NotEmpty";
    private static final String EMPTY_SQUARE_METERS_MESSAGE = ERROR_MESSAGES_PREFIX + "squareMeters.error.NotEmpty";
    private static final String EMPTY_CITY_METERS_MESSAGE = ERROR_MESSAGES_PREFIX + "city.error.NotEmpty";

    @Override
    public boolean supports(Class<?> clazz) {
        return AdvertisementViewModel.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {

        AdvertisementViewModel advertisementViewModel = (AdvertisementViewModel) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", EMPTY_DESCRIPTION_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", EMPTY_ADDRESS_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", EMPTY_PRICE_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "squareMeters", EMPTY_SQUARE_METERS_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "selectedCity", EMPTY_CITY_METERS_MESSAGE);

    }
}
