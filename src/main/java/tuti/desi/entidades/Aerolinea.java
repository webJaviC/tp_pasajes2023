package tuti.desi.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Aerolinea {
	
	@Id
	private Long id;

	
	 
	 @Transient
		private Boolean editando=false;
		
	 @ManyToOne
	 private Ciudad ciudad;
	 
	 @ManyToOne
	 private Vuelo vuelo;
	 
	 @ManyToOne
	 private Avion Avion;
	 
	 

	public Aerolinea() {
		super();
	}

	
	public Aerolinea(Long id, Boolean editando, Ciudad ciudad, Vuelo vuelo, tuti.desi.entidades.Avion avion) {
		super();
		this.id = id;
		this.editando = editando;
		this.ciudad = ciudad;
		this.vuelo = vuelo;
		Avion = avion;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Avion getAvion() {
		return Avion;
	}

	public void setAvion(Avion avion) {
		Avion = avion;
	}
	 
	 
	 
	
}
