package com.isio.spring_pas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.isio.spring_pas.entities.Vehicle;
import com.isio.spring_pas.requestForm.RequestCreatePolicy;
import com.isio.spring_pas.requestForm.RequestPolicy;


import com.isio.spring_pas.service.CreatePolicyService;


@RestController
@CrossOrigin
@RequestMapping
public class CreatePolicy {
    

    @Autowired
    CreatePolicyService createPolicyService;


    @PostMapping(path="/pas/customer_account")
    public void findCustomerAccountNumber (@RequestBody RequestPolicy requestCreatePolicy) {

        createPolicyService.customerAccountByAccountNumber(requestCreatePolicy);
    }

    @GetMapping(path = "/pas/getCustomers")
    public List <Vehicle> vehicleList() {

       return  createPolicyService.vehicleList();
    }


    @PostMapping(path="/pas/savePolicy")
    public void vehicleExist (@RequestBody RequestCreatePolicy createPolicy) {
        
        createPolicyService.savePolicy(createPolicy);
        
    }

   
   








   
    
}
