package com.si.seminar.realestatewebsite.web.validator;

import com.si.seminar.realestatewebsite.db.datamodel.User;
import com.si.seminar.realestatewebsite.db.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserViewModel.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        UserViewModel user = (UserViewModel) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "realestatewebsite.fe.messages.registration.userName.error.NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "realestatewebsite.fe.messages.registration.userName.error.length");
        }
        Optional<User> userOptional = userRepository.findByUserName(user.getUserName());
        if (userOptional.isPresent()) {
            errors.rejectValue("userName", "realestatewebsite.fe.messages.registration.userName.error.duplicateUser");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "realestatewebsite.fe.messages.registration.password.error.NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "realestatewebsite.fe.messages.registration.password.error.length");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
