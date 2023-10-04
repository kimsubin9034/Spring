package com.codingbox.mylogin.domain.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbox.mylogin.domain.member.Member;
import com.codingbox.mylogin.web.session.SessionConst;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class LoginController {
   
   private final LoginService loginService;

   // /login
   // login/loginForm
   // loginForm()
   
   @GetMapping("/login")
   public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
      return "login/loginForm";
   }
   
//   @PostMapping("/login")
   public String login(@ModelAttribute LoginForm form, Model model, RedirectAttributes redirectAttributes,
         HttpServletResponse response) {
      // login 가능한 사람인지 체크
      // 로그인 실패 -> login/loginForm
      // 로그인 성공 -> /
      Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
      if( loginMember == null ) {
         // 로그인 실패시
         model.addAttribute("msg", "로그인 실패");
         return "login/loginForm";
      }else {
         // 로그인 성공시
         Cookie idCookie = 
               new Cookie("memberId", String.valueOf(loginMember.getId()));
         response.addCookie(idCookie);
         redirectAttributes.addFlashAttribute("msg", "로그인성공");
         return "redirect:/";
      }
      
      
   }
   @PostMapping("/login")
   public String loginV2(@ModelAttribute LoginForm form, Model model, RedirectAttributes redirectAttributes,
         HttpServletRequest request) {
      // login 가능한 사람인지 체크
      // 로그인 실패 -> login/loginForm
      // 로그인 성공 -> /
      Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
      if( loginMember == null ) {
         // 로그인 실패시
         model.addAttribute("msg", "로그인 실패");
         return "login/loginForm";
      }else {
         // 로그인 성공시
         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
         HttpSession session = request.getSession();
         // 세션에 로그인 회원 정보 보관
         session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);         
         redirectAttributes.addFlashAttribute("msg", "로그인성공");
         return "redirect:/";
      }
      
      
   }
   
   // /logout
   // logout()
   // cookie 비워내기
//   @PostMapping("/logout")
   public String logout2(HttpServletResponse response, @CookieValue(name = "memberId", required = false) Cookie cookie) {
      if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return "redirect:/";
      } else {
         return "redirect:/";
      }
      
   }
   
//   @PostMapping("/logout")
   public String logout(HttpServletResponse response) {
      expireCookie(response, "memberId");
      return "redirect:/";
   }
   
   @PostMapping("/logout")
   public String logoutV2(HttpServletRequest request) {

	  HttpSession session = request.getSession(false);
	  if(session != null) {
		  session.invalidate();
	  }
	  
	  return "redirect:/";
   }
   
   private void expireCookie( HttpServletResponse response, String cookieName) {
      // 쿠키 만료
      Cookie cookie = new Cookie(cookieName, null);
      cookie.setMaxAge(0);
      response.addCookie(cookie);
   }
   
}