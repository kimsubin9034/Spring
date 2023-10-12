package com.codingbox.springprj.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {
	
	@Id
	@GeneratedValue
	@Column(name= "order_item_id")
	private Long id;
	
	private int orderPrice;
	private int count;

	@ManyToOne
	@JoinColumn(name= "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	
	
}
