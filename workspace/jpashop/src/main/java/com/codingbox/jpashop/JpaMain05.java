package com.codingbox.jpashop;

import java.time.LocalDateTime;
import java.util.List;

import com.codingbox.jpashop.embed.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain05 {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Address addr = new Address("서울" , "강남" , "123");
        
        Member member = new Member();
        member.setUsername("user1");
        member.setAddress(addr);
        em.persist(member);
        
        // 기존 addr을 복사해서 새로운 객체를 만들어서 넣어줌
        Address copyAddr = new Address(addr.getCity(), addr.getStreet(),addr.getZipcode());
        
        
        
        Member member2 = new Member();
        member2.setUsername("user2");
        member2.setAddress(copyAddr);
        em.persist(member2);
        

        //user1사람의 city값이 newcity로 변경하고싶다
        //member.getAddress().setCity("newCity");
        
        Address addrNew = new Address("택배", "남양주", "풋살화"); 
        member.setAddress(addrNew);
        
        
        
        
        
        tx.commit();
        em.close();
        emf.close();
    }

}