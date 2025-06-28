package com.cttc.booklibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cttc.booklibrary.model.LibraryMaster;
import com.cttc.booklibrary.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public List<LibraryMaster> getAllLibraryList() {
		// TODO Auto-generated method stub
		return libraryRepository.findAll();
	}

	@Override
	public LibraryMaster getSelectedLibrary(Integer lId) {
		// TODO Auto-generated method stub
		return libraryRepository.findById(lId).get();
	}

}
