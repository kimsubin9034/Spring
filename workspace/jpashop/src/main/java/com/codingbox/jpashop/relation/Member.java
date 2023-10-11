package com.codingbox.jpashop.relation;

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
	@Setter(value = AccessLevel.NONE)	//lombok에서 자동 setter를 막는다
	private Team team;
	
	//일반적인 setter의 형태가 아니면 메서드 이름을 바꿔준다.
	//추후 코드를 봤을 때 단순 setter 작업이 아닌 중요한 작업을 진행하는지를 파악할 수 있다.
	public void changeTeam(Team team) {
		this.team = team;
		//this : 나 자신의 인스턴스(객체)
		team.getMember().add(this);
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
