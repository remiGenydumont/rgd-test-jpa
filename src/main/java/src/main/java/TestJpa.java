package src.main.java;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lyon-rgd-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		System.out.println(em.isOpen());
	}

}
