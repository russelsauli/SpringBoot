package com.isio.spring_pas.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputValidation {
    

    public String dateValidator(String date){

        int year = 0, month = 0, day = 0;

        try{
        
            
            month = Integer.parseInt(date.substring(0, date.indexOf("-")));	// Concatenate the string and convert the parse value to int
			
            day = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"))); // Concatenate the string and convert the parse value to int
            
            year = Integer.parseInt(date.substring(date.lastIndexOf("-") + 1));	// Concatenate the string and convert the parse value to int
    
            date = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(month, day,year));	// formatting or setting a date and giving its value to string
    
        }
        catch(Exception e){

            date="DATE CANT BE NULL";
        }

        return date;

    }

    public boolean nullValidator(String inputs){

        boolean validateInput=false;
       
        try{

            if( inputs.length()>=1){
                validateInput=true;
            }
        }
        catch(Exception e){
            validateInput=false;
        }
        return validateInput;
    }

    public boolean nullValidator(Double inputs){

        boolean validateInput=false;
       
        try{

            if( inputs>0){
                validateInput=true;
            }
        }
        catch(Exception e){
            validateInput=false;
        }
        return validateInput;
    }

    public boolean nullValidator(int inputs){

        boolean validateInput=false;
       
        try{

            if( inputs>0){
                validateInput=true;
            }
        }
        catch(Exception e){
            validateInput=false;
        }
        return validateInput;
    }




}
