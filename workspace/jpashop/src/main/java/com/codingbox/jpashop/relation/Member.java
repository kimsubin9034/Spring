package com.codingbox.jpashop.relation;

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
public class Member {
	
	@Id 
	@GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
//	@Column(name="TEAM_ID")
//	private Long teamId;
	private String username;
	
	
	
	/*
	 * 1대다의 개념을 객체에게 알려야하는데,
	 * DB기준으로 1대다의 개념을 알려줘야한다.
	 * @ManyToOne : 여기선 Team 이 하나다.
	 * @JoinColumn(name ="TEAM_ID") : 관계 컬럼을 적어준다. TEAM_ID와 조인해야한다.
	 */
	@ManyToOne
	@JoinColumn(name= "TEAM_ID")
	private Team team;
	
	
}
