package com.codingbox.jpashop;

import java.util.List;

import com.codingbox.jpashop.relation.Member;
import com.codingbox.jpashop.relation.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain03 {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
  
        
        tx.commit();
        em.close();
        emf.close();
    }

}