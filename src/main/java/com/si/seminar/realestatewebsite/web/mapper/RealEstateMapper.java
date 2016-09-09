package com.si.seminar.realestatewebsite.web.mapper;

import com.google.common.collect.Maps;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.web.viewmodel.City;
import com.si.seminar.realestatewebsite.web.viewmodel.RealEstateViewModel;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Contains methods for mapping real estate to view models.
 */
@Service
public class RealEstateMapper implements ApplicationContextAware {

    public static final String REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX = "realestatewebsite.fe.messages.general.realEstateType";
    public static final String CITIES_MESSAGE_KEY_PREFIX = "realestatewebsite.fe.messages.general.cities";

    private ApplicationContext appContext;

    public RealEstateViewModel mapRealEstateToRealEstateViewModel(RealEstate realEstate) {

        RealEstateViewModel realEstateViewModel = new RealEstateViewModel();

        realEstateViewModel.setRealEstateType(realEstate.getRealEstateType().name());
        realEstateViewModel.setCity(realEstate.getCity());
        realEstateViewModel.setDescription(realEstate.getDescription());
        realEstateViewModel.setAddress(realEstate.getAddress());
        realEstateViewModel.setRegion(realEstate.getRegion());

        return realEstateViewModel;
    }

    public Map<String, String> mapRealEstateTypes(Locale locale) {

        Map<String, String> realEstateTypesDropdown = Maps.newTreeMap();

        String noRealEstateTypeSelectedKey =
                String.format("%s.%s", REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX, "ALL");
        String noRealEstateTypeSelectedMessage = getResourceMessage(noRealEstateTypeSelectedKey, locale);

        realEstateTypesDropdown.put("ALL", noRealEstateTypeSelectedMessage);

        Stream.of(RealEstateType.values())
                .forEach(realEstateType -> {
                    String messageKey =
                            String.format("%s.%s", REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX, realEstateType.name());
                    String message = getResourceMessage(messageKey, locale);

                    realEstateTypesDropdown.put(realEstateType.name(), message);
                });

        return realEstateTypesDropdown;
    }

    public Map<String, String> mapCities(Locale locale) {

        Map<String, String> citiesDropdown = Maps.newTreeMap();

        String noCityKey =
                String.format("%s.%s", CITIES_MESSAGE_KEY_PREFIX, "ALL");
        String noCityMessage = getResourceMessage(noCityKey, locale);

        citiesDropdown.put("ALL", noCityMessage);

        Stream.of(City.values())
                .forEach(city -> {

                    String messageKey =
                            String.format("%s.%s", CITIES_MESSAGE_KEY_PREFIX, city.name());
                    String message = getResourceMessage(messageKey, locale);

                    citiesDropdown.put(city.name(), message);
                });

        return citiesDropdown;
    }

    private String getResourceMessage(String key, Locale locale) {
        return appContext.getMessage(
                key,
                new Object[]{},
                locale);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }
}
