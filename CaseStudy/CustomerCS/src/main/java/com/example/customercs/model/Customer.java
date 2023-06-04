package com.example.customercs.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "customer_name", columnDefinition = "varchar(50)")
    @NotBlank
    @Size(min = 3, max = 50)
    private String customerName;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonManagedReference --tranh lap tham chieu 1-n, n-1
    private Date dateOfBirth;

    @Column(name = "gender")
    private Integer customerGender;

    @Column(name = "identity_card")
    @NotBlank
    private String customerIdCard;

    @Column(name = "phong_number")
    @NotBlank
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")
    private String customerPhone;

    @Column(name = "email")
    @Email(message = "Please enter a valid e-mail address")
    private String customerEmail;

    @Column(name = "address")
    @Size(min = 5, max = 150)
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customerTypeId")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(Long customerId, String customerName, Date dateOfBirth, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        String name = customer.getCustomerName();
        if (name.equals("THE DUC")){
            errors.rejectValue("customerName","","Khong nhap THE Duc");
        }

        Date datePublish = customer.getDateOfBirth();
        boolean a = datePublish.after(new Date());

        if ( datePublish.after(new Date())) {
            errors.rejectValue("dateOfBirth", "", "Ngày xuất bản không đúng");
        }
    }
}

