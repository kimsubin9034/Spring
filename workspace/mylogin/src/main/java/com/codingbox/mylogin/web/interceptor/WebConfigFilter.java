package com.codingbox.mylogin.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfigFilter implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new LogInterceptor()).order(1)
									.addPathPatterns("/**")	//모든경로전체가능
									.excludePathPatterns("/css/**","/eroor"); //제외
	
		registry.addInterceptor(new LoginCheckInterceptor())
									.order(2)
									.addPathPatterns("/**")
									.excludePathPatterns("/", "/members/add" , "/logout" ,"login", "/css/**");
	
	
	}
}
