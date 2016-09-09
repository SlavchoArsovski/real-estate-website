package com.si.seminar.realestatewebsite.web.mapper;

import com.google.common.collect.Maps;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
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

        String allRealEstateTypesKey =
                String.format("%s.%s", REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX, "ALL");
        String allRealEstateTypesMessage = getResourceMessage(allRealEstateTypesKey, locale);

        realEstateTypesDropdown.put("ALL", allRealEstateTypesMessage);

        Stream.of(RealEstateType.values())
                .forEach(realEstateType -> {
                    String messageKey =
                            String.format("%s.%s", REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX, realEstateType.name());
                    String message = getResourceMessage(messageKey, locale);

                    realEstateTypesDropdown.put(realEstateType.name(), message);
                });

        return realEstateTypesDropdown;
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
