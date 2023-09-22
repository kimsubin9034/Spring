package com.example.core2.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity		// << jpa에서 관리하는 클래스라는뜻
public class Member {
	
	@Id		//jakarta 거로 가져와야함
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="mySeq")
	@SequenceGenerator(name="mySeq" , sequenceName = "member_seq" , allocationSize = 1)
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
	
}
