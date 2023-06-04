package com.example.md4_case_study.model.contract;

import com.example.md4_case_study.model.customer.Customer;
import com.example.md4_case_study.model.employee.Employee;
import com.example.md4_case_study.model.service.Service;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    @Column(name = "start_date", columnDefinition = "datetime")
    private LocalDateTime contractStartDate;
    @Column(name = "end_date", columnDefinition = "datetime")
    private LocalDateTime contractEndDate;
    @Column(name = "contract_deposit",columnDefinition = "double")
    private Double contractDeposit;
    @Column(name = "contract_total_money",columnDefinition = "double")
    private Double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employeeId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service serviceId;

    public Contract() {}

    public Contract(Long contractId, LocalDateTime contractStartDate, LocalDateTime contractEndDate, Double contractDeposit, Double contractTotalMoney) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
    }

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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }
}
