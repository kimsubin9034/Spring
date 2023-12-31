package com.codingbox.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingbox.core.dto.MemberDTO;

@Controller
public class MemberController {
	
	
	@RequestMapping("Member")
	public String getMember(Model model) {
		MemberDTO memver = new MemberDTO(1, "자바학생", "010-1234-5678");
		model.addAttribute("member", memver);
		return "thymeleaf/member";
	}
}
