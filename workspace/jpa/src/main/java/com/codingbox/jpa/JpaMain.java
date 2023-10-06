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
		tx.begin();
		Member member = new Member();
		
		
		//추가
		member.setId(7L);
		member.setName("UserC");
		
		//회원 조회
		Member findMember = em.find(Member.class, 3L);
		System.out.println("findMember : " + findMember.getId());
		System.out.println("findMember : " + findMember.getName());
		
		//회원 수정
		findMember.setName("SuperUser");
		
		//회원삭제
		em.remove(findMember);
		
		em.persist(member);
		
		tx.commit();
		
		
		em.close();
		emf.close();
		
		
		
		
		
	}

}
