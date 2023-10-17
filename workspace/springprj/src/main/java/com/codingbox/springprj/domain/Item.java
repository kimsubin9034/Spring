package com.codingbox.springprj.domain;

import java.util.ArrayList;
import java.util.List;

import com.codingbox.springprj.exception.NotEnoughStockException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Item {
	
	@Id
	@GeneratedValue
    @Column(name = "item_id")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;
	
	public void removeStock(int count) {
		int restStock = this.stockQuantity - count;
			
		//재고 부족시 로직 처리
		if(restStock < 0) {
			// Exception 
			throw new NotEnoughStockException("need more stock");
		}
		
		this.stockQuantity = restStock;
	}

	public void addStock(int count) {
		this.stockQuantity += count;
	}
	
	
}
