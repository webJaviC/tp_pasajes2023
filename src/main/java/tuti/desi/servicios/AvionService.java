package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.vuelo.VueloBuscarForm;

public interface AvionService {
	

	List<Avion> getAll();

	
	List<Avion> filter(AvionBuscarForm filter) throws Excepcion;

	Avion getById(Long idAvion);

	
	 void save(Avion avion) throws Excepcion;
	

	void deleteAvionByid(Long id);

}
