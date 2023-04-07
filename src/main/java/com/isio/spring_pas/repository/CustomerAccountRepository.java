package com.isio.spring_pas.repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.isio.spring_pas.entities.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Integer>{
    
     @Query("SELECT s FROM CustomerAccount s WHERE s.accountNumber =?1")
	 Optional<CustomerAccount> findByAccountNumber(String accountNumber);

	 @Query("SELECT s FROM CustomerAccount s WHERE s.accountNumber =?1")
	CustomerAccount findByAccountNumberReturn(String accountNumber);

	
		
	@Query("SELECT s FROM CustomerAccount s WHERE s.firstName =?1  AND s.lastName=?2")
	Optional<CustomerAccount> isCustomerExist(String firstName,String lastName);
	

	@Query("SELECT s FROM CustomerAccount s WHERE s.firstName =?1  AND s.lastName=?2")
	CustomerAccount findByNameReturn(String firstName,String lastName);
}
