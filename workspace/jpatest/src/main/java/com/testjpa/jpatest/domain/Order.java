package com.testjpa.jpatest.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	@Column(name="MEMBER_ID")
	private String memberid;
	private LocalDateTime orderdate;
	private String status;
}
