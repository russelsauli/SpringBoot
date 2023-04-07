package com.isio.spring_pas.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.isio.spring_pas.Validation.InputValidation;
import com.isio.spring_pas.entities.CustomerAccount;
import com.isio.spring_pas.repository.CustomerAccountRepository;

@Service
public class CustomerAccountService {
    

    @Autowired
    CustomerAccountRepository customerAccountRepository;

    InputValidation validatedata= new InputValidation();

    public CustomerAccountService(){}

    @GetMapping
    public List<CustomerAccount> getCustomers(){

        return customerAccountRepository.findAll();
    }


    public CustomerAccount saveCustomer(CustomerAccount customerAccount) {

        if( isCustomerExist(customerAccount)==true){

            throw new IllegalStateException("Customer Account Already Exist");
        }

        else if( validatedata.nullValidator( customerAccount.getFirstName() ) == true && 
            validatedata.nullValidator( customerAccount.getFirstName() ) == true  ) {
           
            customerAccount.setAccountNumber( generateAccountNumber() );
            customerAccountRepository.save(customerAccount);
        }
        return customerAccount;
    }

	public String generateAccountNumber() {

		Random random = new Random();

		Optional<CustomerAccount> customerAccountOptional;

		String accountNumber;

		do {
			
			accountNumber = Integer.toString(random.nextInt(9999));

			while (accountNumber.length() > 4) {

				accountNumber = "0" + accountNumber;
			}
			customerAccountOptional = customerAccountRepository.findByAccountNumber(accountNumber);

		} while (customerAccountOptional.isPresent());

		return accountNumber;
	}

    public Boolean isCustomerExist(CustomerAccount customerAccount) {
		
		Optional<CustomerAccount> customerAccountOptional = customerAccountRepository.isCustomerExist(customerAccount.getFirstName().toUpperCase(),customerAccount.getLastName().toUpperCase());

		return customerAccountOptional.isPresent() ;
	}



    public CustomerAccount searchCustomerAccount(CustomerAccount customerAccount){

        CustomerAccount customerAccountData = new CustomerAccount();

        CustomerAccount customerAccountService = customerAccountRepository.findByNameReturn( customerAccount.getFirstName(),customerAccount.getLastName());

        if(customerAccountService==null){
            throw new IllegalStateException("Customer not exist");
        }
        else{
            customerAccountData=customerAccountService;
        }

        return customerAccountData;
    }

}
