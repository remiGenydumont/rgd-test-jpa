package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Client;
import model.Emprunt;
import model.Livre;

public class EmpruntService implements IEmpruntService {
	private EntityManager em ;
	
	public EmpruntService(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Livre> getAllLivreByEmprunt(int id_emprunt) {
		Query query = this.em.createQuery("select E from Emprunt E where E.id =:id_emprunt");
		query.setParameter("id_emprunt", id_emprunt);
		Emprunt E = (Emprunt) query.getSingleResult();
		return E.getListLivresEmpruntes();
	}

	@Override
	public List<Emprunt> getAllEmpruntByUser(int id_client) {
		Query query = this.em.createQuery("select C from Client C where C.id =?");
		query.setParameter(1, id_client);
		Client c = (Client) query.getSingleResult();
		return c.getEmprunts();
	}

}
