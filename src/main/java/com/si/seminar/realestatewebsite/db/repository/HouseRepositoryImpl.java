package com.si.seminar.realestatewebsite.db.repository;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.db.datamodel.House;
import com.si.seminar.realestatewebsite.db.datamodel.House_;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementation of {@link RealEstateRepositoryImpl}.
 */
public class HouseRepositoryImpl extends RealEstateRepositoryImpl<House> {

    @Override
    protected Class getType() {
        return House.class;
    }

    @Override
    protected List<Predicate> addCustomPredicates(
            CriteriaBuilder criteriaBuilder,
            Root<House> realEstateRoot,
            SearchModel searchModel) {

        List<Predicate> predicates = Lists.newArrayList();

        if (searchModel.getYearOfConstruction().isPresent()) {
            predicates.add(
                    criteriaBuilder.greaterThanOrEqualTo(
                            realEstateRoot.get(House_.yearOfConstruction),
                            searchModel.getYearOfConstruction().get()));
        }

        if (searchModel.getCentralHeatingIncluded().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(House_.centralHeatingIncluded),
                            searchModel.getCentralHeatingIncluded().get()));
        }

        if (searchModel.getAirConditioned().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(House_.airConditioned),
                            searchModel.getAirConditioned().get()));
        }


        if (searchModel.getGarageIncluded().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(House_.garageIncluded),
                            searchModel.getGarageIncluded().get()));
        }

        if (searchModel.getPoolIncluded().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(House_.poolIncluded),
                            searchModel.getPoolIncluded().get()));
        }

        if (searchModel.getYardIncluded().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(House_.yardIncluded),
                            searchModel.getYardIncluded().get()));
        }

        return predicates;
    }
}
