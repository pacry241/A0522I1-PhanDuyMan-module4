package com.example.md4_case_study.dto.contract;

import com.example.md4_case_study.model.contract.Contract;
import com.example.md4_case_study.model.customer.Customer;
import com.example.md4_case_study.model.employee.Employee;
import com.example.md4_case_study.model.service.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContractDto implements Validator {
    @Pattern(regexp = "\"^CT-\\\\d{4}$\"", message = "Contract code is not valid!")
    private Long contractId;
    private LocalDateTime contractStartDate;
    private LocalDateTime contractEndDate;
    private Double contractDeposit;
    private Double contractTotalMoney;

    private Employee employee;
    private Service service;
    private Customer customer;

    public ContractDto() {}

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public LocalDateTime getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDateTime contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDateTime getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDateTime contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        LocalDateTime now = LocalDateTime.now();
        if (contract.getContractStartDate() == null) {
            errors.rejectValue("contractStartDate", "startDate.empty");
        } else if (contract.getContractStartDate().compareTo(now) < 0) {
            errors.rejectValue("contractStartDate", "startDate.past");
        }

        if (contract.getContractEndDate() == null) {
            errors.rejectValue("contractEndDate", "endDate.empty");
        } else if (contract.getContractEndDate().compareTo(now) < 0) {
            errors.rejectValue("contractEndDate", "endDate.past");
        }
    }
}
