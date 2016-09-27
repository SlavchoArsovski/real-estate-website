package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Real Estate DB model.
 */
@Entity
@Table(name = "REAL_ESTATE")
@Access(AccessType.FIELD)
@DiscriminatorColumn(name="REAL_ESTATE_TYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "REAL_ESTATE_ID_SEQUENCE_GENERATOR")
    @SequenceGenerator(
            name = "REAL_ESTATE_ID_SEQUENCE_GENERATOR",
            sequenceName = "REAL_ESTATE_ID_SEQUENCE",
            allocationSize = 1,
            initialValue = 10000)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "REAL_ESTATE_TYPE", nullable = false, insertable=false, updatable=false)
    @Enumerated(EnumType.STRING)
    private RealEstateType realEstateType;

    @Column(name = "SQUARE_METERS")
    private Integer squareMeters;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "IMAGE_TYPE")
    private String imageType;

    @Column(name = "ADVERTISEMENT_TYPE")
    @Enumerated(EnumType.STRING)
    private AdvertisementType advertisementType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON")
    private Date createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public AdvertisementType getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(AdvertisementType advertisementType) {
        this.advertisementType = advertisementType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
