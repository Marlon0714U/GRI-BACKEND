package co.edu.uniquindio.gri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.gri.model.Investigador;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InvestigadorRepository extends JpaRepository<Investigador, Long>{
    // co.edu.uniquindio.gri.model.Investigador eliminarTodosLosInvesigadores
    @Transactional
    @Modifying
    @Query(value = "delete from gri.investigadores", nativeQuery = true)
    void eliminarTodosLosInvesigadores();

}
