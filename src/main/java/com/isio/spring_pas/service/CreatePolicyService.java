package com.isio.spring_pas.service;




import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.isio.spring_pas.entities.CustomerAccount;
import com.isio.spring_pas.entities.Policy;
import com.isio.spring_pas.entities.PolicyHolder;
import com.isio.spring_pas.entities.Vehicle;
import com.isio.spring_pas.repository.CustomerAccountRepository;
import com.isio.spring_pas.repository.PolicyHolderRepository;
import com.isio.spring_pas.repository.PolicyRepository;
import com.isio.spring_pas.repository.VehicleRepository;
import com.isio.spring_pas.requestForm.RequestCreatePolicy;
import com.isio.spring_pas.requestForm.RequestPolicy;

import com.isio.spring_pas.requestForm.RequestVehicle;


@Service
public class CreatePolicyService {
    
    @Autowired
    CustomerAccountRepository customerAccountRepository;

    @Autowired
    PolicyHolderRepository policyHolderRepository;

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    VehicleRepository vehichleRepository;

    public CreatePolicyService(){}

    public List<PolicyHolder> policyHolderListByAccountNumber(){

        return  policyHolderRepository.findAll();
    }


    public boolean customerAccountByAccountNumber(RequestPolicy requestCreatePolicy){

        System.out.println(requestCreatePolicy.accountNumber);

        Optional<CustomerAccount> customerAccountOptional = customerAccountRepository.findByAccountNumber(requestCreatePolicy.accountNumber);   

        if(customerAccountOptional.isPresent()==false){

            throw new IllegalStateException("ACCOUNT NUMBER NOT EXIST");
        }

        return customerAccountOptional.isPresent();
    }

   

    @GetMapping
    public List<Vehicle> vehicleList(){

        return vehichleRepository.findAll();
    }
    
    @GetMapping
    public List<PolicyHolder> policyHolderList(){

        return policyHolderRepository.findAll();
    }

    public void savePolicy(RequestCreatePolicy createPolicy) throws IllegalStateException{
   
        PolicyHolder policyHolder= new PolicyHolder();
        Policy policy = new Policy();
        Vehicle newVewhicke= new Vehicle();
       
        PolicyHolder policyHolderOptional = policyHolderRepository.isPolicyHolderExist(
            createPolicy.requestPolicyHolder.firstName.toUpperCase(),  createPolicy.requestPolicyHolder.lastName.toUpperCase(),  createPolicy.requestPolicyHolder.accountNumber);

    if (policyHolderOptional==null) {


        CustomerAccount customerAccountOptional = customerAccountRepository.findByAccountNumberReturn( createPolicy.requestPolicyHolder.accountNumber);

        policyHolder.setFirstName( createPolicy.requestPolicyHolder.firstName);
        policyHolder.setLastName( createPolicy.requestPolicyHolder.lastName);
        policyHolder.setAddress( createPolicy.requestPolicyHolder.address);
        policyHolder.setBirthdate( createPolicy.requestPolicyHolder.birthdate);
        policyHolder.setLicenseNumber( createPolicy.requestPolicyHolder.licenseNumber);
        policyHolder.setLicenseNumberIssued(null);
        policyHolder.setCustomerAccountID(customerAccountOptional.getCustomerAccountID());
        policyHolderRepository.save(policyHolder);  
    }
    else{
        policyHolder=policyHolderOptional;
    }

    System.out.println("asdasdasd"+ createPolicy.requestPolicyHolder.accountNumber);
    System.out.println("asdasdasd"+ createPolicy.requestPolicy.effectiveDate);
    System.out.println("asdasdasd"+ createPolicy.requestVehicles.size());

    policy.setEffectiveDate(null);
    policy.setExpirationDate(null);
    policy.setIsClaimed(0);
    policy.setIsExpired(0);
    policy.setPolicyHolderID(policyHolder.getPolicyHolderID());
    policy.setPolicyNumber("123");
    policy.setPremium(2313.00);

    policyRepository.save(policy);

    


    for (RequestVehicle items : createPolicy.requestVehicles) {
        
       


        newVewhicke= new Vehicle();
     
        newVewhicke.setMaker(items.vehicleBrand);
        newVewhicke.setModel(items.vehicleModel);
        newVewhicke.setYear(items.vehicleYear);
        newVewhicke.setVehiclType(items.vehicleType);
        newVewhicke.setFuelType(items.fuelType);
        newVewhicke.setPurchasePrice(items.purchasePrice);
        newVewhicke.setColor(items.color);
        newVewhicke.setPlateNumber(items.plateNumber);
        newVewhicke.setPremiumCharged(items.premiumCharged);
        newVewhicke.setPolicyID(1);
        
        vehichleRepository.save(newVewhicke);

    }

    


    }



    

      
  

}
