package com.isio.spring_pas.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isio.spring_pas.entities.Claims;
import com.isio.spring_pas.entities.Policy;
import com.isio.spring_pas.repository.ClaimRepository;
import com.isio.spring_pas.repository.PolicyRepository;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    PolicyRepository policyRepository;


    public Claims searchClaimNumber(Claims claims){
        Claims claimsData =claimRepository.searchClaimNumber(claims.getClaimNumber());

        return claimsData;
    }

    public List<Claims> searchPolicyClaims(Policy policy){
        List<Claims> listOfClaims =claimRepository.listOfClaim(policy.getPolicyNumber());

        return listOfClaims;
    }

    public Claims saveClaim(Claims claims){

        Random rand = new Random();

        String generateClaimNumber="";

        int randomNumber; 

        do{

            randomNumber = rand.nextInt(100000);
            generateClaimNumber=String.valueOf(randomNumber);

            while(generateClaimNumber.length()!=5){
                
                generateClaimNumber="0"+generateClaimNumber;
            }
    
            generateClaimNumber="C"+generateClaimNumber;

        }while(claimRepository.isClaimNumber(generateClaimNumber).isPresent());

        claims.setClaimNumber(generateClaimNumber);
    
       return claimRepository.save(claims);
    }



   

}
