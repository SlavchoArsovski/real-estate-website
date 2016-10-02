package com.si.seminar.realestatewebsite.web.validator;

import com.si.seminar.realestatewebsite.db.datamodel.User;
import com.si.seminar.realestatewebsite.db.repository.UserRepository;
import com.si.seminar.realestatewebsite.services.UserService;
import com.si.seminar.realestatewebsite.web.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * User Validator.
 */
@Component
public class UserValidator implements Validator {

    private static final String ERROR_MESSAGES_PREFIX = "realestatewebsite.fe.messages.registration.";
    private static final String EMPTY_USER_NAME_MESSAGE = ERROR_MESSAGES_PREFIX + "userName.error.NotEmpty";
    private static final String DUPLICATE_USER_NAME_MESSAGE = ERROR_MESSAGES_PREFIX + "userName.error.duplicateUser";
    private static final String WRONG_LENGTH_USER_NAME_MESSAGE = ERROR_MESSAGES_PREFIX + "userName.error.length";
    private static final String WRONG_LENGTH_PASSWORD_MESSAGE = ERROR_MESSAGES_PREFIX + "password.error.length";
    private static final String EMPTY_PASSWORD_MESSAGE = ERROR_MESSAGES_PREFIX + "password.error.NotEmpty";
    private static final String PASSWORD_CONFIRM_NOT_MATCHED_MESSAGE =
            ERROR_MESSAGES_PREFIX + "passwordConfirm.error.notMatched";
    private static final String NOT_VALID_EMAIL_MESSAGE = ERROR_MESSAGES_PREFIX + "email.error.regexNotMatched";
    private static final String NOT_VALID_PHONE_NUMBER_MESSAGE =
            ERROR_MESSAGES_PREFIX + "phoneNumber.error.regexNotMatched";

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private PhoneValidator phoneValidator;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserViewModel.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        UserViewModel user = (UserViewModel) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", EMPTY_USER_NAME_MESSAGE);
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", WRONG_LENGTH_USER_NAME_MESSAGE);
        }
        Optional<User> userOptional = userService.findByUserName(user.getUserName());
        if (userOptional.isPresent()) {
            errors.rejectValue("userName", DUPLICATE_USER_NAME_MESSAGE);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", EMPTY_PASSWORD_MESSAGE);
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", WRONG_LENGTH_PASSWORD_MESSAGE);
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", PASSWORD_CONFIRM_NOT_MATCHED_MESSAGE);
        }

        if (!emailValidator.validate(user.getEmail())) {
            errors.rejectValue("email", NOT_VALID_EMAIL_MESSAGE);
        }

        if (!phoneValidator.validate(user.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", NOT_VALID_PHONE_NUMBER_MESSAGE);
        }
    }
}
