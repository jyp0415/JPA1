package gr;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cascade.Child;
import cascade.Parent;

public class JpaMain {

	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			Child child1 = new Child();
			Child child2 = new Child();
			
			Parent parent = new Parent();
			parent.addChild(child1);
			parent.addChild(child2);
			
			em.persist(parent);
			//em.persist(child1);
			//em.persist(child2);
			
			em.flush();
			em.clear();
			Parent fp = em.find(Parent.class, parent.getId());
			
			fp.getChildList().remove(0);
			
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
