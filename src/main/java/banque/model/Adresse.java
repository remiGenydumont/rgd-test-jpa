package banque.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	@Column(name="numero")
	private Integer numero;
	@Column(name="rue")
	private String rue;
	@Column(name="codepostal")
	private Integer codepostal;
	@Column(name="ville")
	private String ville;
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(Integer numero, String rue, Integer codepostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codepostal = codepostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codepostal=" + codepostal + ", ville=" + ville + "]";
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public Integer getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(Integer codepostal) {
		this.codepostal = codepostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	

}
