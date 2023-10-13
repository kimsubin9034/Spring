package com.codingbox.springprj.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingbox.springprj.domain.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
	
	
	private final EntityManager em;
//	@Autowired
//	private final EntityManager em;
//	
//	public void save(Item item) {
//		em.persist(item);
//	}
//	
//	
//	public List<Item> findByname(String name) {
//		
//		return em.createQuery("")
//					.setParameter(0, name)
//					.getResultList();
//	}
	
	//저장
	//void, save()
	public void save(Item item) {
		em.persist(item);
	}

	// return type :arrayList
	// jpql 
	//메서드 이름 :findAll()
	 public List<Item> findAll() {
	        return em.createQuery("select i from Item i" , Item.class).getResultList();
	    }
	public List<Item> findByname(String name){
		return em.createQuery("SELECT i FROM Item i where i.name =:name" ,Item.class)
					.setParameter("name", name).getResultList();
	
	}
	
}
