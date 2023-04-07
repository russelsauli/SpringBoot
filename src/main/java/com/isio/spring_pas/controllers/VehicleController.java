package com.isio.spring_pas.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isio.spring_pas.entities.Policy;
import com.isio.spring_pas.entities.Vehicle;
import com.isio.spring_pas.requestForm.RequestVehicle;
import com.isio.spring_pas.service.VehicleService;


@RestController
@CrossOrigin
@RequestMapping
public class VehicleController {
    

    @Autowired
    VehicleService vehicleService;


   
    @PostMapping(path = "/pas/vehicle/validator")
    public String policyHolderList(@RequestBody RequestVehicle requestVehicle) {

       return  vehicleService.vehicleValidator(requestVehicle);
    }

    @PostMapping(path = "/pas/vehicle/setPremium")
    public double setPremiumChareged(@RequestBody RequestVehicle requestVehicle) {
        
       return  vehicleService.setPremiumCharged(requestVehicle);
    }

    @PostMapping(path = "/pas/vehicle/vehicleList")
    public List<Vehicle> vehicleList(@RequestBody Policy policy) {
        
       return  vehicleService.vehicleList(policy);
    }
    


  


}
