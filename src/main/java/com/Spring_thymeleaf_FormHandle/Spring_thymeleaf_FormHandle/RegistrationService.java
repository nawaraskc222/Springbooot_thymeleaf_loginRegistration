package com.Spring_thymeleaf_FormHandle.Spring_thymeleaf_FormHandle;

import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {
	
	
	void save(Registration registration);
	
	Registration getById(Integer id);

}
