package com.codingbox.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class OrderItem {
   
   @Id
   @GeneratedValue
   @Column(name = "ORDER_ITEM_ID")
   private Long id;
   private int orderprice;
   private int count;
   
   @ManyToOne
   @JoinColumn(name = "ORDER_ID")
   private Order order;
   
   @ManyToOne
   @JoinColumn(name = "ITEM_ID")
   private Item item;
   
   

}