package com.isio.spring_pas.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customerAccount")

public class CustomerAccount {
    
    @Id
    @Column(name="customerAccountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerAccountID;

    @Column(name="accountNumber")
    private String accountNumber;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="address")
    private String address;

    public CustomerAccount(){}

    public CustomerAccount(Integer customerAccountID, String accountNumber, String firstName, String lastName,
            String address) {
        this.customerAccountID = customerAccountID;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="customerAccountID")
    private Set<PolicyHolder> policyHolder;
   
    public Set<PolicyHolder> getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(Set<PolicyHolder> policyHolder) {
        this.policyHolder = policyHolder;
    }

    public Integer getCustomerAccountID() {
        return customerAccountID;
    }

    public void setCustomerAccountID(Integer customerAccountID) {
        this.customerAccountID = customerAccountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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


}
