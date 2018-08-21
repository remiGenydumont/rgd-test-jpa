package src.main.java.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	private Integer id ;
	@Column(name="nom", length = 50)
	private String nom ;
	@Column(name="prenom", length = 50)
	private String prenom ;
	
	@OneToMany(mappedBy = "emprunteur")
	private List<Emprunt> Emprunts ;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Emprunt> getEmprunts() {
		return Emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		Emprunts = emprunts;
	}
}
