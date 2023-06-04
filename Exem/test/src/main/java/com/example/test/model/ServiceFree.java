package com.example.test.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "service_free")
public class ServiceFree implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name="name_service")
    @NotBlank(message = "Ten khong de trong")
    private String nameService;

    @Column(name = "start_day")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDay;

    @Column(name = "end_day")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDay;

    @NotNull
    @Min(10000)
    private Long countDown;

    @NotNull
    private String descriptionFree;

    public ServiceFree() {
    }

    public ServiceFree(Long serviceId, String nameService, Date startDay, Date endDay, Long countDown, String descriptionFree) {
        this.serviceId = serviceId;
        this.nameService = nameService;
        this.startDay = startDay;
        this.endDay = endDay;
        this.countDown = countDown;
        this.descriptionFree = descriptionFree;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Long getCountDown() {
        return countDown;
    }

    public void setCountDown(Long countDown) {
        this.countDown = countDown;
    }

    public String getDescriptionFree() {
        return descriptionFree;
    }

    public void setDescriptionFree(String descriptionFree) {
        this.descriptionFree = descriptionFree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ServiceFree.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceFree serviceFree = (ServiceFree) target;
        Date date = new Date();
        Date start = serviceFree.startDay;
        Date endDay = serviceFree.endDay;
        if (start.before(date)){
            errors.rejectValue("startDay","", "Ngay bat dau khong hop le");
        }
//        if (endDay.compareTo( date) < 0 && endDay){
//            errors.rejectValue("endDay","","Ngay ket thuc phai lon hon ngay bat dau");
//        }
    }
}
