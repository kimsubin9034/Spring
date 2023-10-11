package com.codingbox.jpashop;

import java.util.List;

import com.codingbox.jpashop.relation.Member;
import com.codingbox.jpashop.relation.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain02 {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //양방향 매핑시에 가장 많이하는 실수 
//        Member member = new Member();
//        member.setUsername("member1");
//        em.persist(member);
//        
//        Team team = new Team();
//        team.setName("TeamA");
//        team.getMember().add(member);
//        em.persist(team);
        
        //수정된 내용
        Team team = new Team();
        team.setName("TeamB");
        em.persist(team);
        
        Member member = new Member();
        member.setUsername("member2");
        //member.setTeam(team); 	//연관관계 주인에게 값 설정
        //member.changeTeam(team);
        em.persist(member);
        
        team.addMember(member);		//1에 넣기
        
        
        //team.getMember().add(member);
        
        //em.flush();  em.clear(); 주석처리 = 영속성 컨텍스트 영역을 사용하겠다라는 뜻
//        em.flush();
//        em.clear();
        
        System.out.println("----------------------------------");
        Team findTeam = em.find(Team.class, team.getId());
        List<Member> members = findTeam.getMember();
        
        for(Member m : members) {
        	System.out.println("m : " + m.getUsername());
        }
        
        System.out.println("----------------------------------");
        
        
        
        tx.commit();
        em.close();
        emf.close();
    }

}