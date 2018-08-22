package service;

import java.util.List;

import model.Emprunt;
import model.Livre;

public interface IEmpruntService {
	public List<Emprunt> getAllEmpruntByUser(int id_client);
	public List<Livre> getAllLivreByEmprunt(int id_emprunt);
}
