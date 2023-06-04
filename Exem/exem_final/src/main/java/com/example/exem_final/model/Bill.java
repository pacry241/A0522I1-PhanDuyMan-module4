package com.example.exem_final.model;

import com.example.exem_final.validate.EXPDateValid;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @EXPDateValid
    private LocalDate publishDate;

    @Min(value = 1, message = "The number must be greater than 0 and cannot be blank!")
    private int quantity;

    @NotBlank(message = "Description is mandatory!")
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Bill() {
    }

    public Bill(Integer billId, LocalDate publishDate, int quantity, String description, Product product) {
        this.billId = billId;
        this.publishDate = publishDate;
        this.quantity = quantity;
        this.description = description;
        this.product = product;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
