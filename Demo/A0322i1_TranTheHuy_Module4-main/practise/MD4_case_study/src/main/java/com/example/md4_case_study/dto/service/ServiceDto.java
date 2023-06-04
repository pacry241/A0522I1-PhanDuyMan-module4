package com.example.md4_case_study.dto.service;


import com.example.md4_case_study.model.service.RentType;
import com.example.md4_case_study.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ServiceDto implements Validator {
    @Pattern(regexp = "\"^DV-\\\\d{4}$\"", message = "Service code is not valid!")
    private Long serviceId;
    @NotBlank(message = "{empty.invalid}")
    @Size(min = 2, max = 45, message = "{size.invalid}")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "{special.invalid}")
    private String serviceName;
    @NotBlank(message = "{empty.invalid}")
    @Size(min = 10, max = 50, message = "{size.invalid}")
    private Integer serviceArea;
    @NotBlank(message = "{empty.invalid}")
    @Min(value = 5, message = "Cost must have a positive value and greater than 5 dollars!")
    private Double serviceCost;
    @NotBlank(message = "{empty.invalid}")
    @Min(value = 1, message = "The people must have a positive value and at least 1 person!")
    private Integer serviceMaxPeople;
    @NotBlank(message = "{empty.invalid}")
    private String standardRoom;
    @Size(min = 0, max = 120, message = "{size.invalid}")
    private String descriptionOther;
    @NotBlank(message = "{empty.invalid}")
    @Min(value = 1, message = "The area of pool must have a positive value!")
    private Double poolArea;
    @NotBlank(message = "{empty.invalid}")
    @Min(value = 0, message = "The number of floor must have a positive value!")
    private Integer numberOfFloors;

    private RentType rentTypeId;
    private ServiceType serviceTypeId;

    public ServiceDto() {}

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public ServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(ServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
