package com.isio.spring_pas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.isio.spring_pas.entities.CustomerAccount;
import com.isio.spring_pas.repository.CustomerAccountRepository;
import com.isio.spring_pas.service.CustomerAccountService;

@SpringBootTest
class SpringPasApplicationTests {

	@Autowired
	private CustomerAccountService customerAccount;

	
	@Test
	void contextLoads() {

		CustomerAccount data= new CustomerAccount();

		data.setAccountNumber("a");
		data.setFirstName("a");
		data.setLastName("a");
		data.setAddress("a");
	   
		assertEquals(true,customerAccount.isCustomerExist(data));


		
		

	}

}
