package com.codegym.shopping_cart.dto;

import java.util.Objects;

public class ProductDto {
    private Long idProduct;
    private String nameProduct;
    private Double price;
    private String description;

    private String imageURL;

    public ProductDto() {
    }

    public ProductDto(String nameProduct, Double price, String description, String imageURL) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        ProductDto that = (ProductDto) object;
        return this.idProduct.equals(that.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct);
    }
}
