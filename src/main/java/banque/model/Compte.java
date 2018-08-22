package banque.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.JOINED)
public class Compte {
	@Id
	@Column(name="numero")
	private String numero;
	@Column(name="solde")
	private Double solde;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> listOperation;
	
	@ManyToMany
	@JoinTable(
			joinColumns=@JoinColumn(name="ID_Compte", referencedColumnName="numero"),
			inverseJoinColumns=@JoinColumn(name="ID_Client", referencedColumnName="ID"))
	private List<Client> listClient ;
	
	public Compte() {
		super();
		this.listOperation = new ArrayList<>();
	}
	
	public Compte(String numero, Double solde, List<Client> listClient) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.listClient = listClient;
		this.listOperation = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + "]";
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public List<Operation> getListOperation() {
		return listOperation;
	}
	public void setListOperation(List<Operation> listOperation) {
		this.listOperation = listOperation;
	}
	public List<Client> getListClient() {
		return listClient;
	}
	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}	
}
