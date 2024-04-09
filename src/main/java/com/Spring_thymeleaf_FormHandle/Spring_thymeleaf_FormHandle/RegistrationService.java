package com.Spring_thymeleaf_FormHandle.Spring_thymeleaf_FormHandle;

import org.springframework.stereotype.Service;


public interface RegistrationService {
	
	
	void save(Registration registration);	
	Registration getById(Integer id);
	
	Registration findByEmailAndPassword(String email, String password);
    boolean isAdmin(String email, String password);


}
