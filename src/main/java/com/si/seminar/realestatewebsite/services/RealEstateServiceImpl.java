package com.si.seminar.realestatewebsite.services;

import com.si.seminar.realestatewebsite.db.datamodel.*;
import com.si.seminar.realestatewebsite.db.repository.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of {@link RealEstateService}.
 */
@Service
public class RealEstateServiceImpl implements RealEstateService, ApplicationContextAware {

    @Value("${realEstateWebsite.home.realEstatesListComponent.pagesize}")
    private int pageSize;

    @Value("${realEstateWebsite.realEstateImagesFolderPath}")
    private String realEstateImagesFolderPath;

    private ApplicationContext applicationContext;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private GroundRepository groundRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private OfficeSpaceRepository officeSpaceRepository;

    @Autowired
    private AgriculturalFieldRepository agriculturalFieldRepository;

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("unchecked")
    @Override
    public List<RealEstate> getRealEstatesFromSearchParams(
            SearchModel searchModel,
            int pageNumber) {

        List<RealEstate> realEstates;
        RealEstateType selectedRealEstateType = searchModel.getRealEstateType();

        switch (selectedRealEstateType) {
            case HOUSE:
                realEstates = (List<RealEstate>) (List<?>)
                        houseRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case APARTMENT:
                realEstates = (List<RealEstate>) (List<?>)
                        apartmentRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case OFFICE_SPACE:
                realEstates = (List<RealEstate>) (List<?>)
                        officeSpaceRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case ROOM:
                realEstates = (List<RealEstate>) (List<?>)
                        roomRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case GARAGE:
                realEstates = (List<RealEstate>) (List<?>)
                        garageRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case GROUND:
                realEstates = (List<RealEstate>) (List<?>)
                        groundRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case AGRICULTURAL_FIELD:
                realEstates = (List<RealEstate>) (List<?>)
                        agriculturalFieldRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            default:
                throw new RuntimeException("Not supported real estate type");
        }

        return realEstates;
    }

    @Override
    public int getRealEstatesCountFromSearchParams(SearchModel searchModel) {

        int count;
        RealEstateType selectedRealEstateType = searchModel.getRealEstateType();

        switch (selectedRealEstateType) {
            case HOUSE:
                count = houseRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case APARTMENT:
                count = apartmentRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case OFFICE_SPACE:
                count = officeSpaceRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case ROOM:
                count = roomRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case GARAGE:
                count = garageRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case GROUND:
                count = groundRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case AGRICULTURAL_FIELD:
                count = agriculturalFieldRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            default:
                throw new RuntimeException("Not supported real estate type");
        }

        return count;
    }

    @Override
    public void saveRealEstate(RealEstate realEstate) {

        org.springframework.security.core.userdetails.User principal =
                (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<com.si.seminar.realestatewebsite.db.datamodel.User> user =
                userRepository.findByUserName(principal.getUsername());

        realEstate.setUser(user.get());

        realEstate.setCreatedOn(new Date());

        switch (realEstate.getRealEstateType()) {
            case HOUSE:
                houseRepository.save((House) realEstate);
                break;
            case APARTMENT:
                apartmentRepository.save((Apartment) realEstate);
                break;
            case OFFICE_SPACE:
                officeSpaceRepository.save((OfficeSpace) realEstate);
                break;
            case ROOM:
                roomRepository.save((Room) realEstate);
                break;
            case GARAGE:
                garageRepository.save((Garage) realEstate);
                break;
            case GROUND:
                groundRepository.save((Ground) realEstate);
                break;
            case AGRICULTURAL_FIELD:
                agriculturalFieldRepository.save((AgriculturalField) realEstate);
                break;
            default:
                throw new RuntimeException("Not supported real estate type");
        }


    }

    @Override
    public void saveRealEstateImage(MultipartFile realEstateImage, Long imageId) {

        String contentType = realEstateImage.getContentType();

        Pattern imageTypePattern = Pattern.compile("image/(.+)");
        Matcher matcher = imageTypePattern.matcher(contentType);

        if (!matcher.matches()) {
            throw new RuntimeException("incorrect image format");
        }

        String imageType = matcher.group(1);

        String fullImagePath = String.format(
                "%sRealEstateImage_%s.%s",
                realEstateImagesFolderPath,
                imageId,
                imageType);

        try {
            BufferedImage src = ImageIO.read(realEstateImage.getInputStream());
            File destination = new File(fullImagePath);
            ImageIO.write(src, imageType, destination);
        } catch (IOException e) {
            throw new RuntimeException("image can't be stored");
        }

    }

    @Override
    public byte[] getRealEstateImage(Long imageId, String imageType) {

        String realEstateImagePath = String.format("file:%sRealEstateImage_%s.%s", realEstateImagesFolderPath, imageId, imageType);
        byte[] byteArray;

        try {
            Resource resource = applicationContext.getResource(realEstateImagePath);
            byteArray = IOUtils.toByteArray(resource.getInputStream());
        } catch (IOException e) {
            byteArray = getFallbackImage();
        }
        return byteArray;
    }

    private byte[] getFallbackImage() {
        Resource resource = applicationContext.getResource("classpath:nophoto.png");
        try {
            return IOUtils.toByteArray(resource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("failed to load fallback image");
        }
    }

    @Override
    public RealEstate getRealEstateByIdAndType(Long id, RealEstateType realEstateType) {

        RealEstate realEstate;
        switch (realEstateType) {
            case HOUSE:
                realEstate = houseRepository.findById(id);
                break;
            case APARTMENT:
                realEstate = apartmentRepository.findById(id);
                break;
            case OFFICE_SPACE:
                realEstate = officeSpaceRepository.findById(id);
                break;
            case GARAGE:
                realEstate = garageRepository.findById(id);
                break;
            case GROUND:
                realEstate = groundRepository.findById(id);
                break;
            case ROOM:
                realEstate = roomRepository.findById(id);
                break;
            case AGRICULTURAL_FIELD:
                realEstate = agriculturalFieldRepository.findById(id);
                break;
            default:
                throw new RuntimeException("not supported real estate type");
        }

        return realEstate;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
