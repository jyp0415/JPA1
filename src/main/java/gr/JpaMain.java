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
			//�񿵼� ����
			Member member = new Member();
			member.setId(100L);
			member.setName("jinyoung");
			Member member2 = new Member(101L,"jyp");
			//
			
			//���� ����
			em.persist(member); //db�� ����Ǵ°� �ƴ� ���Ӽ� ���ؽ�Ʈ���� ������ �ȴ�. 1�� ĳ�ÿ� ���� 
			em.persist(member2); //persistence.xml �� ��ġ ������ �����ؼ� �ѹ濡 ���� ������ ���� 
			//em.detach(member); //���Ӽ� ���ؽ�Ʈ���� ���� . �ؿ��� ���� 
			// em.remove(member); // db���� ������ �Ҷ� ���.
			//em.flush(); //�÷��� �Ͽ� Ŀ���ϱ����� insert ���� ȣ�� 
			Member fmember=em.find(Member.class, 100L); //1�� ĳ�ø� ��ȸ�Ҷ��� select ������ ������ �ʴ´�.
			//Member fmember2=em.find(Member.class, 100L);  //== �񱳽� ���� ����. ���ϼ� ���� 
			
			System.out.println("��� �̸� : "+fmember.getName());
			
			fmember.setName("jinyoung after"); //�ڹ� �÷��� �ٷ���� update ������ ���� �����൵ ��. ���氨��.
			                                   //1�� ĳ�ÿ��� id ��ƼƼ �������� �ִ�. �������� ���Ӽ� ���ؽ�Ʈ�� ����ɶ� ���ʻ��¸� �����س���? 
												//�������� ��ƼƼ ��  , remove �� ���� ���� 
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
