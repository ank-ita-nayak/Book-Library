package com.cttc.booklibrary.service;

import java.util.List;

import com.cttc.booklibrary.model.SubscriptionMaster;

public interface SubscriptionService {

	List<SubscriptionMaster> getAllSubscriptionList();

	List<SubscriptionMaster> getSubscriptionListByLibId(Integer lId);

	SubscriptionMaster getSelectedSub(Integer subId);

}
