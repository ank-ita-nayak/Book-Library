package com.cttc.booklibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cttc.booklibrary.model.LibraryMaster;
import com.cttc.booklibrary.model.SubscriptionMaster;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionMaster, Integer> {



	List<SubscriptionMaster> findAllByLibraryMaster(LibraryMaster libraryMaster);





}
