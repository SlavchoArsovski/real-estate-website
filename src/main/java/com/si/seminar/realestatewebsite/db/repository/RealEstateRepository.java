package com.si.seminar.realestatewebsite.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Registration repository.
 */
@NoRepositoryBean
public interface RealEstateRepository<T>  extends CrudRepository<T, Long> {

  /**
   * Returns entities.
   * 
   * @return list of all entities.
   */
  List<T> findAll();

  /**
   * Find entity by Id.
   * @param id
   * @return found entity.
   */
  T findById(Long id);
}
