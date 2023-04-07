package com.isio.spring_pas.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="claims")
public class Claims {

    @Id
    @Column(name="claimID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer claimID;

    @Column(name="claimNumber")
    private String claimNumber;

    @Column(name="accidentDescription")
    private String accidentDescription;

    @Column(name="damageDescription")
    private String damageDescription;

    @Column(name="estimateCost")
    private int estimateCost;

    @Column(name="accidentLocation")
    private String accidentLocation;


    @Column(name="accidentDate")
    private Date accidentDate;

    @Column(name="policyID")
    private Integer policyID;

   
    @ManyToOne
    @JoinColumn(name="policyID",insertable=false,updatable=false)
    private Policy policy;



 
}
