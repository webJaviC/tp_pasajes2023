package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;

import tuti.desi.entidades.*;

public interface IVueloRepo extends JpaRepository<Vuelo, Long> {

}
