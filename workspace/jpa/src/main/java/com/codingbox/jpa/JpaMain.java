package com.codingbox.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Member member = new Member();
		
		
		//추가
		member.setId(1L);
		member.setName("UserA");
		
		
		em.persist(member);
		
		
		tx.commit();
		
		
		em.close();
		emf.close();
		
		
		
		
		
	}

}
