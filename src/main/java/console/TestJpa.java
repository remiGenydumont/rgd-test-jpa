package console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import banque.model.Adresse;
import banque.model.AssuranceVie;
import banque.model.Banque;
import banque.model.Client;
import banque.model.Compte;
import banque.model.LivretA;
import banque.model.Operation;
import banque.model.Virement;

public class TestJpa {

	public static void main(String[] args) {
	
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lyon-rgd-jpa-bibliotheque");
//		EntityManager em = entityManagerFactory.createEntityManager();
//
//		LivreService lService =  new LivreService(em);
//		Livre book = lService.find(3);
//		System.out.println(book);
//		Livre book1 = lService.findByTitle("Germinal");
//		System.out.println(book1);
//		
//		EmpruntService eService = new EmpruntService(em);
//		List<Emprunt> listEmprunt = eService.getAllEmpruntByUser(1);
//		for (Emprunt emprunt : listEmprunt) {
//			System.out.println(emprunt.toString());
//		}
//		List<Livre> listLivres = eService.getAllLivreByEmprunt(4);
//		for (Livre livre : listLivres) {
//			System.out.println(livre.toString());
//		}
		
		EntityManagerFactory entityManagerFactoryBanque = Persistence.createEntityManagerFactory("lyon-rgd-jpa-banque");
		EntityManager emB = entityManagerFactoryBanque.createEntityManager();
		
		EntityTransaction et = emB.getTransaction();
		et.begin();
		
		Banque lcl = new Banque("LCL");
		
		Adresse a1 = new Adresse(1, "de lyon", 69000, "Lyon");
		Adresse a2 = new Adresse(2, "de lyon", 69000, "Lyon");
		Adresse a3 = new Adresse(3, "de lyon", 69000, "Lyon");
		Adresse a4 = new Adresse(4, "de lyon", 69000, "Lyon");
		
		Client c1 = new Client("Nom_1", "Prenom_1", LocalDate.now(), a1, lcl);
		Client c2 = new Client("Nom_2", "Prenom_2", LocalDate.now(), a1, lcl);
		Client c3 = new Client("Nom_3", "Prenom_3", LocalDate.now(), a2, lcl);
		Client c4 = new Client("Nom_4", "Prenom_4", LocalDate.now(), a2, lcl);
		Client c5 = new Client("Nom_5", "Prenom_5", LocalDate.now(), a3, lcl);
		Client c6 = new Client("Nom_6", "Prenom_6", LocalDate.now(), a4, lcl);
		
		List<Client> couple12 = new ArrayList<>(); couple12.add(c1); couple12.add(c2);
		List<Client> couple34 = new ArrayList<>(); couple34.add(c3); couple34.add(c4);
		List<Client> client5 = new ArrayList<>(); client5.add(c5);
		List<Client> client6 = new ArrayList<>(); client6.add(c6);
		
		Compte co1 = new Compte("0000000001", 100.5, couple12);
		Compte co2 = new Compte("0000000002", 200.5, couple34);
		Compte co3 = new Compte("0000000003", 300.5, client5);
		Compte co4 = new Compte("0000000004", 400.5, client6);
		Compte co5 = new Compte("0000000005", 500.5, client6);
		
		Compte co6 = new AssuranceVie("0000000006", 20000.0, client5, LocalDate.of(2050, 12, 12), 5.0);
		Compte co7 = new LivretA("0000000007", 5000.0, couple12, 0.75);
		
//		Operation o1 = new Virement("to co1", LocalDate.now(), -20.0, "da??", co5);
//		Operation o2 = new Virement("from co5", LocalDate.now(), 20.0, "da??", co1);
		
		emB.persist(lcl);
		emB.persist(c1);emB.persist(c2);emB.persist(c3);emB.persist(c4);emB.persist(c5);emB.persist(c6);
		emB.persist(co1);emB.persist(co2);emB.persist(co3);emB.persist(co4);emB.persist(co5);emB.persist(co6);emB.persist(co7);
//		emB.persist(o1);emB.persist(o2);
		
		et.commit();
		
		Query q = emB.createQuery("select c from Compte c");
		List< Compte> lc = q.getResultList();
		for (Compte compte : lc) {
			System.out.println(compte.toString());
		}
		
		emB.close();
	}

}
