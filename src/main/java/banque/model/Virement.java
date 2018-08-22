package banque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="virement")
@DiscriminatorValue("Vir")
public class Virement extends Operation {
	@Column(name="beneficiaire")
	private String beneficiaire;

	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Virement(String beneficiaire, LocalDate date, Double montant, String motif, Compte compte) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}


	@Override
	public String toString() {
		return super.toString()+" Virement [beneficiaire=" + beneficiaire + "]";
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
