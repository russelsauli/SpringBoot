package com.isio.spring_pas.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="policyHolder")
public class PolicyHolder {

    @Id
    @Column(name="policyHolderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyHolderID;


    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="address")
    private String address;

    @Column(name="birthDate")
    private String birthdate;

    @Column(name="licenseNumber")
    private String licenseNumber;

    @Column(name="licenseNumberIssue")
    private Date licenseNumberIssued;

  
    @Column(name="customerAccountID")
    private Integer customerAccountID;


    @ManyToOne
    @JoinColumn(name="customerAccountID",insertable=false,updatable=false)
    private CustomerAccount customerAccount;

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    public Integer getPolicyHolderID() {
        return policyHolderID;
    }

    public void setPolicyHolderID(Integer policyHolderID) {
        this.policyHolderID = policyHolderID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseNumberIssued() {
        return licenseNumberIssued;
    }

    public void setLicenseNumberIssued(Date licenseNumberIssued) {
        this.licenseNumberIssued = licenseNumberIssued;
    }

    public Integer getCustomerAccountID() {
        return customerAccountID;
    }

    public void setCustomerAccountID(Integer customerAccountID) {
        this.customerAccountID = customerAccountID;
    }



    
    
}


