package com.si.seminar.realestatewebsite.db.repository;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.db.datamodel.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementation of {@link RealEstateRepositoryImpl}.
 */
public class RoomRepositoryImpl extends RealEstateRepositoryImpl<Room> {

    @Override
    protected Class getType() {
        return Room.class;
    }

    @Override
    protected List<Predicate> addCustomPredicates(
            CriteriaBuilder criteriaBuilder,
            Root<Room> realEstateRoot,
            SearchModel searchModel) {

        List<Predicate> predicates = Lists.newArrayList();

        if (searchModel.getNumberOfBeds().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(Room_.numberOfBeds),
                            searchModel.getNumberOfBeds().get()));
        }

        return predicates;
    }
}
