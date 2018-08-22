package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	@Id
	private Integer id;
	@Column(name="titre", length = 50)
	private String titre;
	@Column(name="auteur",  length = 255)
	private String auteur;
	
	@ManyToMany(mappedBy="listLivresEmpruntes")
	 private List<Emprunt> emprunts;

	public Livre() {
		super();
	}

	public String toString(){	
		return "Nom : "+this.getTitre()+", Auteur : "+this.getAuteur(); 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		auteur = auteur;
	}
	
	
}
