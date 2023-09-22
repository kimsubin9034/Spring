package com.example.core2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core2.dto.Member;
import com.example.core2.repository.MemberRepository;
import com.example.core2.repository.MemoryMemberRepository;

import jakarta.transaction.Transactional;

//서비스 역할
@Service
@Transactional 
public class MemberService {
		
	//Service가 Repository를 의존한다 라고 표현함
	//MemoryMemberRepository memberRepository = new MemoryMemberRepository();
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	//회원가입
	public int join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}
	
	
	//전체회원조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
}
