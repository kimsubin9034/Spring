package com.codingbox.mylogin.web.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;

//@Configuration
public class WebConfig {
	
//	   @Bean
	   public FilterRegistrationBean logfilter() {
	      FilterRegistrationBean<Filter> filterRegistrationBean
	         = new FilterRegistrationBean<>();
	      // 내가 방금 반든 LogFilter를 등록하는 과정
	      filterRegistrationBean.setFilter(new LogFilter());
	      filterRegistrationBean.setOrder(1);
	      filterRegistrationBean.addUrlPatterns("/*");   // 모든 URL
	      return filterRegistrationBean;
	   }

//	   @Bean
	   public FilterRegistrationBean loginCheckFilter() {
	      FilterRegistrationBean<Filter> filterRegistrationBean
	         = new FilterRegistrationBean<>();
	      // 내가 방금 반든 LogFilter를 등록하는 과정
	      filterRegistrationBean.setFilter(new LoginCheckFilter());
	      filterRegistrationBean.setOrder(2);
	      filterRegistrationBean.addUrlPatterns("/*");   // 모든 URL
	      return filterRegistrationBean;
	   }

}
