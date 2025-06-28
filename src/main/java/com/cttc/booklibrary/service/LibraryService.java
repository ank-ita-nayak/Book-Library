package com.cttc.booklibrary.service;

import java.util.List;

import com.cttc.booklibrary.model.LibraryMaster;

public interface LibraryService {

	List<LibraryMaster> getAllLibraryList();

	LibraryMaster getSelectedLibrary(Integer lId);

}
