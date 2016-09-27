package com.si.seminar.realestatewebsite.web.mapper;

import com.si.seminar.realestatewebsite.configuration.spring.ExposedMessageSource;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
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
public class AdvertisementDetailMapper implements ApplicationContextAware {

    private ApplicationContext appContext;

    @Autowired
    private ExposedMessageSource messageSource;

    public AdvertisementDetailViewModel mapRealEstateToAdvertisementModel(RealEstate realEstate, Locale locale) {

        AdvertisementDetailViewModel viewModel = new AdvertisementDetailViewModel();

        viewModel.setRealEstateId(realEstate.getId());
        viewModel.setRealEstateImageType(realEstate.getImageType());

        viewModel.addAdvertisementProperty(
                getResourceMessage("realestatewebsite.fe.messages.general.realEstateType", locale),
                getResourceMessage(String.format("realestatewebsite.fe.messages.general.realEstateType.%s", realEstate.getRealEstateType().name()), locale)
        );

        viewModel.addAdvertisementProperty(
                getResourceMessage("realestatewebsite.fe.messages.advertisementDetail.label.city", locale),
                realEstate.getCity()
        );

        return viewModel;
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
