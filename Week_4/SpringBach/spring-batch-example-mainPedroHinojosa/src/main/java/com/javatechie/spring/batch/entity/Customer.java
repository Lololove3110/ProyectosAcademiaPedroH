package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "Comercial_Name")
	private String comercialName;
	@Column(name = "Social_reason")
	private String socialReason;
	@Column(name = "Activity")
	private String activity;
	@Column(name = "Size")
	private String size;
	@Column(name = "Colony")
	private String colony;
	@Column(name = "Postal_Code")
	private String postalCode;
	@Column(name = "State")
	private String state;
	@Column(name = "City")
	private String city;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "Web_Page")
	private String webPage;
	@Column(name = "Max_People")
	private int maxPeople;


}
