package com.si.seminar.realestatewebsite.web.mapper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.web.viewmodel.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.si.seminar.realestatewebsite.web.viewmodel.SearchParam.*;



/**
 * Contains methods for mapping real estate to view models.
 */
@Service
public class RealEstateMapper implements ApplicationContextAware {

    public static final String REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX = "realestatewebsite.fe.messages.general.realEstateType";
    public static final String CITIES_MESSAGE_KEY_PREFIX = "realestatewebsite.fe.messages.general.cities";

    private ApplicationContext appContext;

    public void mapPropertyChangeModelToViewMode(HomeViewModel homeViewModel, HomePropertyChangeModel homePropertyChangeModel) {

        homeViewModel.setSelectedRealEstateType(homePropertyChangeModel.getSelectedRealEstateType());
        homeViewModel.setPriceFrom(homePropertyChangeModel.getPriceFrom());
        homeViewModel.setPriceTo(homePropertyChangeModel.getPriceTo());
        homeViewModel.setSelectedCity(homePropertyChangeModel.getSelectedCity());
        homeViewModel.setSquareMetersFrom(homePropertyChangeModel.getSquareMetersFrom());
        homeViewModel.setSquareMetersTo(homePropertyChangeModel.getSquareMetersTo());
        homeViewModel.setSelectedAirConditioned(homePropertyChangeModel.getSelectedAirConditioned());
        homeViewModel.setSelectedCentralHeating(homePropertyChangeModel.getSelectedCentralHeating());
        homeViewModel.setSelectedElevatorIncluded(homePropertyChangeModel.getSelectedElevatorIncluded());
        homeViewModel.setSelectedGarageIncluded(homePropertyChangeModel.getSelectedGarageIncluded());
        homeViewModel.setNumberOfBeds(homePropertyChangeModel.getNumberOfBeds());
        homeViewModel.setNumberOfRooms(homePropertyChangeModel.getNumberOfRooms());
        homeViewModel.setSelectedPoolIncluded(homePropertyChangeModel.getSelectedPoolIncluded());
        homeViewModel.setSelectedYardIncluded(homePropertyChangeModel.getSelectedYardIncluded());
        homeViewModel.setYearOfConstruction(homePropertyChangeModel.getYearOfConstruction());
        homeViewModel.setAdvertisementType(homePropertyChangeModel.getAdvertisementType());
    }
    
    public RealEstateViewModel mapRealEstateToRealEstateViewModel(RealEstate realEstate) {

        RealEstateViewModel realEstateViewModel = new RealEstateViewModel();

        realEstateViewModel.setRealEstateType(realEstate.getRealEstateType().name());
        realEstateViewModel.setCity(realEstate.getCity());
        realEstateViewModel.setDescription(realEstate.getDescription());
        realEstateViewModel.setAddress(realEstate.getAddress());
        realEstateViewModel.setRegion(realEstate.getRegion());
        realEstateViewModel.setPrice(formatBigDecimal(realEstate.getPrice()));
        realEstateViewModel.setSquareMeters(String.valueOf(realEstate.getSquareMeters()));
        return realEstateViewModel;
    }

    public String formatBigDecimal(BigDecimal number) {

        number = number.setScale(2, BigDecimal.ROUND_HALF_UP);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);

        String result = df.format(number);

        return result;
    }

    public Map<String, String> mapRealEstateTypes(Locale locale) {

        Map<String, String> realEstateTypesDropdown = Maps.newTreeMap();

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

    public Map<String, String> mapYesNoOptions(Locale locale, String property) {

        Map<String, String> optionsDropdown = Maps.newLinkedHashMap();

        String key = String.format("realestatewebsite.fe.messages.home.property.%s.NO_SELECTION", property);
        String value = getResourceMessage(key, locale);
        optionsDropdown.put("NO_SELECTION", value);

        value = getResourceMessage("realestatewebsite.fe.messages.general.YES", locale);
        optionsDropdown.put("YES", value);

        value = getResourceMessage("realestatewebsite.fe.messages.general.NO", locale);
        optionsDropdown.put("NO", value);

        return optionsDropdown;
    }

    public List<String> mapValidPropertiesFromRealEstateType(String selectedRealEstateType) {

        RealEstateType realEstateType = RealEstateType.valueOf(selectedRealEstateType);

        // default properties
        List<SearchParam> validProperties =
                Lists.newArrayList(
                        REAL_ESTATE_TYPE,
                        SQUARE_METERS_FROM,
                        SQUARE_METERS_TO,
                        PRICE_FROM,
                        PRICE_TO,
                        CITY,
                        REGION);

        switch (realEstateType) {
            case HOUSE:
                validProperties.add(YEAR_OF_CONSTRUCTION);
                validProperties.add(GARAGE_INCLUDED);
                validProperties.add(CENTRAL_HEATING_INCLUDED);
                validProperties.add(AIR_CONDITIONED);
                validProperties.add(NUMBER_OF_FLOORS);
                validProperties.add(POOL_INCLUDED);
                validProperties.add(YARD_INCLUDED);
                break;
            case APARTMENT:
                validProperties.add(YEAR_OF_CONSTRUCTION);
                validProperties.add(CENTRAL_HEATING_INCLUDED);
                validProperties.add(AIR_CONDITIONED);
                validProperties.add(NUMBER_OF_ROOMS);
                validProperties.add(PARKING_INCLUDED);
                validProperties.add(ELEVATOR_INCLUDED);
                break;
            case OFFICE_SPACE:
                validProperties.add(YEAR_OF_CONSTRUCTION);
                validProperties.add(CENTRAL_HEATING_INCLUDED);
                validProperties.add(AIR_CONDITIONED);
                break;
            case ROOM:
                validProperties.add(NUMBER_OF_BEDS);
                break;
            case GROUND:
                break;
            case GARAGE:
                break;
            case AGRICULTURAL_FIELD:
                break;
        }

        List<String> properties = validProperties
                .stream()
                .map(property -> {
                    return property.name();
                })
                .collect(Collectors.toList());

        return properties;
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
