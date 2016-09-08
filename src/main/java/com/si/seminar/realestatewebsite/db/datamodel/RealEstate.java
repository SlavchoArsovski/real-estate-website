package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private BigDecimal squareMeters;

    @Column(name = "CITY")
    private String city;

    @Column(name = "REGION")
    private String region;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

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

    public BigDecimal getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(BigDecimal squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
