게시판을 작성하면서 알게된 사실들 기록하기 RECORD
=============================================
## 1. 어노테이션
#### 1.1 RestController 와 Controller 차이점
둘의 주요한 차이점은 HTTP ResponseBody가 생성되는 방식이다.<br>
* Controller - view <br>
전통적인 Spring MVC 의 컨트롤러. 주로 view를 반환하기 위해서 사용한다.
![Alt Text](./img/controller.jpg)<br>
Controller가 요청을 처리한 후에 응답을 DispatcherServlet으로 반환<br>
DispatcherServlet은 View를 사용자에게 반환
* Controller - Data <br>
Data를 반환해야 하는 경우. @ResponseBody를 활용해서 Json 형태로 데이터를 반환.
![Alt Text](./img/controller_data.jpg)<br>
* RestController<br>
Spring MVC Controller에 @ResponseBody가 추가된것. Json/Xml 형태로 객체 데이터를 반환하는 것이 주용도. Restful 웹서비스의 생산을 단순화 하기 위해 만들어짐.<br>
![Alt Text](./img/RestController.jpg)<br>