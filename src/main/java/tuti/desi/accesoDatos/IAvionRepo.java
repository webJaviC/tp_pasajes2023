package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Persona;

@Repository
public interface IAvionRepo extends JpaRepository<Avion, Long> {
	
	

}
