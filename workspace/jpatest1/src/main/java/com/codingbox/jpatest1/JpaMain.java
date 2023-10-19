package com.codingbox.jpatest1;

import java.time.LocalDateTime;

import com.codingbox.jpatest1.domain.Address;
import com.codingbox.jpatest1.domain.Member;
import com.codingbox.jpatest1.domain.Orders;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Member member = new Member();
			member.setMemberid("KIC");
			member.setName("코딩박스");
			Address address = new Address();
			address.setCity("서울");
			address.setStreet("강남역");
			address.setZipcode("12번");
			member.setAddress(address);

			em.persist(member);

			Orders order = new Orders();
			order.setMember(member);
			order.setOrderdate(LocalDateTime.now());
			order.setStatus("접수");

			em.persist(order);

			int orderCount = 10; 
			for (int i = 0; i < orderCount; i++) {
				Orders orders = new Orders();
				orders.setMember(member);
				orders.setOrderdate(LocalDateTime.now());
				orders.setStatus("접수");
				em.persist(orders);
			}

			tx.commit();

			Member savedMember = em.find(Member.class, member.getId());
			System.out.println("Member = " + savedMember);

			//id 출력
			for (int i = 1; i <= orderCount; i++) {
				Orders savedOrder = em.find(Orders.class, order.getId() + i);
				System.out.println("Id = Order [id=" + savedOrder.getId() + ", orderDate=" + savedOrder.getOrderdate()
						+ ", status=" + savedOrder.getStatus() + "]");
			}
			
			//order 출력
//			for (int i = 1; i <= orderCount; i++) {
//			    Orders savedOrder = em.find(Orders.class, order.getId() + i);
//			    System.out.println("Order = Order [id=" + savedOrder.getId() + ", orderDate=" + savedOrder.getOrderdate() +
//			            ", status=" + savedOrder.getStatus() + "]");
//			}

			
			
			
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace(); 
		} finally {
			em.close();
		}

		emf.close();
	}
}
