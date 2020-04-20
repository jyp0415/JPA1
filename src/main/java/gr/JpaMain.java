package gr;

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
			//비영속 상태
			Member member = new Member();
			member.setId(100L);
			member.setName("jinyoung");
			Member member2 = new Member(101L,"jyp");
			//
			
			//영속 상태
			em.persist(member); //db에 저장되는게 아닌 영속성 컨텍스트에서 관리가 된다. 1차 캐시에 저장 
			em.persist(member2); //persistence.xml 에 배치 사이즈 조절해서 한방에 쿼리 보내기 가능 
			//em.detach(member); //영속성 컨텍스트에서 삭제 . 준영속 상태 
			// em.remove(member); // db에서 삭제를 할때 사용.
			//em.flush(); //플러쉬 하여 커밋하기전에 insert 쿼리 호출 
			Member fmember=em.find(Member.class, 100L); //1차 캐시를 조회할때는 select 쿼리를 날리지 않는다.
			//Member fmember2=em.find(Member.class, 100L);  //== 비교시 위와 같다. 동일성 보장 
			
			System.out.println("멤버 이름 : "+fmember.getName());
			
			fmember.setName("jinyoung after"); //자바 컬렉션 다루듯이 update 같은걸 따로 안해줘도 됨. 변경감지.
			                                   //1차 캐시에는 id 엔티티 스냅샷이 있다. 스냅샷은 영속성 컨텍스트에 저장될때 최초상태를 저장해놓은? 
												//스냅샷과 엔티티 비교  , remove 도 같은 원리 
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
