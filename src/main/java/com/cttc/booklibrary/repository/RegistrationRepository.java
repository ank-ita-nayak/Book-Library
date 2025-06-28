package com.cttc.booklibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cttc.booklibrary.model.RegistrationDetails;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationDetails, Integer>{

	@Query(value = "select * from registration_details where is_deleted = ?1 ",nativeQuery=true)

	List<RegistrationDetails> findAllByIsDeleted(int i);

}
