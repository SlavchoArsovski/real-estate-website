package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User Repository.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    List<UserRole> findByUserName(String userName);
}
