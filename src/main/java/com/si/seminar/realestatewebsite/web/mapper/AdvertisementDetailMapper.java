package com.si.seminar.realestatewebsite.web.mapper;

import com.si.seminar.realestatewebsite.db.datamodel.AdvertisementType;
import com.si.seminar.realestatewebsite.db.datamodel.House;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
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
        viewModel.addAdvertisementProperty(
                realEstateTypeTitle,
                realEstateTypeValue
        );

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
            centralHeatingValueMessageKey = "realestatewebsite.fe.messages.general.YES";
        } else {
            centralHeatingValueMessageKey = "realestatewebsite.fe.messages.general.NO";
        }
        viewModel.addAdvertisementProperty(
                centralHeatingTitle,
                messageResolverService.getResourceMessage(centralHeatingValueMessageKey));

        String poolTitle =
                messageResolverService.getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.pool");
        Boolean poolIncluded = house.isPoolIncluded();
        String poolValueMessageKey;
        if (Boolean.TRUE.equals(poolIncluded)) {
            poolValueMessageKey = "realestatewebsite.fe.messages.general.YES";
        } else {
            poolValueMessageKey = "realestatewebsite.fe.messages.general.NO";
        }
        viewModel.addAdvertisementProperty(
                poolTitle,
                messageResolverService.getResourceMessage(poolValueMessageKey));


    }
}
