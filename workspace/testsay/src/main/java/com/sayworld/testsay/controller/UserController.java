package com.sayworld.testsay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	@GetMapping("/")
	public String MainPageController() {
		
		return "mainpage";
	}
}
