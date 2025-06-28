package com.cttc.booklibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="library_master")
public class LibraryMaster {
	
	@Id
	@Column(name="library_id")
	private Integer libraryId;
	
	@Column(name="library_name")
	private String libraryName;
	
	

}
