# 
```java
@Entity
public class Parent {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	@OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Child> childList =new ArrayList<Child>();

	public void addChild(Child child) {
		
		childList.add(child);
		child.setParent(this);
	} 
  ....
```
cascade : 엔티티를 속화할 때 연관된 엔티티도 함께 속화하는 편리함 을 제공할 뿐
<h2>CASCADE의 종류</h2> 
•ALL: 모두 적용 
• PERSIST: 영속 
• REMOVE: 삭제 
• MERGE: 병합 
• REFRESH: REFRESH 
• DETACH: DETACH

<h2>고아 객체</h2> 
• 고아 객체 제거: 부모 엔티티와 연관관계가 끊어진 자식 엔티티 를 자동으로 삭제 <br>
  컬렉션에서 자식 엔티티를 제거할때, 그 자식엔티티는 자동으로 삭제가 되게 해준다. (orphanRemoval = true )
• @OneToOne, @OneToMany만 가능 
• orphanRemoval = true 
