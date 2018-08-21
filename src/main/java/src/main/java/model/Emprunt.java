package src.main.java.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emprunt")
public class Emprunt {
	@Id
	private Integer id ;
	@Column(name="date_debut")
	private LocalDate dateDebut ;
	@Column(name="date_fin")
	private LocalDate dateFin ;
	@Column(name="delai")
	private Integer delai ;

	@ManyToOne
	@JoinColumn(name="id_client")
	private Client emprunteur ;

	@ManyToMany
	@JoinTable(
			name="compo",
			joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private List<Livre> listLivresEmpruntes ;

	public String toString(){
		return "Emprunteur : " +this.emprunteur.getPrenom()
		+" "+this.emprunteur.getNom()
		+", "+this.dateDebut.toString()
//		+", "+this.dateFin.toString()
		+", "+Integer.toString(this.listLivresEmpruntes.size());
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public Client getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Client emprunteur) {
		this.emprunteur = emprunteur;
	}

	public List<Livre> getListLivresEmpruntes() {
		return listLivresEmpruntes;
	}

	public void setListLivresEmpruntes(List<Livre> listLivresEmpruntes) {
		this.listLivresEmpruntes = listLivresEmpruntes;
	}
}
