package src.main.java.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import src.main.java.model.Livre;

public class LivreService implements ILivreService {

	private EntityManager em ;
	
	public LivreService(EntityManager em) {
		this.em = em;
	}
	@Override
	public Livre findByTitle(String title) {
		Query query = this.em.createQuery("select l from Livre l where l.titre='"+title+"'");
		Livre book = (Livre) query.getSingleResult();
		return book;
	}

	@Override
	public Livre find(int id) {
		return em.find(Livre.class, id);
	}

}
