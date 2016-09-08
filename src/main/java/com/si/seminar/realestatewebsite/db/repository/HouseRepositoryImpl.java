package com.si.seminar.realestatewebsite.db.repository;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.db.datamodel.House;
import com.si.seminar.realestatewebsite.db.datamodel.House_;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sarsovsk on 08.09.2016.
 */
public class HouseRepositoryImpl implements HouseCustomRepository {

    @PersistenceContext(unitName = "real-estate-persistence")
    private EntityManager entityManager;

    @Override
    public List<House> getAllHousesFromSearchModel(SearchModel searchModel, int pageIndex, int pageSize) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<House> criteriaQuery = criteriaBuilder.createQuery(House.class);

        Root<House> registrationRoot = criteriaQuery.from(House.class);

        List<Predicate> predicates = Lists.newArrayList();

        predicates.add(
                criteriaBuilder.equal(
                        registrationRoot.get(House_.yearOfConstruction),
                        searchModel.getYearOfConstruction()));
        predicates.add(
                criteriaBuilder.equal(
                        registrationRoot.get(House_.centralHeatingIncluded),
                        searchModel.getCentralHeatingIncluded().booleanValue()));
        predicates.add(
                criteriaBuilder.equal(
                        registrationRoot.get(House_.airConditioned),
                        searchModel.getAirConditioned().booleanValue()));
        predicates.add(
                criteriaBuilder.equal(
                        registrationRoot.get(House_.garageIncluded),
                        searchModel.getGarageIncluded().booleanValue()));
        predicates.add(
                criteriaBuilder.equal(
                        registrationRoot.get(House_.poolIncluded),
                        searchModel.getPoolIncluded().booleanValue()));
        predicates.add(
                criteriaBuilder.equal(
                        registrationRoot.get(House_.yardIncluded),
                        searchModel.getYardIncluded().booleanValue()));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<House> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        return resultList;
    }
}
