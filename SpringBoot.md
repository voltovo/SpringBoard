Spring Boot
============
## 1. spring boot?
스프링부트는 단독실행하면, 상용화 수준의 스프링 기반 애플리케이션을 쉽게 만들어 낼 수 있다.<br>
최소한의 설정으로 스프링 플랫폼과 서드파티 라이브러리들을 사용할 수 있다.<br>
#### 스프링 부트 주요 목표
* 모든 spring 개발에 대해 빠르고 광범위하게 접근 가능한 시작 환경 제공
* 기본값에서 벗어난 요구사항들을 신속하게 해결
* 대규모 프로젝트에 공통되는 다양한 비기능 기능 제공한다(임베디드 서버, 보안, 메트릭, 상태 점검 및 외부화된 구성)
* 설정을 위한 xml 코드를 요구하지 않는다.

## 2. spring project
스프링 프로젝트 생성시 Maven과 Gradle 중에 선택을 해야한다.<br>
#### Maven?
* java용 프로젝트 관리 도구
* java 빌드 도구의 사살상의 표준
* xml 기반의 빌드 처리 (간단한 내용은 괜찮은데, 복잡한 내용을 작성하게 되면 xml 기반의 묘사는 상당히 어려워진다.)
* 프로젝트 규모가 작을 경우에는 Gradle과 차이가 적지만, 규모가 커질 경우 Gradle이 유리 / 확장성 ▼ 빌드 속도 ▼
* 다른 프로젝트에 특정 설정을 사용하기 위해서 상속을 해야한다.
#### Gradle?
* Groovy를 이용한 빌드 자동화 시스템
* 여러가지 언어 지원 (java, C, C++, Python)
* Groovy는 jvm에서 실행되는 스크립트 언어이다. java와 다른점은 소스 코드를 컴파일 할 필요가 없다.<br>
Groovy는 스크립트 언어로 소스 코드 그대로 실행된다. Java와 호환도 가능한 점 때문에 급성장 하고 있다.
* 대규모 프로젝트에서는 Maven보다 유리하다 / 확장성 ▲ 빌드 속도 ▲
* 다른 프로젝트에서 특정 설정을 사용하기 위해서 '설정 주입 방식'으로 해결

프로젝트 배포 형식은 jar 과 war 중에 선택을 해야한다.<br>
둘다 jar 툴을 사용한 압축 파일이지만, 사용 목적이 다르다.
#### jar
* 라이브러리, 플러그인, 애플리케이션 형태로 사용할 수 있게 여러 파일들을 묶을 수 있다.
* 원하는 구조로 생성 가능하다.
* 부가적인 소프트웨어 없이도 커맨드 라인에서 jar 파일을 실행할 수 있다.
#### war
* 웹에서 사용
* WEB-INF 와 META-INF 구조로만 생성이 가능하다.
* 서버로만 실행이 가능하다.

#### 시스템 요구 사항
* Java 8 / Java 11과 호환 가능
* maven - 3.3 이상 / gradle - 4.4 이상
* 내장 서블릿 컨테이너 지원

|이름|서블릿버전|
|:--:|:--|
|tomcar 9.0|4.0|
|jetty 9.4|3.1|
|undertow 2.0|4.0|

## 3. 스프링 부트 설치
Java SDK v1.8 이상 필요.<br>
* cmd창에 '$ java -version'으로 버전 확인 가능

#### 3.1 maven 설치
Spring Boot는 Apache Maven 3.3이상과 호환된다.<br>
일반적으로 Maven POM 파일은 'spring-boot-starter-parent'프로젝트에서 상속되며 하나 이상의 "Starters"에 대한 종속성을 선언한다.
<pre>
//Spring Boot 에서 기본값 상속
< parent>
    < groupId>org.springframework.boot< /groupId>
    < artifactId>spring-boot-starter-parent< /artifactId>
    < version>2.1.6.RELEASE< /version>
< /parent>

//웹 애플리케이션에 대한 일반적인 종속성 추가
< dependencies>
    < dependency>
        < groupId>org.springframework.boot< /groupId>
        < artifactId>spring-boot-starter-web< /artifactId>
    < /dependency>
< /dependencies>

//실행 가능한 jar 패키지 
	< build> 
		< plugins> 
			< plugin> 
				< groupId> org.springframework.boot < /groupId> 
				< artifactId>spring-boot-maven-plugin < /artifactId> 
			< /plugin> 
		< /plugins>
	< /build>
</pre>
