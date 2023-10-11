package com.codingbox.jpashop;

import java.util.List;

import com.codingbox.jpashop.relation.Member;
import com.codingbox.jpashop.relation.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team = new Team();
        team.setName("지허이");

        //영속상태가 되면 PK의 값이 세팅 된 후에 영속상태가 된다.
        em.persist(team);

        Member member = new Member();
        member.setUsername("말랑이");
        //member.setTeamId(team.getId());
        //member.setTeam(team);
        em.persist(member);

        //조회
//        Member findMember = em.find(Member.class, member.getId());
//        Long findTeamId = findMember.getTeamId();
//        Team findTeam = em.find(Team.class, findTeamId);
//        System.out.println("findTeam : "+ findTeam.getName());


        //강제로 DB쿼리를 보고싶을때
        em.flush();
        em.clear();
        
        
        
        //어느팀 소속인 지 알고 싶을 때 확인,그 멤버가 어느팀 소속인지 소속이름을 알고싶을때 확인
      Member findMember = em.find(Member.class, member.getId());
      Team findTeam = findMember.getTeam();
      System.out.println("findTeam : "+ findTeam.getName());
        
      // 양방향 매핑
      Member findsideMember = em.find(Member.class, member.getId());
      List<Member> members  = findsideMember.getTeam().getMember();
      
      for(Member m : members) {
    	  System.out.println("result = " + m.getUsername());
    	  
      }
        tx.commit();
        em.close();
        emf.close();
    }

}