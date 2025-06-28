package com.cttc.booklibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cttc.booklibrary.model.RegistrationDetails;
import com.cttc.booklibrary.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	RegistrationRepository registrationRepository;
	@Override
	public RegistrationDetails saveDetails(RegistrationDetails details) {
		
		return registrationRepository.save(details);
	}
	@Override
	public List<RegistrationDetails> getAllRegistration() {
	
		return registrationRepository.findAllByIsDeleted(0);
	}
	@Override
	public RegistrationDetails getDetailsById(Integer regId) {
		// TODO Auto-generated method stub
		return registrationRepository.findById(regId).get();
	}
	@Override
	public RegistrationDetails deleteDetails(RegistrationDetails toBeDeletedObj) {
		// TODO Auto-generated method stub
		
		toBeDeletedObj.setIsDeleted(1);
		
		return registrationRepository.save(toBeDeletedObj);
	}
	

}
