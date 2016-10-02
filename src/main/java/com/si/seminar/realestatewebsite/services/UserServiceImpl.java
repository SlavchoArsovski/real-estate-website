package com.si.seminar.realestatewebsite.services;

import com.si.seminar.realestatewebsite.db.datamodel.User;
import com.si.seminar.realestatewebsite.db.datamodel.UserRole;
import com.si.seminar.realestatewebsite.db.repository.UserRepository;
import com.si.seminar.realestatewebsite.db.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link UserService}.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("CustomUserDetailService")
    private UserDetailsService userDetailsService;

    @Override
    public void saveNewUser(User user, String role) {

        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);

        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserName(user.getUserName());
        userRole.setRole(role);

        userRoleRepository.save(userRole);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserRole> findUserRoles(String userName) {
        return userRoleRepository.findByUserName(userName);
    }

}
