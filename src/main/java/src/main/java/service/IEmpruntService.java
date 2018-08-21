package src.main.java.service;

import java.util.List;
import src.main.java.model.Client;
import src.main.java.model.Emprunt;
import src.main.java.model.Livre;

public interface IEmpruntService {
	public List<Emprunt> getAllEmpruntByUser(int id_client);
	public List<Livre> getAllLivreByEmprunt(int id_emprunt);
}
