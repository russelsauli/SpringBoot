package com.isio.spring_pas.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isio.spring_pas.entities.CustomerAccount;

import com.isio.spring_pas.service.CustomerAccountService;


@RestController
@CrossOrigin
@RequestMapping

public class CustomerAccountController {

    @Autowired
    CustomerAccountService customerAccountService;

    @PostMapping(path = "/pas/customerAccount")
    public CustomerAccount saveCustomer (@RequestBody CustomerAccount customerAccount) {

       return customerAccountService.saveCustomer(customerAccount);
    }

    @PostMapping(path="/pas/searchCustomer")
    public CustomerAccount getCustomerDetails (@RequestBody CustomerAccount customerAccount) { 

        return customerAccountService.searchCustomerAccount(customerAccount);
    }
    
}
