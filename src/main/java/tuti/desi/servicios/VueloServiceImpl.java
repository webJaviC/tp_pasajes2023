package tuti.desi.servicios;

import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tuti.desi.accesoDatos.IVueloRepo;

import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;

import tuti.desi.presentacion.vuelo.VueloBuscarForm;


@Service
public class VueloServiceImpl implements VueloService{

	@Autowired
	IVueloRepo repo;
	
	@Override
	public List<Vuelo> getAll() {
		
		return repo.findAll();
	}
	
	@Override
	public List<Vuelo> filter(VueloBuscarForm filter) throws Excepcion {
		
//		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if( filter.getTipoVuelo()==null && filter.getNroVuelo()==null)
			throw new Excepcion("Es necesario al menos un filtro");
		else
			return repo.findByNroOrTipo(filter.getTipoVuelo(),filter.getNroVuelo());
		
		
		
	}

	@Override
	public void save(Vuelo vuelo) throws Excepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vuelo getVueloById(Long idVuelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVueloByid(Long id) {
		// TODO Auto-generated method stub
		
	}
}
