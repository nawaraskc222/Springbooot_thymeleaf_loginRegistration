package com.Spring_thymeleaf_FormHandle.Spring_thymeleaf_FormHandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationServiceImpl implements RegistrationService{

	
	
	
	  @Autowired
	  RegistrationRepository repo;
	
	@Override
	public void save(Registration registration) {
		// TODO Auto-generated method stub
		repo.save(registration);
	}

	@Override
	public Registration getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
