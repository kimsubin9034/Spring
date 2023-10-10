package com.codingbox.jpa;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Member {

		@Id
		private Long id;
		@Column(unique = true, length= 10)
		private String name;
		@Column(name= "myage")
		private int age;
		
		
		//날짜 타입 매핑
		@Temporal(TemporalType.DATE)
		private Date createDate;
		
		@Temporal(TemporalType.DATE)
		private Date lastModifDate;
		
		//매핑 무시
		@Transient
		private int temp;
}
