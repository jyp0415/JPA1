package gr;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("moonnizzang");
			member.setTeam(team);
			em.persist(member);
			
			//team.getMembers().add(member); //member 연관관계 주인이 있으므로  안해줘도 밑에서 for문의 team 에서 멤버 출력 가능 
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
			tx.commit(); // 커밋하는 순간 insert 쿼리 보낸다. 쓰기 지연 
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}finally {
			em.close();
		}
		
		emf.close();
		
	}
}
