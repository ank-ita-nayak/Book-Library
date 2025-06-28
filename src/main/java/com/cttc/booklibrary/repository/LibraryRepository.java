package com.cttc.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cttc.booklibrary.model.LibraryMaster;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryMaster, Integer> {

}
