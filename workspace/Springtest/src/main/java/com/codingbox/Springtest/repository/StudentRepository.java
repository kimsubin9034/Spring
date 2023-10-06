package com.codingbox.Springtest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingbox.Springtest.student.Student;

@Repository
public class StudentRepository {

	private static final Map<Long,Student> store = new HashMap<>();
	private static long sequence = 0L;
	
	public Student save(Student student) {
		student.setId(++sequence);
		store.put(student.getId(), student);
		return student;
	}
	
	public Student findByNum(Long studentId) {
		return store.get(studentId);
	}
	public List<Student> findAll() {
		return new ArrayList<Student>(store.values());
	}
	
	  public void update(Long studentId, Student updateParam) {
	      Student findStudent = findByNum(studentId);
	      findStudent.setStudentName(updateParam.getStudentName());
	      findStudent.setAge(updateParam.getAge());
	      findStudent.setSubject(updateParam.getSubject());
	      findStudent.setPhone(updateParam.getPhone());
	      findStudent.setAddr(updateParam.getAddr());
	   }
	public void clearStore() {
		store.clear();
	}
		
	}
	

