package com.isio.spring_pas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isio.spring_pas.entities.Policy;
import com.isio.spring_pas.entities.PolicyHolder;
import com.isio.spring_pas.service.PolicyService;

@RestController
@CrossOrigin
@RequestMapping

public class PolicyController {
    

    @Autowired
    PolicyService policyService;


    @PostMapping(path = "/pas/policyList")

    public List<Policy> policiesPolicyHolder (@RequestBody PolicyHolder policyHolder) {
       return policyService.policyList(policyHolder);
    }

    @PostMapping(path = "/pas/policy")
    public Policy searchPolicy (@RequestBody Policy policy) {
       return policyService.policyList(policy);
    }

}
