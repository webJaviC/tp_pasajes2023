package tuti.desi.presentacion.vuelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Persona;
import tuti.desi.entidades.Vuelo;

public class VueloForm {

	@NotNull(message = "el Numero DE Vuelo no puede ser nulo")
	@Min(value = 7000000, message = "el Numero DE Vuelo debe ser mayor a 0")
	private Long nroVuelo;
	@NotNull
	@Size(min=2, max=30, message = "el valor debe estar entre 2 y 30")
	private String tipoVuelo;
	@NotNull
	@Size(min=2, max=30)
	private String horaVuelo;
	@NotNull
	private Long idCiudad;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaVuelo;
	private Boolean editando=false;
	
	public VueloForm() {
		super();
	}

	public VueloForm(Vuelo v) {
		super();
		this.nroVuelo = v.getNroVuelo();
		this.tipoVuelo = v.getTipoVuelo();
		this.horaVuelo = v.getHoraVuelo();
		this.idCiudad=v.getOrigen().getId();
		this.fechaVuelo = v.getFechaVuelo();
		this.editando = true;
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

	public String getHoraVuelo() {
		return horaVuelo;
	}

	public void setHoraVuelo(String horaVuelo) {
		this.horaVuelo = horaVuelo;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
	
	public Vuelo toPojo()
	{
		Vuelo v = new Vuelo();
		if(!this.editando)
		{
			v.setNroVuelo(this.getNroVuelo());
		}
		v.setTipoVuelo(this.getTipoVuelo());
		v.setHoraVuelo(this.getHoraVuelo());
		v.setNroVuelo(this.getNroVuelo());
		v.setFechaVuelo(this.getFechaVuelo());
		v.setEditando(this.getEditando());
		
		return v;
	}
	
}
