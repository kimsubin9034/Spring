## 🖊️ Spring
스프링 프로젝트생성링크
## 프로젝트 세팅
-https://start.spring.io/


## application.properties
#port 세팅
server.port=9090

#한글성정
server.servlet.encoding.charset=UTF-8
server.servlet.encoding.enabled=true
server.servlet.encoding.force=true

#thymleaf cache
spring.thymeleaf.cache=false

#DB커넥션
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.username=springweb
spring.datasource.password=springweb


#jpa
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none

#jsession 제거
server.servlet.session.tracking-modes=cookie

#session timeout
server.servlet.session.timeout=60

spring.messages.basename=errors



