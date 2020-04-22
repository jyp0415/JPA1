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
			Member member1 = new Member() ;
			member1.setUsername("jyp");
			
			Member member2 = new Member() ;
			member2.setUsername("jyp2");
			 // 시퀀스 
			
			
			Member2 member3 = new Member2() ;
			member3.setUsername("jyp");
			
			Member2 member4 = new Member2() ;
			member4.setUsername("jyp2");
			//테이블 
			
			System.out.println("========");
			
			em.persist(member1);
			em.persist(member2);
			em.persist(member3);
			em.persist(member4);
			System.out.println("========");
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
