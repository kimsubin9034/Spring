package com.codingbox.core2_1.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codingbox.core2_1.dto.saram;

import jakarta.persistence.EntityManager;

@Repository
public class JpaMemberRepository implements MemberRepository{

	private final EntityManager em;
	
	public JpaMemberRepository(EntityManager em) {
		this.em=em;
	}
	
	@Override
	public saram save(saram member) {
		em.persist(member);
		return member;
	}

	@Override
	public List<saram> findAll() {
	    return em.createQuery("select s from saram s", saram.class).getResultList();
	}


}
