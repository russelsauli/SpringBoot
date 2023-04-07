package com.isio.spring_pas.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isio.spring_pas.entities.Policy;
import com.isio.spring_pas.entities.PolicyHolder;
import com.isio.spring_pas.repository.PolicyHolderRepository;
import com.isio.spring_pas.repository.PolicyRepository;

@Service
public class PolicyService {
    
    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    PolicyHolderRepository policyHolderRepository;




    public List<Policy> policyList(PolicyHolder policyHolder) {

        PolicyHolder policyHolderData =policyHolderRepository.isPolicyHolderExist(policyHolder.getFirstName(), policyHolder.getLastName(), policyHolder.getCustomerAccount().getAccountNumber());
        
        List<Policy> policyHolderList = policyRepository.perPolicyHolder(policyHolderData.getPolicyHolderID());

        return policyHolderList;
    }

    public Policy policyList(Policy policy) {

        Policy policyInformation = policyRepository.findPolicyNumber(policy.getPolicyNumber());

        if(policyInformation==null){
            throw new IllegalStateException("Policy Number Number Not Exist");
        }
        return policyInformation ;
    }

    
}
