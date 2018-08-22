package banque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="assuranceVie")
public class AssuranceVie extends Compte {
	@Column(name="dateFin")
	private LocalDate dateFin;
	@Column(name="taux")
	private Double taux;
	public AssuranceVie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AssuranceVie(String numero, Double solde, List<Client> listClient, LocalDate dateFin, Double taux) {
		super(numero, solde, listClient);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	@Override
	public String toString() {
		return super.toString()+" AssuranceVie [dateFin=" + dateFin + ", taux=" + taux + "]";
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Double getTaux() {
		return taux;
	}
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
}
