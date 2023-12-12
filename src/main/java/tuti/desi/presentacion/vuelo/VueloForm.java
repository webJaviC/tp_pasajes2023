package tuti.desi.presentacion.vuelo;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import tuti.desi.entidades.Persona;
import tuti.desi.entidades.Vuelo;

public class VueloForm {

	
		// TODO Auto-generated constructor stub
		@NotNull
		private Long nroVuelo;
		
		@NotNull
		private String tipoVuelo;
		
		@NotNull
		private Date fechaVuelo;
		
		@NotNull
		private String horaVuelo;
		
		@NotNull
		private Long idAvion;
		
		private Boolean editando=false;
		
		@NotNull
		private Long idCiudad;
		

		public VueloForm() {
			super();
		}


		public VueloForm(@NotNull Long nroVuelo, @NotNull String tipoVuelo, @NotNull Date fechaVuelo,
				@NotNull String horaVuelo, @NotNull Long idAvion, Boolean editando, @NotNull Long idCiudad) {
			super();
			this.nroVuelo = nroVuelo;
			this.tipoVuelo = tipoVuelo;
			this.fechaVuelo = fechaVuelo;
			this.horaVuelo = horaVuelo;
			this.idAvion = idAvion;
			this.editando = editando;
			this.idCiudad = idCiudad;
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


		public Long getIdAvion() {
			return idAvion;
		}


		public void setIdAvion(Long idAvion) {
			this.idAvion = idAvion;
		}


		public Boolean getEditando() {
			return editando;
		}


		public void setEditando(Boolean editando) {
			this.editando = editando;
		}


		public Long getIdCiudad() {
			return idCiudad;
		}


		public void setIdCiudad(Long idCiudad) {
			this.idCiudad = idCiudad;
		}
		
	
		public Vuelo toPojo()
		{
			Vuelo v = new Vuelo();
			if(!this.editando)
			{
				v.setNroVuelo(this.getNroVuelo());
			}
			v.setTipoVuelo(this.getTipoVuelo());
			v.setFechaVuelo(this.getFechaVuelo());
			v.setHoraVuelo(this.getHoraVuelo());
			
			v.setEditando(this.getEditando());
			
			return v;
		}
		
	}


