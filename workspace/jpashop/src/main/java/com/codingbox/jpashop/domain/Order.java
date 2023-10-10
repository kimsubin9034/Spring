package com.codingbox.jpashop.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	@Column(name="MEMBER_ID")
	private Long memberId;
	private LocalDateTime orderDate;
	private String status;
	
	
	
	
}
