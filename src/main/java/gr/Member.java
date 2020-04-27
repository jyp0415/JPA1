package gr;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Member extends BaseEntity {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="TEAM_ID") // fk �� �����Ҷ� ��� 
	private Team team;
	@OneToMany(mappedBy = "member")
	private List<MemberProduct> memberprdoucts = new ArrayList<MemberProduct>() ;

	
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	@Column(name="name")
	private String username;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP) // ������ ���̽����� ��¥ �ð� ���ÿ� 
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	private LocalDate createDate; //���̹�����Ʈ �ֽŹ������� ���� 
	private LocalDateTime testLocalDateTime;
	
	@Lob //ū ������ �����ϰ�� clob , 
	private String description;
	@Transient //�޸𸮿��� ���ڵ� ��� ���� ���� 
	private int temp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	
	public List<MemberProduct> getMemberprdoucts() {
		return memberprdoucts;
	}
	public void setMemberprdoucts(List<MemberProduct> memberprdoucts) {
		this.memberprdoucts = memberprdoucts;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getTestLocalDateTime() {
		return testLocalDateTime;
	}
	public void setTestLocalDateTime(LocalDateTime testLocalDateTime) {
		this.testLocalDateTime = testLocalDateTime;
	}
	
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	
	
}
