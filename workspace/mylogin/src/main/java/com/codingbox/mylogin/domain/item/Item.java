package com.codingbox.mylogin.domain.item;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {
	private Long id;
	private String itemName;
	private Integer price;	//null일 수 있다
	private Integer quantity; //null일 수 있다

	
	//기능추가
	private Boolean open;//판매여부
	private List<String> regions;//등록지역
	private ItemType itemType; //상품 종류
	private String deliveryCode;
	public Item() {
		super();
	}
	
	public Item(String itemName, Integer price, Integer quantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}
