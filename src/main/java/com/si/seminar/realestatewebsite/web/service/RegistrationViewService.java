package com.si.seminar.realestatewebsite.web.service;

import com.si.seminar.realestatewebsite.db.datamodel.User;
import com.si.seminar.realestatewebsite.services.UserService;
import com.si.seminar.realestatewebsite.web.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Registration view service.
 */
@Service
public class RegistrationViewService {

    @Autowired
    private UserService userService;

    public void saveUser(UserViewModel userViewModel) {

        User user = new User();
        user.setUserName(userViewModel.getUserName());
        user.setPassword(userViewModel.getPassword());
        user.setEmail(userViewModel.getEmail());
        user.setEnabled(true);
        user.setPhoneNumber(userViewModel.getPhoneNumber());

        userService.saveNewUser(user, "ROLE_USER");
    }
}
