package com.isio.spring_pas.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "policy")
public class Policy {

    @Id
    @Column(name = "policyID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyID;

    @Column(name = "policyNumber")
    private String policyNumber;

    @Column(name = "effectiveDate")
    private Date effectiveDate;

    @Column(name = "expirationDate")
    private Date expirationDate;

    @Column(name = "premium")
    private Double premium;

    @Column(name = "policyHolderID")
    private Integer policyHolderID;

    @Column(name = "isClaimed")
    private int isClaimed;

    @Column(name = "isExpired")
    private int isExpired;

    @ManyToOne
    @JoinColumn(name = "policyHolderID", insertable = false, updatable = false)
    private PolicyHolder policyHolder;


    @JsonIgnore
    @OneToMany
    @JoinColumn(name="policyID")
    private Set<Vehicle> vehicle;

  

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getPolicyID() {
        return policyID;
    }

    public void setPolicyID(Integer policyID) {
        this.policyID = policyID;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Integer getPolicyHolderID() {
        return policyHolderID;
    }

    public void setPolicyHolderID(Integer policyHolderID) {
        this.policyHolderID = policyHolderID;
    }

    public Integer getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(Integer isClaimed) {
        this.isClaimed = isClaimed;
    }

    public Integer getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Integer isExpired) {
        this.isExpired = isExpired;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

}
