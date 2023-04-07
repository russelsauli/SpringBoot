package com.isio.spring_pas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.isio.spring_pas.entities.Claims;

@Repository
public interface ClaimRepository extends JpaRepository<Claims, Integer> {

    @Query("SELECT s FROM Claims s WHERE s.claimNumber =?1")
    Claims searchClaimNumber(String claimNumber);

    @Query("SELECT s FROM Claims s WHERE s.policy.policyNumber =?1")
    List<Claims> listOfClaim(String policyNumber);

    @Query("SELECT s FROM Claims s WHERE s.claimNumber =?1")
    Optional<Claims> isClaimNumber(String claimNumber);
}
