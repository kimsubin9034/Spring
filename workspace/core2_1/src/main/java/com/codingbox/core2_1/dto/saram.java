package com.codingbox.core2_1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class saram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MySeq")
	@SequenceGenerator(name="MySeq", sequenceName = "SARAME_seq", allocationSize = 1)
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
