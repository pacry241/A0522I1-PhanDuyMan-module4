package com.codegym.casestudyversion2.dto;

import com.codegym.casestudyversion2.validator.EXPDateValid;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CustomerDto {

    @Pattern(regexp = "\"^KH-\\\\d{4}$\"", message = "Customer code is not valid!")
    private Long customerId;

    @NotBlank(message = "{empty.invalid}")
    @Size(min = 3, max = 45, message = "{size.invalid}")
    @Pattern(regexp = "^[A-Z]+(?:\\\\s[A-Za-z]+)*$", message = "{character.invalid}")
    private String customerName;

    @NotBlank(message = "{empty.invalid}")
    @EXPDateValid
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate customerBirthDay;

    @NotBlank(message = "{empty.invalid}")
    private Integer customerGender;

    @Pattern(regexp = "\"^[1-9]\\\\d{8,11}$\"", message = "Identity card is not valid!")
    @NotBlank(message = "{empty.invalid}")
    private String customerIdCard;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",
            message = "The correct phone number format including 10 numbers!")
    @NotBlank(message = "{empty.invalid}")
    private String customerPhone;

    @Email(message = "The wrong email format, please re-enter!")
    @NotBlank(message = "{empty.invalid}")
    private String customerEmail;

    @Size(min = 5, max = 150, message = "{size.invalid}")
    @Pattern(regexp = "^[A-Za-z]+(?:\\\\s[A-Za-z]+)*$", message = "{character.invalid}")
    @NotBlank(message = "{empty.invalid}")
    private String customerAddress;

    public CustomerDto() {}

    public CustomerDto(Long customerId, String customerName, LocalDate customerBirthDay, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(LocalDate customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
