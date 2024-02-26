package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IAvionRepo;
import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.cuidades.CiudadesBuscarForm;

@Service
public class AvionServiceImpl implements AvionService {

	
	@Autowired
	IAvionRepo repo;

	@Override
	public List<Avion> getAll() {
		
		return repo.findAll();
	}



	@Override
	@Deprecated
	public Avion getById(Long idAvion) {

		return repo.findById(idAvion).get();
	}
	
	@Override
	public List<Ciudad> filter(AvionBuscarForm filter) throws Excepcion
	{
		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getNombre()==null && filter.getProvinciaSeleccionada()==null)
			//return repo.findAll();
			throw new Excepcion("Es necesario al menos un filtro");
		else
			return repo.findByMatriculaOrNroAvion1(filter.getMatricula(),filter.getNroAvion());
				
	}



	@Override
	public void deleteAvionByid(Long nroAvion) {
		repo.deleteById(nroAvion);
		
	}



	@Override
	public void save(Avion a) throws Excepcion {
		if(a.getNroAvion()==null && !repo.findByMatriculaOrNroAvion1(a.getMatricula(), a.getNroAvion()).isEmpty()) //estoy dando de alta una nueva ciudad y ya existe una igual?
			throw new Excepcion("Ya existe un avion con el mismo numero");  
		else
			repo.save(a);
		
	}



	@Override
	public List<Avion> filter(AvionBuscarForm filter) throws Excepcion {
		// TODO Auto-generated method stub
		return null;
	}

}
