# 애노테이션 공부<br>
@Entity : 테이블과 매핑을 하려면 클래스에 엔티티 애노테이션을 붙여준다.
<br>
@Table : name 속성으로 DB에 생성할 테이블 이름을 정한다. 또한 catalog,schema를 매핑할 수 있는 속성도 있다. <br>
uniqueConstraints 로는 유니크 제약 조건을 생성할 수 있다. -> Column 에서도 유니크 제약조건을 걸 수 있지만, <br>
Table 에서 사용시 2개이상을 묶을 수 있다.

# 데이터베이스 스키마 자동 생성<br>
리소스 폴더에 설정 관련 파일의 hibernate.hbm2ddl.auto 속성으로 데이터베이스 스키마 자동 생성 가능<br>
개발초기에만 create 를 사용하자. <br>

# DDL 생성<br>
@Column 애노테이션에서 사용가능한 속성 -> nullable : 널 제약조건 , length 로는 길이 제한 설정가능 <br>
@Table 애노테이션에서 uniqueConstraints 속성으로 유니크 제약조건 추가가능 <br>

# 매핑 애노테이션
@Lob : 큰 데이터를 사용할때
@Transient : DB컬럼과 상관없이 애플리케이션 메모리에서만 사용하고 싶을때 사용<br> 
@Temporal : 날짜 사용할때 -> 데이터베이스에서는 시간, 날짜 , 시간날짜 인경우가 있으므로 나누어서 설정한다.<br>
@Enumerated : enum 타입과 매핑할 때 사용, ORDINAL 은 enum 타입 추가시에 문제가 발생가능 (because 순서에 따라서 배정)<br>
              STRING 으로 ENUM 에서 정한 이름을 그대로 사용하는게 좋음.<br>


