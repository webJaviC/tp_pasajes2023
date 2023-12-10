package tuti.desi.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Vuelo {

	@Id
	private Long nroVuelo;
	
	private String tipoVuelo;
	
	private Date fechaVuelo;
	
	private String horaVuelo;
	
	@ManyToOne
	private Avion avion;
	
	@ManyToOne
	private Ciudad origen;
	
	@ManyToOne
	private Ciudad destino;
	
	private String estado = "normal";

	public String getEstado() {
		return estado;
	}


	public Long getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(Long nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public String getHoraVuelo() {
		return horaVuelo;
	}

	public void setHoraVuelo(String horaVuelo) {
		this.horaVuelo = horaVuelo;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}
	
	
	
}
