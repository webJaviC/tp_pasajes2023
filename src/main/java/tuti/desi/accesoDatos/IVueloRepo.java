package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tuti.desi.entidades.*;

public interface IVueloRepo extends JpaRepository<Vuelo, Long> {
    List<Vuelo> findByNroOrTipo(String tipoVuelo, Long nroVuelo);

    @Query("SELECT v FROM Vuelo v WHERE v.tipoVuelo LIKE ?1 OR v.nroVuelo = ?2")
    List<Vuelo> findByNroVueloOrTipo(String tipoVuelo, Long nroVuelo);
}

