package src.main.java;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import src.main.java.model.Emprunt;
import src.main.java.model.Livre;
import src.main.java.service.EmpruntService;
import src.main.java.service.LivreService;

public class TestJpa {

	public static void main(String[] args) {
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lyon-rgd-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		LivreService lService =  new LivreService(em);
		Livre book = lService.find(3);
		System.out.println(book);
		Livre book1 = lService.findByTitle("Germinal");
		System.out.println(book1);
		
		EmpruntService eService = new EmpruntService(em);
		List<Emprunt> listEmprunt = eService.getAllEmpruntByUser(1);
		for (Emprunt emprunt : listEmprunt) {
			System.out.println(emprunt.toString());
		}
		List<Livre> listLivres = eService.getAllLivreByEmprunt(4);
		for (Livre livre : listLivres) {
			System.out.println(livre.toString());
		}
	}

}
