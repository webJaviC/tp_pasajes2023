package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tuti.desi.entidades.*;

public interface IVueloRepo extends JpaRepository<Vuelo, Long> {
	List<Vuelo> findByNroOrTipo( String tipoVuelo, Long nroVuelo);

	@Query("SELECT p FROM Vuelo v WHERE v.tipoVuelo like ?1 or v.nroVuelo=?2")
	List<Persona> findByNroVueloOrTipo(String tipoVuelo, Long nroVuelo);
}
