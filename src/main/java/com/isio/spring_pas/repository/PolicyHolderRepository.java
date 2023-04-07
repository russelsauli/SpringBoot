package com.isio.spring_pas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.isio.spring_pas.entities.PolicyHolder;

@Repository
public interface PolicyHolderRepository  extends JpaRepository<PolicyHolder,Integer>{


    @Query("SELECT s FROM PolicyHolder s WHERE  s.customerAccountID=?1")
	List<PolicyHolder> policyHolderByAccountNumber(Integer customerAccountID);

    @Query("SELECT s FROM PolicyHolder s WHERE s.firstName =?1  AND s.lastName=?2 AND s.customerAccount.accountNumber=?3")
	PolicyHolder isPolicyHolderExist(String firstName,String lastName,String accountNumber);

    @Query("SELECT s FROM PolicyHolder s WHERE s.customerAccount.accountNumber=?1")
	List<PolicyHolder> policyHolderList(String accountNumber);


   


}
