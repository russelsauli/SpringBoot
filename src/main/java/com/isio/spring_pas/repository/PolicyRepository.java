package com.isio.spring_pas.repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.isio.spring_pas.entities.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Integer> {
    

    @Query("SELECT s FROM Policy s WHERE  s.policyNumber=?1")
	Policy findPolicyNumber(String policyNumber);

    @Query("SELECT s FROM Policy s WHERE  s.policyHolderID=?1")
	List<Policy> perPolicyHolder(int policyHolderID);

   

}
