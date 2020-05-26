package com.zopsmart.orderrepository.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ReturnRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;
    private String status;
    private Date requestDate;
    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn
    private List<LineItem> lineItems;
    private String totalAmountToBeRefunded;
    private String totalRefund;
    private Integer quantity;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String getTotalAmountToBeRefunded() {
        return totalAmountToBeRefunded;
    }

    public void setTotalAmountToBeRefunded(String totalAmountToBeRefunded) {
        this.totalAmountToBeRefunded = totalAmountToBeRefunded;
    }

    public String getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(String totalRefund) {
        this.totalRefund = totalRefund;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
