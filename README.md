# 일대다
팀 엔티티에서 member 의 외래키로 관리할 경우 

```java
public class team1 {	
	@Id @GeneratedValue 
	@Column(name = "TEAM_ID")
	private Long id;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name = "TEAM_ID")
	private List<mem> mems = new ArrayList<mem>();
```
mem 테이블에 외래키가 생성되고 주인은 team1 엔티티가 된다.

#일대다 에서 양방향으로 조회
member 에서 team 을 조회하고 싶다면
```java
 @ManyToOne
 @JoinColumn(insertable = false , updatable= false)
 private Team team 
 ```
 조회만 가능하도록 만든다 . <br>
이런 매핑은 공식적으로 존재하지 않는다.

# 일대일
member와 locker 인 경우 <br>
locker 엔티티에 Member member 를 추가하고 joincolumn 으로 <br>
locker 테이블에서 외래키를 관리한다면 나중에 멤버 한명이 여러개의 락커를 가질수 있다면<br>
수정이 편리하다.



