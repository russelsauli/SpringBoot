package com.isio.spring_pas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isio.spring_pas.entities.Vehicle;

@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle,Integer> {
    

   
     @Query("SELECT s FROM Vehicle s WHERE s.plateNumber =?1  AND s.policy.isExpired=0")
     Optional<Vehicle> isVehicleExist(String platNumber);


     @Query("SELECT s FROM Vehicle s WHERE s.policy.policyNumber =?1")
     List<Vehicle> vehicleList(String platNumber);

}
