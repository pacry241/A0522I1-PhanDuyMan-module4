package com.example.md4_case_study.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;
    @Column(name = "quantity")
    private Integer contractDetailQuantity;

    @ManyToOne
    @JoinColumn(name = "contractId")
    private Contract contractId;

    @ManyToOne
    @JoinColumn(name = "attachServiceId")
    private AttachService attachServiceId;

    public ContractDetail() {}

    public ContractDetail(Long contractDetailId, Integer contractDetailQuantity) {
        this.contractDetailId = contractDetailId;
        this.contractDetailQuantity = contractDetailQuantity;
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getContractDetailQuantity() {
        return contractDetailQuantity;
    }

    public void setContractDetailQuantity(Integer contractDetailQuantity) {
        this.contractDetailQuantity = contractDetailQuantity;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(AttachService attachServiceId) {
        this.attachServiceId = attachServiceId;
    }
}
