package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Ciudad;

@Repository
public interface ICiudadRepo extends JpaRepository<Ciudad, Long> {


	@Query("SELECT c FROM Ciudad c WHERE c.nombre like ?1 or c.provincia.id=?2")
	List<Ciudad> findByNombreOrIdProvincia(String nombre, Long idProvinciaSeleccionada);
	
	@Query("SELECT c FROM Ciudad c WHERE c.nombre like ?1 and c.provincia.id=?2")
	List<Ciudad> findByNombreAndIdProvincia(String nombre, Long idProvinciaSeleccionada);
	

}
