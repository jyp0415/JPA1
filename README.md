# 기본키 매핑
@ID 사용시 직접 할당해야함.
<br>

@GeneratedValue 사용시 속성 지정 가능 <br>
IDENTITY : 데이터베이스에서 직접 자동생성(AUTO_ INCREMENT). <br>
영속성 컨텍스트에 KEY 를 저장하기위해서 영속화 할때 INSERT 가 호출된다. <br><br>

SEQUENCE : 데이터베이스 시퀀스 오브젝트 사용, identity 와 다르게 키만 호출해서 영속성 컨텍스트에 저장. <br>
allocationSize 속성 사용해서 최적화 가능 <br>
TABLE : 키를 생성하는 테이블을 따로 만들어 사용한다.
auto: 방언에 따라 자동 지정.
