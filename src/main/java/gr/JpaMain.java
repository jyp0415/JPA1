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
			
			Book book = new Book();
			book.setAuthor("jyp");
			book.setIsbn("123");;
			book.setName("��¯");
			book.setPrice(1000);
			
			em.persist(book);
			
			em.flush();
			em.clear();
			
			Book fbook = em.find(Book.class, book.getId());
			System.out.println(fbook);
			
			tx.commit(); // Ŀ���ϴ� ���� insert ���� ������. ���� ���� 
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}finally {
			em.close();
		}
		
		emf.close();
		
	}
}
