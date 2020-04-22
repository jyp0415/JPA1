# 양방향 연관관계

다대일 상황에서 누군가는 외래 키를 관리해야 한다.
n:1 ->  n 쪽에서 외래 키를 관리해야 한다. 1에서는 mappedby 를 사용해준다.
<pre>
<code>
Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("moonnizzang");
			member.setTeam(team);
			em.persist(member);
			
			//team.getMembers().add(member); //1. member 연관관계 주인이 있으므로  안해줘도 밑에서 for문의 team 에서 멤버 출력 가능 
			//	team.getMembers().get(0).setTeam(team);
			em.flush();
			em.clear();
			Team fTeam = em.find(Team.class, team.getId());
			List<Member> members = fTeam.getMembers();
			System.out.println("=========================");
			for(Member m : members) {
				
				System.out.println("m = "+ m.getUsername());
			}
			System.out.println("=========================");
</pre>
</code>

1. 현재 TEAM 엔티티에는 mappedby 가 주석처리 되어있다 . 
member 에서는 teamid 가 저장되지만 team 엔티티에서 members 목록을 출력하면 빈내용을 출력한다(주인을 정하지 않으니 자동으로 설정해주지 않는다.)
하지만 mappedby 를 사용하면 members 에 member가 자동으로 저장된다 . 

그리고 mappedby 를 사용하지 않으면 키관련 테이블이 더 생성되고 성능적으로 좋지 않다.
