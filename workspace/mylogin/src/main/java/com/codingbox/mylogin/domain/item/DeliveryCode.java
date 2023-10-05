package com.codingbox.mylogin.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 생성
//@NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성
public class DeliveryCode {
	
		/*
		 * FAST : 빠른배송
		 * NORMAL : 일반배송
		 * SLOW : 느린배송
		 * 
		 */
	
	private String code;
	private String displayName;
}
