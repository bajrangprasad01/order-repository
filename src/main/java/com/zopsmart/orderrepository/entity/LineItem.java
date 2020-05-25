package com.zopsmart.orderrepository.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class LineItem {
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
    private Product product;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID lineItemReference;
    private Integer quantity;
    private String description;
    private Double unitPrice;
    private String specialInstruction;
    private String imageLocation;
    private String isRefundable;
    private Integer quantityRefunded;
    private Integer quantityRefundable;
    private Integer quantityCompleteRefunds;
    private Integer quantityPendingRefunds;
//    private List<FulFilmentStatus> fulFilmentStatuses;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product id) {
        this.product = id;
    }

    public UUID getLineItemReference() {
        return lineItemReference;
    }

    public void setLineItemReference(UUID lineItemReference) {
        this.lineItemReference = lineItemReference;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getIsRefundable() {
        return isRefundable;
    }

    public void setIsRefundable(String isRefundable) {
        this.isRefundable = isRefundable;
    }

    public Integer getQuantityRefunded() {
        return quantityRefunded;
    }

    public void setQuantityRefunded(Integer quantityRefunded) {
        this.quantityRefunded = quantityRefunded;
    }

    public Integer getQuantityRefundable() {
        return quantityRefundable;
    }

    public void setQuantityRefundable(Integer quantityRefundable) {
        this.quantityRefundable = quantityRefundable;
    }

    public Integer getQuantityCompleteRefunds() {
        return quantityCompleteRefunds;
    }

    public void setQuantityCompleteRefunds(Integer quantityCompleteRefunds) {
        this.quantityCompleteRefunds = quantityCompleteRefunds;
    }

    public Integer getQuantityPendingRefunds() {
        return quantityPendingRefunds;
    }

    public void setQuantityPendingRefunds(Integer quantityPendingRefunds) {
        this.quantityPendingRefunds = quantityPendingRefunds;
    }
}
