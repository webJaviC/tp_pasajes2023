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

	/**
	 * Si la persona existe la actualizará, sino la creará en BD
	 * @param persona
	 * @throws Exception 
	 */
	void save(Vuelo vuelo) throws Excepcion;

	/**
	 * permite obtener un vuelo determinado
	 * @param idPersona identificador de la persona buscada
	 * @return persona encontrada o null si no encontr{o la persona
	 * @throws Exception ante un error
	 */
	Vuelo getVueloById(Long idVuelo) throws Exception;

	void deleteVueloByid(Long id);

	
	}



