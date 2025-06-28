package com.cttc.booklibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cttc.booklibrary.model.LibraryMaster;
import com.cttc.booklibrary.model.SubscriptionMaster;
import com.cttc.booklibrary.repository.LibraryRepository;
import com.cttc.booklibrary.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public List<SubscriptionMaster> getAllSubscriptionList() {
		return subscriptionRepository.findAll();
	}


	@Override
	public List<SubscriptionMaster> getSubscriptionListByLibId(Integer lId) {
		LibraryMaster libraryMaster = libraryRepository.findById(lId).get();
		
		return subscriptionRepository.findAllByLibraryMaster(libraryMaster);
	}


	@Override
	public SubscriptionMaster getSelectedSub(Integer subId) {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(subId).get();
	}

}
