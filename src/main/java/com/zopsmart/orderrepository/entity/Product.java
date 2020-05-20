package com.zopsmart.orderrepository.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ageRestricted;
    private String alcoholFlag;
    private String availableOnClickList;
    private String belowMinimumAdvertisedPrice;
    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
    private String customerFacingSize;
    private String description;
    //    private List<FulfillMentOption> fulfillMentOptions;
//    private List<String> images;
    private String itemSizeUom;
    private String requiresUnitSizing;
    private String upc;
    private String taxGroupCode;
    //    private List<FulfulmentDetail> fulfulmentDetails;
    private String prop65;
    private String eblFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgeRestricted() {
        return ageRestricted;
    }

    public void setAgeRestricted(String ageRestricted) {
        this.ageRestricted = ageRestricted;
    }

    public String getAlcoholFlag() {
        return alcoholFlag;
    }

    public void setAlcoholFlag(String alcoholFlag) {
        this.alcoholFlag = alcoholFlag;
    }

    public String getAvailableOnClickList() {
        return availableOnClickList;
    }

    public void setAvailableOnClickList(String availableOnClickList) {
        this.availableOnClickList = availableOnClickList;
    }

    public String getBelowMinimumAdvertisedPrice() {
        return belowMinimumAdvertisedPrice;
    }

    public void setBelowMinimumAdvertisedPrice(String belowMinimumAdvertisedPrice) {
        this.belowMinimumAdvertisedPrice = belowMinimumAdvertisedPrice;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getCustomerFacingSize() {
        return customerFacingSize;
    }

    public void setCustomerFacingSize(String customerFacingSize) {
        this.customerFacingSize = customerFacingSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<String> getImages() {
//        return images;
//    }

//    public void setImages(List<String> images) {
//        this.images = images;
//    }

    public String getItemSizeUom() {
        return itemSizeUom;
    }

    public void setItemSizeUom(String itemSizeUom) {
        this.itemSizeUom = itemSizeUom;
    }

    public String getRequiresUnitSizing() {
        return requiresUnitSizing;
    }

    public void setRequiresUnitSizing(String requiresUnitSizing) {
        this.requiresUnitSizing = requiresUnitSizing;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getTaxGroupCode() {
        return taxGroupCode;
    }

    public void setTaxGroupCode(String taxGroupCode) {
        this.taxGroupCode = taxGroupCode;
    }

    public String getProp65() {
        return prop65;
    }

    public void setProp65(String prop65) {
        this.prop65 = prop65;
    }

    public String getEblFlag() {
        return eblFlag;
    }

    public void setEblFlag(String eblFlag) {
        this.eblFlag = eblFlag;
    }
}
