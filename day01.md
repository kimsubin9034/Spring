# 1.Framework란?
-'뼈대나 근간'을 이루는 코드들의 묶음
-프로그램의 기본 흐름이나 구조를 정하고, 이 구조에 자신의 코드를 추가하는 방식으로 개발할 수 있도록하는 프로그래밍의 기본 틀을 의미
-개발에 필요한 구조가 제공되고, 여기에 필요한 부분을 조립하는 형태로 개발이 진행된다.




# 2.라이브러리란?
-라이브러리란 자주 사용되는 조직을 재사용하기 편리하도록 잘 정리한 일련의 코드들의 집합


# 3.Framework vs 라이브러리
-프레임워크는 자동차의 프레임, 즉 기본적으로 구성하고 있는 뼈대를 말한다.
-라이브러리는 자동차의 기능을 하는 부품을 의미한다.
-한 번 정해진 자동차의 프레임은 바꿀 수 없다.
-소형차를 만들기 위해 뼈대를 사용하는데, 이 뼈대로 SUV를 만들 수 없다(Framework)
-그러나 바퀴나,선루프,헤드라이트 등은 비교적 다른 종류로 쉽게 교체가능(라이브러리)


# 4.Spring이란?
-스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고도부른다
-동적인 웹사이트를 개발하기 위한 여러가지 서비스를 제공하고 있다.

# 5.Spring vs Spring boot


# 6.Spring Boot 설정

## 6-1. Embed Tomcat
-스프링 부트는 내장형 톰캣을 가지고 있기 때문에 별도의 톰캣을 설정할 필요가 없어졌으며,
그렇기 때문에 독립적으로 실행가능한 jar로 손쉽게 배포가 가능해졌다.

## 6-2. AutoConfigurator
-공통적으로 필요한 DispatcherServlet 과 같은 설정을 어노테이션을 이용하여 대신할 수 있도록 해준다.
-스프링 부트의 main메서드는 @SpringBootApplication 어노테이션을 가지고있는데,
 이것은 COmponentScan + configuration + EnableAutoConfiguration 을 합친 어노테이션 이라고 볼 수 있다.

# 7.환경설정
-STStool 설치


# 8.프로젝트 세팅
-https://start.spring.io/

## 8-1. Project : 사용할 빌드 툴 선택(Maven/Gradle)
- Maven,Gradle은 프로젝트에 필요한 의존성을 관리하고 빌드의 라이프사이클을 관리해주는 툴이다.
과거에는 Maven , 최근에는 Gradle을 사용하는 추세이다.

## 8-2. Spring Boot : 버전선택
-SNAPSHOT이 붙은 것은 현재 개발중인 버전, M(Minor)은 정식 릴리즈 되지 않은 버전이고 아무것도 붙어있지 않은 것이 정식 릴리즈된 버전이다

** LTS
-> Long Term Support 
-> 오랜기간 지원될 버전 


9.DispatcherServlet
-스프링 MVC도 프론트 컨트롤러 패턴으로 구현되어 있다.
-스프링 MVC의 프론트 컨트롤러가 바로 디스패처 서블릿이다.
그리고 이 디스패처 서블릿이 바로 스프링 MVC의 핵심이다.
-DispatcherServlet도 부모 클래스에서 HttpServlet을 상속받아 사용하고, 서블릿으로 동작한다.
-DispatcherServlet -> FrameworkServlet
	-> HttpServletBean -> HttpServlet 


1.  프레임워크 흐름
- 핸들러 조회 : 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회한다.
- 핸들러 어댑터 조회 : 핸들러를 실행할 수 있는 핸들러 어댑터를 조회한다.
- 핸들러 어댑터 실행 : 핸들러 어댑터를 실행한다.
- ViewResolver호출 : 뷰리졸버를 찾고 실행한다.
-view 반환 : 뷰 리졸버는 뷰의 논리이름을 물리이름으로 바꾸고, 렌더링 역할을 담당하는 뷰 객체를 반환한다.
	->forward, redirect
	->기본방식 : forward방식이다.

1.  Model이란?
- Controller에서 데이터를 Model에 담는다. view는 model에 담겨있는 데이터만 쏙쏙 골라서 화면에 바인딩 해준다. 
- Model객체는 컨트롤러에서 데이터를 생성해 이를 JSP ,HTML 즉, view단에 전달하는 역할을 한다.
- HashMap형태를 갖고있고, 키(key)와 밸류(value)값을 저장합니다. 
- request.setAttribute(..)과 비슷한역할을 한다.


12.ModelAndView
- model에서 view영역이 좀 더 확장
- Model과 View를 동시에 설정이 가능한 컨트롤러는 Model과 View 모두 리턴 가능

13.Model vs ModelAndView
- 데이터만 저장한다 vs 데이터와 이동하고자 하는 viewPage를 같이 저장한다.

14. 계층 구조
-컨트롤러 : 웹 MVC의 컨트롤러 역할
-서비스 : 핵심 비지니스 로직 구현
-레파지토리 : 데이터베이스에 접근
-도메인 : 비지니스 도메인 객체, 예)회원,주문,쿠폰 등등 (ex.회원도메인 작업중 ...)
