package com.codingbox.jpashop.embed;

import java.time.LocalDateTime;

import com.codingbox.jpashop.Address;
import com.codingbox.jpashop.Period;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	@Id @GeneratedValue
	
	private Long id;
	private String username;
	
	
//	//기간
//	private LocalDateTime startDate;
//	private	LocalDateTime endDate;
	// @Embedded 와 Embeddable 둘중에 하나만 넣어도되는데
	// 둘다 넣는것을 권장
	@Embedded
	private Period period;
//	
//	//주소
	@Embedded
	private Address address;
//	private String city;
//	private String street;
//	private String zipcode;
	
	
//	//회사주소
//	@Embedded
//	@AttributeOverrides({
//	@AttributeOverride(name ="city" , column = @Column(name="WORK_CITY")),
//	@AttributeOverride(name ="street" , column = @Column(name="WORK_STREET")),
//	@AttributeOverride(name ="zipcode" , column = @Column(name="WORK_ZIPCODE")),
//	})
//	private Address workaddress;
	
	
	
	
	
	
	
//	private String city;
//	private String street;
//	private String zipcode;
	
}
