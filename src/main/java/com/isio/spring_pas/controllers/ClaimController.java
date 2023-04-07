package com.isio.spring_pas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isio.spring_pas.entities.Claims;
import com.isio.spring_pas.entities.Policy;
import com.isio.spring_pas.service.ClaimService;

@RestController
@CrossOrigin
@RequestMapping
public class ClaimController {
    
    @Autowired
    ClaimService claimService;


    @PostMapping(path="/pas/claim/claimsSearch")
    public Claims findCustomerAccountNumber (@RequestBody Claims claims) {

       return  claimService.searchClaimNumber(claims);
    }

    @PostMapping(path="/pas/claim/claimList")
    public List<Claims> findCustomerAccountNumber (@RequestBody Policy policy) {

      return  claimService.searchPolicyClaims(policy);
    }

    @PostMapping(path="/pas/claim/saveClaim")
    public Claims saveClaim (@RequestBody Claims claim) {
        return  claimService.saveClaim(claim);
    }
}
