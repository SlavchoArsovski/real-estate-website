package com.si.seminar.realestatewebsite.web.mapper;

import com.si.seminar.realestatewebsite.db.datamodel.AdvertisementType;
import com.si.seminar.realestatewebsite.db.datamodel.House;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.web.viewmodel.AdvertisementDetailViewModel;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Advertisement detail mapper.
 */
@Service
public class AdvertisementDetailMapper implements ApplicationContextAware {

    private ApplicationContext appContext;

    public AdvertisementDetailViewModel mapRealEstateToAdvertisementModel(RealEstate realEstate, Locale locale) {

        RealEstateType realEstateType = realEstate.getRealEstateType();
        AdvertisementDetailViewModel viewModel = new AdvertisementDetailViewModel();

        viewModel.setRealEstateId(realEstate.getId());
        viewModel.setRealEstateImageType(realEstate.getImageType());

        String realEstateTypeTitle =
                getResourceMessage("realestatewebsite.fe.messages.general.realEstateType", locale);

        String realEstateTypeValue =
                getResourceMessage(
                        String.format(
                                "realestatewebsite.fe.messages.general.realEstateType.%s",
                                realEstateType.name()),
                        locale);
        viewModel.addAdvertisementProperty(
                realEstateTypeTitle,
                realEstateTypeValue
        );

        String advertisementTypeTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.advertisementType", locale);
        AdvertisementType advertisementType = realEstate.getAdvertisementType();
        String advertisementTypeValue = getResourceMessage(
                String.format("realestatewebsite.fe.messages.general.advertisementType.%s", advertisementType.name()),
                locale);

        viewModel.addAdvertisementProperty(advertisementTypeTitle, advertisementTypeValue);

        String cityTitle = getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.city", locale);
        String cityValue =
                getResourceMessage(
                        String.format("realestatewebsite.fe.messages.general.cities.%s", realEstate.getCity()),
                        locale);
        viewModel.addAdvertisementProperty(
                cityTitle,
                cityValue
        );

        String priceTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.price", locale);
        String priceValue = BigDecimalFormatter.formatBigDecimal(realEstate.getPrice()) + " €";
        viewModel.addAdvertisementProperty(priceTitle, priceValue);


        String addressTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.address", locale);
        String address = realEstate.getAddress();

        viewModel.addAdvertisementProperty(addressTitle, address);

        String squareMetersTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.squareMeters", locale);
        String squareMeters = realEstate.getSquareMeters().toString() + " M2";
        viewModel.addAdvertisementProperty(squareMetersTitle, squareMeters);

        switch (realEstateType) {
            case HOUSE:
                mapHouseToViewModel(realEstate, viewModel, locale);
                break;
        }

        return viewModel;
    }

    private void mapHouseToViewModel(
            RealEstate realEstate,
            AdvertisementDetailViewModel viewModel,
            Locale locale) {

        House house = (House) realEstate;

        String generalYesMessage = getResourceMessage("realestatewebsite.fe.messages.general.YES", locale);
        String generalNoMessage = getResourceMessage("realestatewebsite.fe.messages.general.NO", locale);

        String yearOfConstructionTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.yearOfConstruction", locale);
        viewModel.addAdvertisementProperty(yearOfConstructionTitle, house.getYearOfConstruction().toString());

        String yardIncludedTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.yard", locale);
        Boolean yardIncluded = house.isYardIncluded();
        String yardIncludedValueMessage =
                Boolean.TRUE.equals(yardIncluded) ? generalYesMessage : generalNoMessage;
        viewModel.addAdvertisementProperty(yardIncludedTitle, yardIncludedValueMessage);

        String garageIncludedTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.garage", locale);
        Boolean garageIncluded = house.isGarageIncluded();
        String garageIncludedValueMessage =
                Boolean.TRUE.equals(garageIncluded) ? generalYesMessage : generalNoMessage;
        viewModel.addAdvertisementProperty(garageIncludedTitle, garageIncludedValueMessage);

        String centralHeatingTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.centralHeating", locale);
        Boolean centralHeatingIncluded = house.isCentralHeatingIncluded();
        String centralHeatingValueMessageKey;
        if (Boolean.TRUE.equals(centralHeatingIncluded)) {
            centralHeatingValueMessageKey = "realestatewebsite.fe.messages.general.YES";
        } else {
            centralHeatingValueMessageKey = "realestatewebsite.fe.messages.general.NO";
        }
        viewModel.addAdvertisementProperty(centralHeatingTitle, getResourceMessage(centralHeatingValueMessageKey, locale));

        String poolTitle =
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.pool", locale);
        Boolean poolIncluded = house.isPoolIncluded();
        String poolValueMessageKey;
        if (Boolean.TRUE.equals(poolIncluded)) {
            poolValueMessageKey = "realestatewebsite.fe.messages.general.YES";
        } else {
            poolValueMessageKey = "realestatewebsite.fe.messages.general.NO";
        }
        viewModel.addAdvertisementProperty(poolTitle, getResourceMessage(poolValueMessageKey, locale));


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
