package tuti.desi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Avion {

	@Id
	private Long nroAvion;
	
	private String matricula;
	
	private String cantFilas;
	
	private String cantAsientos;

	public Long getNroAvion() {
		return nroAvion;
	}

	public void setNroAvion(Long nroAvion) {
		this.nroAvion = nroAvion;
	}

	public String getCantFilas() {
		return cantFilas;
	}

	public void setCantFilas(String cantFilas) {
		this.cantFilas = cantFilas;
	}

	public String getCantAsientos() {
		return cantAsientos;
	}

	public void setCantAsientos(String cantAsientos) {
		this.cantAsientos = cantAsientos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


}
