package com.si.seminar.realestatewebsite.web.mapper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.si.seminar.realestatewebsite.db.datamodel.*;
import com.si.seminar.realestatewebsite.web.utils.MessageResolverService;
import com.si.seminar.realestatewebsite.web.viewmodel.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.si.seminar.realestatewebsite.web.viewmodel.SearchParam.*;



/**
 * Contains methods for mapping real estate to view models.
 */
@Service
public class RealEstateMapper {

    public static final String REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX = "realestatewebsite.fe.messages.general.realEstateType";
    public static final String CITIES_MESSAGE_KEY_PREFIX = "realestatewebsite.fe.messages.general.cities";

    @Autowired
    private MessageResolverService messageResolverService;

    public void mapPropertyChangeModelToViewModel(
            HomeViewModel homeViewModel,
            HomePropertyChangeModel homePropertyChangeModel) {

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
        homeViewModel.setSelectedParkingIncluded(homePropertyChangeModel.getSelectedParkingIncluded());
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
        realEstateViewModel.setPrice(BigDecimalFormatter.formatBigDecimal(realEstate.getPrice()));
        realEstateViewModel.setSquareMeters(String.valueOf(realEstate.getSquareMeters()));
        realEstateViewModel.setRealEstateId(realEstate.getId());
        realEstateViewModel.setRealEstateImageType(realEstate.getImageType());

        return realEstateViewModel;
    }

    public Map<String, String> mapRealEstateTypes() {

        Map<String, String> realEstateTypesDropdown = Maps.newTreeMap();

        Stream.of(RealEstateType.values())
                .forEach(realEstateType -> {
                    String messageKey =
                            String.format("%s.%s", REAL_ESTATA_TYPE_MESSAGE_KEY_PREFIX, realEstateType.name());
                    String message = messageResolverService.getResourceMessage(messageKey);

                    realEstateTypesDropdown.put(realEstateType.name(), message);
                });

        return realEstateTypesDropdown;
    }

    public Map<String, String> mapCities() {

        Map<String, String> citiesDropdown = Maps.newTreeMap();

        String noCityKey =
                String.format("%s.%s", CITIES_MESSAGE_KEY_PREFIX, "ALL");
        String noCityMessage = messageResolverService.getResourceMessage(noCityKey);

        citiesDropdown.put("ALL", noCityMessage);

        Stream.of(City.values())
                .forEach(city -> {

                    String messageKey =
                            String.format("%s.%s", CITIES_MESSAGE_KEY_PREFIX, city.name());
                    String message = messageResolverService.getResourceMessage(messageKey);

                    citiesDropdown.put(city.name(), message);
                });

        return citiesDropdown;
    }

    public Map<String, String> mapYesNoOptions(String property) {

        Map<String, String> optionsDropdown = Maps.newLinkedHashMap();

        String key = String.format("realestatewebsite.fe.messages.home.property.%s.NO_SELECTION", property);
        String value = messageResolverService.getResourceMessage(key);
        optionsDropdown.put("NO_SELECTION", value);

        value = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.YES");
        optionsDropdown.put("YES", value);

        value = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.NO");
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
                        CITY);

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

    public Map<String, String> mapAdvertisementTypes() {

        Map<String, String> advertisementTypes = Maps.newLinkedHashMap();

        String value = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.advertisementType.SALE");
        advertisementTypes.put("SALE", value);

        value = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.advertisementType.RENT");
        advertisementTypes.put("RENT", value);

        return advertisementTypes;
    }

    public RealEstate mapAdvertisementViewModelToRealEstate(AdvertisementViewModel advertisementViewModel) {

        String selectedRealEstateType = advertisementViewModel.getSelectedRealEstateType();
        RealEstateType realEstateType = RealEstateType.valueOf(selectedRealEstateType);

        RealEstate realEstate;

        switch (realEstateType) {
            case HOUSE:
                realEstate = mapHouseFromAdvertisementViewModel(advertisementViewModel);
                break;
            case APARTMENT:
                realEstate = mapApartmentFromAdvertisementViewModel(advertisementViewModel);
                break;
            case OFFICE_SPACE:
                realEstate = mapOfficeSpaceFromAdvertisementViewModel(advertisementViewModel);
                break;
            case GROUND:
                realEstate = new Ground();
                break;
            case GARAGE:
                realEstate = new Garage();
                break;
            case ROOM:
                realEstate = new Room();
                break;
            case AGRICULTURAL_FIELD:
                realEstate = new AgriculturalField();
                break;
            default:
                throw new RuntimeException("Unsupported real estate type");
        }

        realEstate.setRealEstateType(realEstateType);
        realEstate.setCity(advertisementViewModel.getSelectedCity());
        realEstate.setPrice(advertisementViewModel.getPrice());
        realEstate.setSquareMeters(advertisementViewModel.getSquareMeters());
        realEstate.setCity(advertisementViewModel.getSelectedCity());
        realEstate.setDescription(advertisementViewModel.getDescription());
        realEstate.setAdvertisementType(AdvertisementType.valueOf(advertisementViewModel.getSelectedAdvertisementType()));
        realEstate.setAddress(advertisementViewModel.getAddress());

        return realEstate;
    }

    private RealEstate mapHouseFromAdvertisementViewModel(AdvertisementViewModel advertisementViewModel) {

        House house = new House();

        house.setYardIncluded(advertisementViewModel.isYard());
        house.setAirConditioned(advertisementViewModel.isAirConditioned());
        house.setGarageIncluded(advertisementViewModel.isGarage());
        house.setYearOfConstruction(advertisementViewModel.getYearOfConstruction());
        house.setNumberOfFloors(advertisementViewModel.getNumberOfFloors());
        house.setPoolIncluded(advertisementViewModel.isPool());

        return house;
    }

    private RealEstate mapApartmentFromAdvertisementViewModel(AdvertisementViewModel advertisementViewModel) {

        Apartment apartment = new Apartment();

        apartment.setYearOfConstruction(advertisementViewModel.getYearOfConstruction());
        apartment.setAirConditioned(advertisementViewModel.isAirConditioned());
        apartment.setElevatorIncluded(advertisementViewModel.isElevator());
        apartment.setFloorNumber(advertisementViewModel.getFloorNumber());
        apartment.setParkingIncluded(advertisementViewModel.isParking());
        apartment.setCentralHeatingIncluded(advertisementViewModel.isParking());

        return apartment;
    }

    private RealEstate mapOfficeSpaceFromAdvertisementViewModel(AdvertisementViewModel advertisementViewModel) {

        OfficeSpace officeSpace = new OfficeSpace();

        officeSpace.setCentralHeatingIncluded(advertisementViewModel.isCentralHeating());
        officeSpace.setYearOfConstruction(advertisementViewModel.getYearOfConstruction());

        return officeSpace;
    }
}
