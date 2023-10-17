package com.codingbox.springprj.repository;

import com.codingbox.springprj.domain.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

	//회원이름
	private String memberName;
	//주문상태
	private OrderStatus orderStatus;
	
}
