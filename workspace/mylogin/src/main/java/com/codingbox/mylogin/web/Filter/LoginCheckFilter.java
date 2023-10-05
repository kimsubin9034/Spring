package com.codingbox.mylogin.web.Filter;

import java.io.IOException;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PatternMatchUtils;

import com.codingbox.mylogin.web.session.SessionConst;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();

		HttpServletResponse httpResponse = (HttpServletResponse) response;

		try {
			System.out.println("인증 체크 필터 시작: " + requestURI);
			if (isLoginCheckPath(requestURI)) {
				System.out.println("인증 체크 로직 실행 : " + requestURI);
				HttpSession session = httpServletRequest.getSession(false);

				if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
					System.out.println("미인증 사용자 요청 : " + requestURI);
					// 로그인 redirect
					httpResponse.sendRedirect("/login?redirectURL" + requestURI);
					return; // 미인증 사용자는 다음으로 진행하지 않고 여기서 끝!
				}
			}
		chain.doFilter(request, response);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("인증 체크 필터 종료 : " + requestURI);
		}
	}



	/*
	 * 화이트 리스트의 경우 인증 체크 x simpleMatch : 어떤 문자열이 특정 패턴에 매칭되는지를 검사
	 */
	private boolean isLoginCheckPath(String requestURI) {
		return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
	}

	private static final String[] whitelist = { "/", "/members/add", "/login", "/logout", "/css/*" };

}
