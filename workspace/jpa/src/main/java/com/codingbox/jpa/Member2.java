package com.codingbox.jpa;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@SequenceGenerator(name="MEMBER_SEQ_GENERATOR",sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1 )
public class Member2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "MEMBER_SEQ_GENERATOR")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String username;
}
