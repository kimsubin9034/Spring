package com.codingbox.mylogin.web.Filter;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;


public class LogFilter implements Filter{

   /*
    * ServletRequest :
    *   - HTTPServletRequest의 부모 클래스
    *   - 기능이 많이 없어서 HTTPServletRequest로 다운 캐스팅 해서 사용
    */
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
      
      HttpServletRequest httpRequest
         = (HttpServletRequest)request;
      String requestURI = httpRequest.getRequestURI();
      String uuid = UUID.randomUUID().toString();   // 요청 구분하기 위해
      
      try {
         System.out.println("uuid "+ uuid);
         System.out.println("requestURI : " + requestURI);
         chain.doFilter(request, response);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         System.out.println("uuid "+ uuid);
         System.out.println("requestURI : " + requestURI);
      }
      
   }

}