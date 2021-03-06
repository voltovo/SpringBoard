연관관계 매핑
============
2.연관관계 매핑
---------------
데이터베이스에서 테이블 하나로 애플리케이션에서 사용하는 모든 데이터를 관리하는것은 불가능하다. 그래서 여러 테이블에 나누어 저장하고 테이블을 조인하여 데이터를 처리한다. JPA는 테이블과 엔티티를 매핑하는 기술이다.<br>
테이블의 연관관계를 엔티티의 연관관계로 매핑해야 하는데, 중요한 것은 테이블은 PK,FK 기반으로 연관관계를 맺지만, 객체는 참조 변수를 통해 연관관계를 맺기 때문에 테이블의 연과과 엔티티의 연관이 정확하게 일치하지 않는다.

#### 2.1 연관관계 매핑
* 기본적인 매핑 용어

|용어|설명|
|:--|:---|
|방향<br>(Direction)|단방향과 양방향<br>게시판 객체가 참조 변수를 통해 회원 객체르르 참조하면 단방향. 회원 객체도 게시판 객체를 참조하면 양방향. **방향은 객체에만 존재하고 테이블은 항상 양방향이다**|
|다중성<br>(Multiplicity)|다대일(N:1),일대다(1:N),일대일(1:1),다대다(N:N)<br>회원은 여러 개의 게시글을 작성하기 때문에, 회원과 게시글은 일대다 관계. 반대로 게시글 입장에서 보면 다대일 관계|
|연관관계 주인<br>(Owner)|객체를 양방향 연관관계로 만들면 연관관계의 주인을 정해야한다. 일반적으로 다대일(N:1)이나 일대다(1:N)관계에서 주인은 다(N)쪽에 해당하는 객체라고 생각하기 쉽다.
