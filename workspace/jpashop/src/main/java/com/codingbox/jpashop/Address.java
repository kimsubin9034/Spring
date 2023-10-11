package com.codingbox.jpashop;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Embeddable
public class Address {
	private String city;
	private String street;
	private String zipcode;
	
	
	
	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
	
	public Address() {}

	
	//setter 없앨거
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}
	
	
	
}
