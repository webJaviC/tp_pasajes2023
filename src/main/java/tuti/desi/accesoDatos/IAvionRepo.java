package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Persona;

@Repository
public interface IAvionRepo extends JpaRepository<Avion, Long> {
	
	Avion findBynroAvionr(Long nroAvion);
	
	List<Avion> findByMatriculaOrNroAvion(String matricula, Long nroAvion);
	
	@Query("SELECT c FROM Ciudad c WHERE c.nombre like ?1 and c.provincia.id=?2")
	List<Avion> findByMatriculaOrNroAvion1(String matricula, Long nroAvion);

	boolean existsNumeroDeAvion(Long nroAvion);

}
