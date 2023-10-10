package com.codingbox.jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain04 {

	   public static void main(String[] args) {
		      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		      EntityManager em = emf.createEntityManager();
		      
		      EntityTransaction tx = em.getTransaction();
		      tx.begin();
		      
		      // 비영속 상태
		      Member2 member = new Member2();
//		      member.setId("ID_A");
		      member.setUsername("JPA_A");
		      
		      //영속 상태
		      em.persist(member);
		      
		      tx.commit();
		      em.close();
		      emf.close();

		   }


}
