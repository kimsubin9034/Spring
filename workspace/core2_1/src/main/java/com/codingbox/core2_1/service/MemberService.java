package com.codingbox.core2_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingbox.core2_1.dto.saram;
import com.codingbox.core2_1.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional 
public class MemberService {

	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public int join(saram member) {
		memberRepository.save(member);
		return member.getId();
	}
	
	public List<saram> findMembers(){
		return memberRepository.findAll();
	}
}
