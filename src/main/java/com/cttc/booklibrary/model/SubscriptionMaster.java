package com.cttc.booklibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="subscription_master")
public class SubscriptionMaster {
	//subscription_id, subscription_type, library_id, fees
	
	@Id
	@Column(name="subscription_id")
	private Integer subscriptionId;
	
	@Column(name="subscription_type")
	private String subscriptionType;
	
	@Column(name="fees")
	private Double fees;
	
	@ManyToOne
	@JoinColumn(name="library_id")
	private LibraryMaster libraryMaster;
	

}
