package com.cttc.booklibrary.service;

import java.util.List;

import com.cttc.booklibrary.model.RegistrationDetails;

public interface RegistrationService {

	RegistrationDetails saveDetails(RegistrationDetails details);

	List<RegistrationDetails> getAllRegistration();

	RegistrationDetails getDetailsById(Integer regId);

	RegistrationDetails deleteDetails(RegistrationDetails toBeDeletedObj);

}
