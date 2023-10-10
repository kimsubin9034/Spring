package com.testjpa.jpatest;

import com.testjpa.jpatest.relation.Member;
import com.testjpa.jpatest.relation.Team;

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
       team.setName("나님");
       
       em.persist(team);
       
       Member member = new Member();
       member.setUsername("학교가기싫다");
       member.setTeam(team);
       
       em.persist(member);
       
       em.flush();
       em.clear();
       
       Member findMember = em.find(Member.class, member.getId());
       Team findTeam =findMember.getTeam();
       System.out.println("findTeam : " + findTeam.getName());
       
        
       
       
        tx.commit();
        em.close();
        emf.close();
    }

}