package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * User Repository.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
