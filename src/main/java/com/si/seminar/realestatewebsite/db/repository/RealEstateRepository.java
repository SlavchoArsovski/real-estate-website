package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Registration repository.
 */
public interface RealEstateRepository extends CrudRepository<RealEstate, Long> {

  /**
   * Returns all registrations.
   * 
   * @return list of all entities.
   */
  List<RealEstate> findAll();

}
