package com.si.seminar.realestatewebsite.services;

import com.si.seminar.realestatewebsite.db.datamodel.User;
import com.si.seminar.realestatewebsite.db.datamodel.UserRole;

import java.util.List;
import java.util.Optional;

/**
 * User Service.
 */
public interface UserService {

    /**
     * Saves new user with given role.
     *
     * @param user the user.
     * @param role the role of the user.
     */
    void saveNewUser(User user, String role);

    /**
     * Find user by user name.
     *
     * @param userName the user name.
     * @return user found.
     */
    Optional<User> findByUserName(String userName);

    /**
     * Find roles of give user.
     *
     * @param userName the user name.
     * @return list of roles.
     */
    List<UserRole> findUserRoles(String userName);

}
