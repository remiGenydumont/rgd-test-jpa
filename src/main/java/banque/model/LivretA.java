package banque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="livretA")
public class LivretA extends Compte {
	@Column(name="taux")
	private Double taux;

	public LivretA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LivretA(Double taux) {
		super();
	}
	public LivretA(String numero, Double solde, List<Client> listClient, double taux) {
		super(numero, solde, listClient);
		this.taux = taux;
	}
	@Override
	public String toString() {
		return super.toString()+" LivretA [taux=" + taux + "]";
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
}
