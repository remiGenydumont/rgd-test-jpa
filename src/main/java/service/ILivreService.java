package service;

import model.Livre;

public interface ILivreService {

	public Livre findByTitle(String title);
	public Livre find(int id);
}
