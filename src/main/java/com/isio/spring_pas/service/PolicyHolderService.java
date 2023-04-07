package com.isio.spring_pas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.isio.spring_pas.Validation.InputValidation;
import com.isio.spring_pas.entities.CustomerAccount;
import com.isio.spring_pas.entities.PolicyHolder;
import com.isio.spring_pas.repository.CustomerAccountRepository;
import com.isio.spring_pas.repository.PolicyHolderRepository;
import com.isio.spring_pas.requestForm.RequestPolicyHolder;

@Service
public class PolicyHolderService {

    @Autowired
    PolicyHolderRepository policyHolderRepository;

    @Autowired
    CustomerAccountRepository customerAccountRepository;

    InputValidation inputValidator;

    @GetMapping
    public List<PolicyHolder> getPolicyHolder() {
        return policyHolderRepository.findAll();
    }

    public List<PolicyHolder> getPolicyHolderByAccountNumber(CustomerAccount customerAccount) {

        List<PolicyHolder> policyHolderList = policyHolderRepository
                .policyHolderList(customerAccount.getAccountNumber());

        return policyHolderList;
    }

    public void savePolicyHolder(PolicyHolder policyHolder) {

        policyHolderRepository.save(policyHolder);
    }

    public PolicyHolder isPolicyHolderExist(RequestPolicyHolder policyHolder) {

        PolicyHolder policyHolderOptional = policyHolderRepository.isPolicyHolderExist(
                policyHolder.firstName.toUpperCase(), policyHolder.lastName.toUpperCase(), policyHolder.accountNumber);

        if (policyHolderOptional.equals(null)) {

            throw new IllegalStateException("POLICY HOLDER ");
        }

        return policyHolderOptional;
    }

    public String policyHolderValidator(RequestPolicyHolder policyHolder) {

        String errorMessage = "";

        if (policyHolder.firstName.equals("")) {
            errorMessage += "FIRST NAME CANT BE NULL \n";
        }

        if (policyHolder.lastName.equals("")) {
            errorMessage += "LAST NAME CANT BE NULL \n";
        }

        if (policyHolder.address.equals("")) {
            errorMessage += "ADDRESS CANT BE NULL \n";
        }

        if (policyHolder.licenseNumber.equals("")) {
            errorMessage += "LICENSE CANT BE NULL \n";
        }

        // try {

        // if
        // (LocalDate.now().minusYears(16).isAfter(LocalDate.parse(policyHolder.birthdate)))
        // {
        // errorMessage += "POLICY HOLDER SHOULD BE ATLEAST 16 YRS OLD <br>";
        // } else if (LocalDate.parse(policyHolder.birthdate).isAfter(LocalDate.now()))
        // {
        // errorMessage += "BIRTHDATE CANT BE FUTURE DATE <br>";
        // }

        // } catch (Exception e) {
        // errorMessage += "BIRTHDATE CANT BE NULL <br>";
        // }

        // try {

        // if
        // (LocalDate.parse(policyHolder.licenseNumberIssued).isAfter(LocalDate.now()))
        // {
        // errorMessage += "LICENSE ISSUE DATE CANT BE FUTURE DATE <br>";
        // }

        // } catch (Exception e) {
        // errorMessage += "LICENSE ISSUE DATE BE NULL <br>";
        // }

        return errorMessage;

    }

}
