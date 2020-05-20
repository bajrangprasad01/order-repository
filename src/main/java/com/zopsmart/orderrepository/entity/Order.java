package com.zopsmart.orderrepository.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long kcpOrderId;
    @OneToMany
    @JoinColumn
    private List<Product> products;
    @OneToMany
    @JoinColumn
    private List<Product> cancelProducts;
    private String version;
    private String purchaseType;
    private String status;
    @CreationTimestamp
    private Date creationTime;
    private Double grandTotal;
    //    private DeliveryInfo deliveryInfo;
    @OneToMany
    @JoinColumn
    private List<LineItem> items;
    private Long customerId;
    private Double lineSubTotal;
    private Double serviceCharge;
    private Double subTotal;
    private Double taxTotal;
    private Double total;
    private Double discountTotal;
    private Double discountPercent;
    private Double productAmountToBeRefunded;
    private Double taxAmountToBeRefunded;
    private Double discount;
    private String banner;
    @OneToMany
    @JoinColumn
    private List<ReturnRequest> returnRequests;
    private String hasPendingRefund;
    private String hasRefundableProduct;
    private Double totalRefund;
    private String modifiable;
    private String isInstacartOrder;
    private String substitutionAllowedForAllItems;
    private String cancelable;
    private Integer itemsCount;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getCancelProducts() {
        return cancelProducts;
    }

    public void setCancelProducts(List<Product> cancelProducts) {
        this.cancelProducts = cancelProducts;
    }

    public Long getKcpOrderId() {
        return kcpOrderId;
    }

    public void setKcpOrderId(Long kcpOrderId) {
        this.kcpOrderId = kcpOrderId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getLineSubTotal() {
        return lineSubTotal;
    }

    public void setLineSubTotal(Double lineSubTotal) {
        this.lineSubTotal = lineSubTotal;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(Double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(Double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getProductAmountToBeRefunded() {
        return productAmountToBeRefunded;
    }

    public void setProductAmountToBeRefunded(Double productAmountToBeRefunded) {
        this.productAmountToBeRefunded = productAmountToBeRefunded;
    }

    public Double getTaxAmountToBeRefunded() {
        return taxAmountToBeRefunded;
    }

    public void setTaxAmountToBeRefunded(Double taxAmountToBeRefunded) {
        this.taxAmountToBeRefunded = taxAmountToBeRefunded;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<ReturnRequest> getReturnRequests() {
        return returnRequests;
    }

    public void setReturnRequests(List<ReturnRequest> returnRequests) {
        this.returnRequests = returnRequests;
    }

    public String getHasPendingRefund() {
        return hasPendingRefund;
    }

    public void setHasPendingRefund(String hasPendingRefund) {
        this.hasPendingRefund = hasPendingRefund;
    }

    public String getHasRefundableProduct() {
        return hasRefundableProduct;
    }

    public void setHasRefundableProduct(String hasRefundableProduct) {
        this.hasRefundableProduct = hasRefundableProduct;
    }

    public Double getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Double totalRefund) {
        this.totalRefund = totalRefund;
    }

    public String getModifiable() {
        return modifiable;
    }

    public void setModifiable(String modifiable) {
        this.modifiable = modifiable;
    }

    public String getIsInstacartOrder() {
        return isInstacartOrder;
    }

    public void setIsInstacartOrder(String isInstacartOrder) {
        this.isInstacartOrder = isInstacartOrder;
    }

    public String getSubstitutionAllowedForAllItems() {
        return substitutionAllowedForAllItems;
    }

    public void setSubstitutionAllowedForAllItems(String substitutionAllowedForAllItems) {
        this.substitutionAllowedForAllItems = substitutionAllowedForAllItems;
    }

    public String getCancelable() {
        return cancelable;
    }

    public void setCancelable(String cancelable) {
        this.cancelable = cancelable;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }
}
