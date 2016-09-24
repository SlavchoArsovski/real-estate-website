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

    @Override
    public boolean supports(Class<?> clazz) {
        return AdvertisementViewModel.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {

        AdvertisementViewModel advertisementViewModel = (AdvertisementViewModel) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.advertisementForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.advertisementForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "squareMeters", "NotEmpty.advertisementForm.squareMeters");

    }
}
