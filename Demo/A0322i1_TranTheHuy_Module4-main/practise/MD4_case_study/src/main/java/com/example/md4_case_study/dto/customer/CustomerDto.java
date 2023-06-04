package com.example.md4_case_study.dto.customer;

import com.example.md4_case_study.model.customer.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CustomerDto implements Validator {
    @Pattern(regexp = "\"^KH-\\\\d{4}$\"", message = "Customer code is not valid!")
    private Long customerId;
    @NotBlank(message = "{empty.invalid}")
    @Size(min = 3, max = 45, message = "{size.invalid}")
    @Pattern(regexp = "^[A-Za-z]+(?:\\\\s[A-Za-z]+)*$", message = "{special.invalid}")
    private String customerName;
    @NotBlank(message = "{empty.invalid}")
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
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "The wrong email format, please re-enter!")
    @NotBlank(message = "{empty.invalid}")
    private String customerEmail;
    @Size(min = 5, max = 120, message = "{size.invalid}")
    @Pattern(regexp = "^(?=.*[a-zA-Z0-9])[a-zA-Z0-9\\s]+(?:,\\s*[a-zA-Z0-9\\s]+)*$", message = "{special.invalid}")
    @NotBlank(message = "{empty.invalid}")
    private String customerAddress;

    public CustomerDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        LocalDate now = LocalDate.now();
        LocalDate eighteenYear = now.minusYears(18);
        LocalDate hundredYear = now.minusYears(100);
        if (customer.getCustomerBirthDay() == null) {
            errors.rejectValue("customerBirthDay", "empty.invalid");
        } else if (customer.getCustomerBirthDay().compareTo(eighteenYear) > 0 ||
                customer.getCustomerBirthDay().compareTo(hundredYear) < 0) {
            errors.rejectValue("customerBirthDay", "invalid");
        }

        if (customer.getCustomerGender() == null) {
            errors.rejectValue("customerGender", "empty.invalid");
        } else if (-1 > customer.getCustomerGender() || customer.getCustomerGender() > 1) {
            errors.rejectValue("customerGender", "gender.invalid");
        }

    }
}
