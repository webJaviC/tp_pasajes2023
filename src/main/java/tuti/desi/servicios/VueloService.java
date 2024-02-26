package tuti.desi.servicios;

import java.util.List;

import jakarta.validation.Valid;
import tuti.desi.entidades.*;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.personas.PersonasBuscarForm;
import tuti.desi.presentacion.vuelo.VueloBuscarForm;


public interface VueloService {
	


	List<Vuelo> getAll();

	List<Vuelo> filter(VueloBuscarForm filter) throws Excepcion;

	
	void save(Vuelo vuelo) throws Excepcion;

	
	 
	Vuelo getVueloById(Long idVuelo) throws Exception;

	void deleteVueloByid(Long id);

	
	}



