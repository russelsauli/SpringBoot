package com.isio.spring_pas.Validation;

import java.util.Calendar;

import com.isio.spring_pas.requestForm.RequestVehicle;

public class BusinessRulesValidation {
    
    public double ratingEngine(RequestVehicle requestVehicle) {	
		
		Calendar calendar = Calendar.getInstance();	

        if(requestVehicle.purchasePrice==null){
            requestVehicle.purchasePrice=0.00;
        }

		double vpf = 0;		

		int dlx ;
		
		dlx = Integer.parseInt(requestVehicle.licenseNumberIssued.substring(0, requestVehicle.licenseNumberIssued.indexOf("-")));	// substirng or getting  only the year of the license issued date using substring method and index of 

		dlx = calendar.get(Calendar.YEAR) - dlx;	// substrution of current year and the result of dlx

		// if dlx is less than 0 set to 1
		if (dlx <= 0) {	 
			dlx = 1;
		}

		int vehicleAge = calendar.get(Calendar.YEAR) - requestVehicle.vehicleYear;	//subtrang the curent year and the year
		
		if (vehicleAge <= 1) {
			vpf = 0.01;
		} else if (vehicleAge <= 3) {
			vpf = 0.008;
		} else if (vehicleAge <= 5) {
			vpf = 0.007;
		} else if (vehicleAge <= 10) {
			vpf = 0.006;
		} else if (vehicleAge <= 15) {
			vpf = 0.004;
		} else if (vehicleAge <= 20) {
			vpf = 0.002;
		}

		else if (vehicleAge <= 40) {
			vpf = 0.001;
		}
		
		else if(vehicleAge>=40) {
			vpf = 0.001;
		}

		requestVehicle.premiumCharged=(requestVehicle.purchasePrice * vpf) + ((requestVehicle.purchasePrice  / 100) / dlx);	// set premiumcharge;
		
		requestVehicle.premiumCharged=(Math.round(requestVehicle.premiumCharged* 100.0) / 100.0); // set premiumcharge 2 deciamal point;
		
		return  requestVehicle.premiumCharged;
	}

   
}
