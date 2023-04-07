package com.isio.spring_pas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isio.spring_pas.entities.CustomerAccount;
import com.isio.spring_pas.entities.PolicyHolder;
import com.isio.spring_pas.requestForm.RequestPolicyHolder;
import com.isio.spring_pas.service.PolicyHolderService;



@RestController
@CrossOrigin
@RequestMapping
public class PolicyHolderController {
    

    @Autowired
    PolicyHolderService policyHolderService;


    @PostMapping(path = "/pas/getPolicyHolderList")
    public List <PolicyHolder> policyHolderList(@RequestBody CustomerAccount customerAccount) {

       return  policyHolderService.getPolicyHolderByAccountNumber(customerAccount);
    }

    @PostMapping(path = "/pas/policyHolder/validator")
    public String policyHolderValidator(@RequestBody RequestPolicyHolder policyHolder){

        return policyHolderService.policyHolderValidator(policyHolder);
    }




  
    


}
