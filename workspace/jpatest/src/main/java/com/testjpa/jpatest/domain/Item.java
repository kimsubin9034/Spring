package com.testjpa.jpatest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	private String name;
	private String price;
	private String stockquantity;
	
}
