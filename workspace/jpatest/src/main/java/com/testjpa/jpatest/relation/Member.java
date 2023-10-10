package com.testjpa.jpatest.relation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	
	@Id
	@GeneratedValue
	@Column(name= "MEMBER_ID")
	private Long id;
//	@Column(name="TEAM_ID")
//	private String TeamId;
	private String username;
	
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;
}
