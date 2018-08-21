package src.main.java.service;

import src.main.java.model.Livre;

public interface ILivreService {

	public Livre findByTitle(String title);
	public Livre find(int id);
}
