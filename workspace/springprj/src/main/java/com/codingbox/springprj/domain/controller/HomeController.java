package com.codingbox.springprj.domain.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
		//home화면
		// "/" , -> home.html
//	Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/")
	public String home() {
		log.info("home Controller");
		return "home";
	}

}
