package com.si.seminar.realestatewebsite.web.mapper;

import com.si.seminar.realestatewebsite.db.datamodel.*;
import com.si.seminar.realestatewebsite.web.utils.MessageResolverService;
import com.si.seminar.realestatewebsite.web.viewmodel.AdvertisementDetailViewModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Advertisement detail mapper.
 */
@Service
public class AdvertisementDetailMapper {

    @Autowired
    private MessageResolverService messageResolverService;

    public AdvertisementDetailViewModel mapRealEstateToAdvertisementModel(RealEstate realEstate) {

        RealEstateType realEstateType = realEstate.getRealEstateType();
        AdvertisementDetailViewModel viewModel = new AdvertisementDetailViewModel();

        viewModel.setRealEstateId(realEstate.getId());
        viewModel.setRealEstateImageType(realEstate.getImageType());

        String realEstateTypeTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.realEstateType");

        String realEstateTypeValue =
                messageResolverService.getResourceMessage(
                        String.format(
                                "realestatewebsite.fe.messages.general.realEstateType.%s",
                                realEstateType.name()));
        viewModel.addAdvertisementProperty(realEstateTypeTitle, realEstateTypeValue);

        String description = realEstate.getDescription();
        String descriptionTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.description");
        viewModel.addAdvertisementProperty(descriptionTitle, description);

        String advertisementTypeTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.advertisementType");
        AdvertisementType advertisementType = realEstate.getAdvertisementType();
        String advertisementTypeValue = messageResolverService.getResourceMessage(
                String.format("realestatewebsite.fe.messages.general.advertisementType.%s", advertisementType.name()));

        viewModel.addAdvertisementProperty(advertisementTypeTitle, advertisementTypeValue);

        String cityTitle = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.city");
        String cityValue =
                messageResolverService.getResourceMessage(
                        String.format("realestatewebsite.fe.messages.general.cities.%s", realEstate.getCity()));
        viewModel.addAdvertisementProperty(
                cityTitle,
                cityValue
        );

        String priceTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.price");
        String priceValue = BigDecimalFormatter.formatBigDecimal(realEstate.getPrice()) + " €";
        viewModel.addAdvertisementProperty(priceTitle, priceValue);

        String addressTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.address");
        String address = realEstate.getAddress();

        viewModel.addAdvertisementProperty(addressTitle, address);

        String squareMetersTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.squareMeters");
        String squareMeters = realEstate.getSquareMeters().toString() + " M2";
        viewModel.addAdvertisementProperty(squareMetersTitle, squareMeters);

        switch (realEstateType) {
            case HOUSE:
                mapHouseToViewModel(realEstate, viewModel);
                break;
            case APARTMENT:
                mapApartmentToViewModel(realEstate, viewModel);
        }

        return viewModel;
    }

    private void mapHouseToViewModel(RealEstate realEstate, AdvertisementDetailViewModel viewModel) {

        House house = (House) realEstate;

        String generalYesMessage = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.YES");
        String generalNoMessage = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.NO");

        String yearOfConstructionTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.yearOfConstruction");
        viewModel.addAdvertisementProperty(yearOfConstructionTitle, house.getYearOfConstruction().toString());

        String yardIncludedTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.yard");
        Boolean yardIncluded = house.isYardIncluded();
        String yardIncludedValueMessage =
                Boolean.TRUE.equals(yardIncluded) ? generalYesMessage : generalNoMessage;
        viewModel.addAdvertisementProperty(yardIncludedTitle, yardIncludedValueMessage);

        String garageIncludedTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.garage");
        Boolean garageIncluded = house.isGarageIncluded();
        String garageIncludedValueMessage =
                Boolean.TRUE.equals(garageIncluded) ? generalYesMessage : generalNoMessage;
        viewModel.addAdvertisementProperty(garageIncludedTitle, garageIncludedValueMessage);

        String centralHeatingTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.centralHeating");
        Boolean centralHeatingIncluded = house.isCentralHeatingIncluded();
        String centralHeatingValueMessageKey;
        if (Boolean.TRUE.equals(centralHeatingIncluded)) {
            centralHeatingValueMessageKey = generalYesMessage;
        } else {
            centralHeatingValueMessageKey = generalNoMessage;
        }
        viewModel.addAdvertisementProperty(centralHeatingTitle, centralHeatingValueMessageKey);

        String poolTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.pool");
        Boolean poolIncluded = house.isPoolIncluded();
        String poolValueMessage;
        if (Boolean.TRUE.equals(poolIncluded)) {
            poolValueMessage = generalYesMessage;
        } else {
            poolValueMessage = generalNoMessage;
        }
        viewModel.addAdvertisementProperty(poolTitle, poolValueMessage);

        String airConditionedTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.airConditioned");
        Boolean airConditioned = house.isAirConditioned();
        String airConditionedMessage;
        if (Boolean.TRUE.equals(airConditioned)) {
            airConditionedMessage = generalYesMessage;
        } else {
            airConditionedMessage = generalNoMessage;
        }
        viewModel.addAdvertisementProperty(airConditionedTitle, airConditionedMessage);


    }

    private void mapApartmentToViewModel(RealEstate realEstate, AdvertisementDetailViewModel viewModel) {

        Apartment apartment = (Apartment) realEstate;

        String generalYesMessage = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.YES");
        String generalNoMessage = messageResolverService.getResourceMessage("realestatewebsite.fe.messages.general.NO");

        String yearOfConstructionTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.yearOfConstruction");
        viewModel.addAdvertisementProperty(yearOfConstructionTitle, apartment.getYearOfConstruction().toString());

        String centralHeatingTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.centralHeating");
        Boolean centralHeatingIncluded = apartment.isCentralHeatingIncluded();
        String centralHeatingValueMessage;
        if (Boolean.TRUE.equals(centralHeatingIncluded)) {
            centralHeatingValueMessage = generalYesMessage;
        } else {
            centralHeatingValueMessage = generalNoMessage;
        }

        viewModel.addAdvertisementProperty(centralHeatingTitle, centralHeatingValueMessage);

        String airConditionedTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.airConditioned");
        Boolean airConditioned = apartment.isAirConditioned();
        String airConditionedMessage;
        if (Boolean.TRUE.equals(airConditioned)) {
            airConditionedMessage = generalYesMessage;
        } else {
            airConditionedMessage = generalNoMessage;
        }
        viewModel.addAdvertisementProperty(airConditionedTitle, airConditionedMessage);

        String elevatorTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.elevator");
        Boolean elevatorIncluded = apartment.isElevatorIncluded();
        String elevatorIncludedMessage;
        if (Boolean.TRUE.equals(elevatorIncluded)) {
            elevatorIncludedMessage = generalYesMessage;
        } else {
            elevatorIncludedMessage = generalNoMessage;
        }
        viewModel.addAdvertisementProperty(elevatorTitle, elevatorIncludedMessage);

        String parkingTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.parking");
        Boolean parkingIncluded = apartment.isParkingIncluded();
        String parkingIncludedMessage;
        if (Boolean.TRUE.equals(parkingIncluded)) {
            parkingIncludedMessage = generalYesMessage;
        } else {
            parkingIncludedMessage = generalNoMessage;
        }
        viewModel.addAdvertisementProperty(parkingTitle, parkingIncludedMessage);
    }

}
