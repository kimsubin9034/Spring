package com.codingbox.jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain03 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//비영속 상태
		Member member = new Member();
		member.setId(100L);
		member.setName("100user");
		
		
		//여기서부터 영속상태
		//EntitiyManager 안에있는 영속 컨텍스트에 관리가 된다는 뜻
		System.out.println("-----before---------");
		em.persist(member);			//insert 날아가나? 
		System.out.println("-----after---------");
		
		tx.commit();
		em.close();
		emf.close();
		
		
		
		
		
	}

}
