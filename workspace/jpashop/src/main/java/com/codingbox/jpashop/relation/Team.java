package com.codingbox.jpashop.relation;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Team {
   
   @Id
   @GeneratedValue
   @Column(name = "TEAM_ID")
   private Long id;
   private String name;

   @OneToMany(mappedBy = "team")
   private List<Member> member = new ArrayList<>();
   
   public void addMember(Member member) {
	   member.setTeam(this);
	   this.member.add(member);
   }

}
