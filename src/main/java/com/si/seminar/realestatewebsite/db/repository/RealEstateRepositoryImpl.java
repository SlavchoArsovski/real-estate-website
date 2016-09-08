package com.si.seminar.realestatewebsite.db.repository;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate_;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementation of {@link RealEstateCustomRepository}.
 */
public abstract class RealEstateRepositoryImpl<T extends RealEstate> implements RealEstateCustomRepository {

    @PersistenceContext(unitName = "real-estate-persistence")
    private EntityManager entityManager;

    protected abstract Class<T> getType();

    @Override
    public List<T> getAllRealEstatesFromSearchModel(SearchModel searchModel, int pageIndex, int pageSize) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getType());

        Root<T> realEstateRoot = criteriaQuery.from(getType());

        List<Predicate> predicates = Lists.newArrayList();

        if (searchModel.getCity().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(RealEstate_.city),
                            searchModel.getCity().get()));
        }

        if (searchModel.getRegion().isPresent()) {
            predicates.add(
                    criteriaBuilder.equal(
                            realEstateRoot.get(RealEstate_.region),
                            searchModel.getRegion().get()));
        }

        if (searchModel.getPriceFrom().isPresent()) {
            predicates.add(
                    criteriaBuilder.greaterThanOrEqualTo(
                            realEstateRoot.get(RealEstate_.price),
                            searchModel.getPriceFrom().get()));
        }

        if (searchModel.getPriceTo().isPresent()) {
            predicates.add(
                    criteriaBuilder.lessThanOrEqualTo(
                            realEstateRoot.get(RealEstate_.price),
                            searchModel.getPriceTo().get()));
        }

        if (searchModel.getSquareMetersFrom().isPresent()) {
            predicates.add(
                    criteriaBuilder.greaterThanOrEqualTo(
                            realEstateRoot.get(RealEstate_.squareMeters),
                            searchModel.getSquareMetersFrom().get()));
        }

        if (searchModel.getSquareMetersTo().isPresent()) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(
                    realEstateRoot.get(RealEstate_.squareMeters),
                    searchModel.getSquareMetersTo().get()));
        }

        List<Predicate> customPredicates =
                addCustomPredicates(criteriaBuilder, realEstateRoot, searchModel);

        predicates.addAll(customPredicates);

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<T> resultList =
                entityManager
                        .createQuery(criteriaQuery)
                        .setFirstResult(pageIndex * pageSize)
                        .setMaxResults(pageSize)
                        .getResultList();

        return resultList;
    }

    protected List<Predicate> addCustomPredicates(
            CriteriaBuilder criteriaBuilder,
            Root<T> realEstateRoot,
            SearchModel searchModel) {

        return Lists.newArrayList();
    }

}
