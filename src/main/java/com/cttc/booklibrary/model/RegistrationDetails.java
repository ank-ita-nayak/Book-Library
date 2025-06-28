package com.cttc.booklibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="registration_details")
@Data
public class RegistrationDetails {
	//registration_id, applicant_name, email_id, mobile_no, gender, dob, image_path, library_id, subscription_id
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registration_id")
	private Integer registrationId;
	
	@Column(name="applicant_name")
	private String applicantName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="image_path")
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name="library_id")
	private LibraryMaster libraryMaster;
	
	@ManyToOne
	@JoinColumn(name="subscription_id")
	private SubscriptionMaster subscriptionMaster;
	
	@Column(name="is_Deleted")
	private Integer isDeleted;
	


}
