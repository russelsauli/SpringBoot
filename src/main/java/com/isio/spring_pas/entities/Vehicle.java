package com.isio.spring_pas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
    
    @Id
    @Column(name="vehicleID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleID;

    @Column(name="maker")
    private String maker;

    @Column(name="model")
    private String model;

    @Column(name="year")
    private int year;

    @Column(name="vehiclType")
    private String vehiclType;

    @Column(name="fuelType")
    private String fuelType;

    @Column(name="purchasePrice")
    private Double purchasePrice;

    @Column(name="color")
    private String color;

    @Column(name="plateNumber")
    private String plateNumber;

    @Column(name="premiumCharged")
    private Double premiumCharged;

    @Column(name="policyID")
    private Integer policyID;

   
    @ManyToOne
    @JoinColumn(name="policyID",insertable=false,updatable=false)
    private Policy policy;

    public String getVehiclType() {
        return vehiclType;
    }

    public void setVehiclType(String vehiclType) {
        this.vehiclType = vehiclType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Double getPremiumCharged() {
        return premiumCharged;
    }

    public void setPremiumCharged(Double premiumCharged) {
        this.premiumCharged = premiumCharged;
    }

    public void setPolicyID(Integer policyID) {
        this.policyID = policyID;
    }

   



    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVehicl_type() {
        return vehiclType;
    }

    public void setVehicl_type(String vehicl_type) {
        this.vehiclType = vehicl_type;
    }

    public Double getPurchase_price() {
        return purchasePrice;
    }

    public void setPurchase_price(Double purchase_price) {
        this.purchasePrice = purchase_price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate_number() {
        return plateNumber;
    }

    public void setPlate_number(String plate_number) {
        this.plateNumber = plate_number;
    }

    public Double getPremium_charged() {
        return premiumCharged;
    }

    public void setPremium_charged(Double premium_charged) {
        this.premiumCharged = premium_charged;
    }

    public int getPolicyID() {
        return policyID;
    }

    public void setPolicyID(int policyID) {
        this.policyID = policyID;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

   

}
