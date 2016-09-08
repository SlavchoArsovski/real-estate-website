package com.si.seminar.realestatewebsite.db.repository;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.db.datamodel.Apartment;
import com.si.seminar.realestatewebsite.db.datamodel.Apartment_;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementation of {@link RealEstateRepositoryImpl}.
 */
public class ApartmentRepositoryImpl extends RealEstateRepositoryImpl<Apartment> {

    @Override
    protected Class getType() {
        return Apartment.class;
    }

    @Override
    protected List<Predicate> addCustomPredicates(
            CriteriaBuilder criteriaBuilder,
            Root<Apartment> realEstateRoot,
            SearchModel searchModel) {

        List<Predicate> predicates = Lists.newArrayList();

        if (searchModel.getYearOfConstruction().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(Apartment_.yearOfConstruction),
                            searchModel.getYearOfConstruction().get()));
        }

        if (searchModel.getCentralHeatingIncluded().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(Apartment_.centralHeatingIncluded),
                            searchModel.getCentralHeatingIncluded().get()));
        }

        if (searchModel.getAirConditioned().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(Apartment_.airConditioned),
                            searchModel.getAirConditioned().get()));
        }

        if (searchModel.getParkingIncluded().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(Apartment_.parkingIncluded),
                            searchModel.getParkingIncluded().get()));
        }

        if (searchModel.getElevatorIncluded().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(Apartment_.elevatorIncluded),
                            searchModel.getElevatorIncluded().get()));
        }

        if (searchModel.getNumberOfRooms().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(Apartment_.numberOfRooms),
                            searchModel.getNumberOfRooms().get()));
        }

        return predicates;
    }
}
