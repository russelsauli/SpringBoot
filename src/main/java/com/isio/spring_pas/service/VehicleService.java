package com.isio.spring_pas.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isio.spring_pas.Validation.BusinessRulesValidation;
import com.isio.spring_pas.Validation.InputValidation;
import com.isio.spring_pas.entities.Policy;
import com.isio.spring_pas.entities.Vehicle;
import com.isio.spring_pas.repository.VehicleRepository;
import com.isio.spring_pas.requestForm.RequestVehicle;

@Service
public class VehicleService {
    
    @Autowired
    VehicleRepository vehicleRepository;

    InputValidation inputValidator = new InputValidation();
    BusinessRulesValidation businessRuleValidation = new BusinessRulesValidation();


    
    public String vehicleValidator(RequestVehicle vehicle){

        String errorMessage="";
        Optional<Vehicle> vehicleExistOptional = vehicleRepository.isVehicleExist(vehicle.plateNumber);


        if(inputValidator.nullValidator(vehicle.plateNumber)==false){
            errorMessage="PLATE NUMBER CANT BE NULL";
        }

        if(vehicleExistOptional.isPresent()){

            errorMessage+="VEHICLE ALREADY HAD A ACTIVE POLICY";
        }

        if(inputValidator.nullValidator(vehicle.vehicleBrand)==false){
            errorMessage+="VEHICLE MAKER CANT BE NULL";
        }

        if(inputValidator.nullValidator(vehicle.vehicleModel)==false){
            errorMessage+="VEHICLE MODEL CANT BE NULL";
        }

        if(inputValidator.nullValidator(vehicle.vehicleYear)==false ){
            errorMessage+="YEAR CANT BE NULL";
        }

        if(inputValidator.nullValidator(vehicle.vehicleType)==false){
            errorMessage+="VEHICLE TYPE CANT BE NULL";
        }

        if(inputValidator.nullValidator(vehicle.fuelType)==false){
            errorMessage+="FUEL TYPE CANT BE NULL";
        }

        if(inputValidator.nullValidator(vehicle.purchasePrice)==false){
            errorMessage+="PURCHASE PRICE CANT BE NULL";
        }
        if(inputValidator.nullValidator(vehicle.color)==false){
            errorMessage+="COLOR CANT BE NULL";
        }


      return errorMessage;
    }

    public double setPremiumCharged(RequestVehicle vehicle){

        return businessRuleValidation.ratingEngine( vehicle);
    }

    public List<Vehicle> vehicleList(Policy policy){

        List<Vehicle> listOfVehicle=vehicleRepository.vehicleList(policy.getPolicyNumber());

        return listOfVehicle;
    }
    

    






}
