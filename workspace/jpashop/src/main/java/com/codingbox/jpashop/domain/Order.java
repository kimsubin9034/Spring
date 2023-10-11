package com.codingbox.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name= "MEMBER_ID")
	private Member member;
	
	
	private LocalDateTime orderDate;
	private String status;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public void addOrderItem(OrderItem orderitem) {
		orderitem.setOrder(this);
		this.orderItem.add(orderitem);
	}
	
	
}
