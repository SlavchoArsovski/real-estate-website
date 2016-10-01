package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.User;
import com.si.seminar.realestatewebsite.db.datamodel.UserRoles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * User Repository.
 */
public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {

    List<UserRoles> findByUserName(String userName);
}
