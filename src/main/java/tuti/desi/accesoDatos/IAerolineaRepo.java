package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tuti.desi.entidades.Aerolinea;



public interface IAerolineaRepo extends JpaRepository<Aerolinea, Long> {

	List<Aerolinea> findByNombreOrDni( String nombre, Long dni);

	@Query("SELECT p FROM Persona p WHERE p.nombre like ?1 or p.dni=?2 or p.ciudad.id=?3")
	List<Aerolinea> findByNombreOrIdCiudad(String nombre, Long dni, Long idProvinciaSeleccionada);
	
} 


