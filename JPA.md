JPA 란?
=======
## 1. 스프링과 JPA
* JDBC : 데이터베이스 연동에 사용되는 전통적인 기술
* ORM : 스프링 DAO, 마이바티스, 하이버네이트 등등
* 하이버네이트 : 애플리케이션에서 사용하는 SQL까지도 프레임워크에서 제공하기 때문에 개발자가 처리해야 할 일들을 엄청나게 줄여준다.
* JPA : 이런 ORM들을 보다 쉽게 사용할 수 있도록 표준화 시킨 것, 복잡한 JPA의 개념이나 동작 원리를 모르고도 쉽게 사용할 수 있다.

##### 1.1 SQL을 직접 다루지 않는 기술
개발자가 SQL을 직접 다루지 않는 대표적인 기술이 하이버네이트 같은 ORM이다.<br>
일반적으로 데이터베이스의 값을 객체에 담아서 사용하는 경우보다 관리가 쉽다.<br>
BoardVO 같은 객체를 Map같은 컬렉션에 저장하고 관리하는 것이다.

## 2. JPA 란?
#### 2.1 JPA 개념
* 하이버네이트 : 자바 표준은 아니지만 가장 많은 개발자들이 사용하는 ORM.<br>
기존의 EJB(Enterprise Java Beans)기술인 엔티티 빈이 가지는 여러 문제들을 대체하기 위한 오픈소스 프레임워크로 등장<br>
* JPA : 하이버네이트 개발자들이 중심이 되어 만든 ORM 표준<br>
JDBC API와 같은 개념으로 이해하면 쉽다.
* JDBC : JDBC API는 java.sql 패키지로서, JDBC 인터페이스를 이용하여 DB 연동을 처리하고, 실제 실행될 때는 인터페이스를 구현한 드라이버 객체가 동작한다. DB를 변경할 때, DB에 종속적인 드라이버만 교체하면 애플리케이션 소스는 수정하지 않아도 되기 때문이다.

JPA도 제공하는 인터페이스를 이용해서 DB를 연동하면, 실제로는 JPA를 구현한 구현체가 동작하는 것이다.
* JPA 구현체 종류 : JPA를 구현한 구현체 로는 <br>
Hibernate , EclipseLink , DataNucleus 등이 있다.<br>
스프링 부트에서는 기본적으로 **하이버네이트**를 JPA 구현체로 사용한다.

#### 2.2 JPA 동작 원리
JPA는 자바 애플리케이션과 JDBC 사이에 존재하면서 JDBC의 복잡한 절차를 대신 처리해준다. 따라서 개발자는 JDBC의 복잡한 API를 모르고도 데이터베이스를 사용할 수 있다.<br>
![Alt Text](./img/jpaActionprinciple.jpg);<br>
**중요한것은 JPA가 데이터베이스 연동에 사용되는 코드뿐만 아니라 SQL까지 제공한다**
<br>그래서 JPA를 이용해 데이터베이스 연동을 처리하면 개발 및 유지보수의 편의성이 높아진다. <br> 

#### 2.3 엔티티 클래스 작성 및 테이블 매핑
JPA는 테이블이 없으면 자바 클래스를 기준으로 매핑할 테이블을 자동으로 생성한다.<br>
* 엔티티 : 테이블과 매핑되는 자바클래스 / JPA 퍼스펙티브가 제공하는 엔티티 생성 기능을 사용하면, 엔티티를 생성함과 동시에 영속석 설정 파일(persistence.xml)에 자동으로 엔티티를 등록해준다.

* 엔티티에 설정되는 어노테이션<br>

|어노테이션|의미|
|:--|:--|
|@Entity|@Entity가 설정된 클래스를 엔티티라 하며, 기본적으로 클래스 이름과 동일한 테이블과 매핑된다.|
|@Table|엔티티 이름과 매핑될 테이블 이름이 다른 경우, name 속성을 사용하여 매핑한다. 엔티티 이름과 테이블 이름이 동일하면 생략 가능|
|@Id|테이블의 기본 키를 매핑한다. 예제에서는 seq 변수가 테이블의 SEQ 칼럼과 매핑되도록 설정했다.<Br>엔티티의 필수 어노테이션으로서 @Id가 없는 엔티티는 사용하지 못한다.|
|@GeneratedValue|@Id가 선언된 필드에 기본 키 값을 자동으로 할당한다. 다양한 옵션이 있지만 @GeneratedValue만 사용하면 설정된 데이터베이스에 따라서 JPA가 자동으로 결정해준다|

#### 2.4 JPA 메인 설정 파일 작성
**META-INF 폴더에 persistence.xml 은 JPA의 메인 환경설정 파일이다.**<br>
JPA는 무조건 persistence.xml 파일을 로딩하여, 이 파일의 설정대로 동작한다.<br>
연동할 DB의 정보는 영속성 유닛(Persistence Unit)로 설정한다.
* hibernate.dialect : JPA 구현체가 사용할 Dialect 클래스를 지정할 때 사용. H2Dialect 클래스면 H2용 Sql 생성 / OracleDialect로 변경하면 Oracle용 Sql 생성

## 3. JPA 설정
대부분의 프레임워크가 설정을 할 때 xml로 관리한다. JPA도 persistence.xml파일로 관리한다.

#### 3.1 영속성 유닛 설정
* < persistence> : persistence.xml 파일의 루트
* < persistence-unit> : 영속성 유닛에 해당하는 엘리먼트 / 연동하려는 DB가 여러개면 < persistence-unit>을 여러개 설정할 수 있다. 여러개 등록시 식별하기 위해서 유일한 이름을 name속성으로 지정 한다.
* persistence Unit 설정<br>
<pre>
 < persistence-unit name="Chapter04">
</pre>
* Java 소스<br>
<pre>
    //EntityManager 생성
    EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("Chapter04");
    EntityManager em = emf.createEntityManager();
</pre>

