package es.santander.ascender.ejerc008.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import es.santander.ascender.ejerc008.model.Persona;
import jakarta.transaction.Transactional;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

        @Modifying
    @Transactional
    @Query("update Persona p set p.provincia.id = null where p.provincia.id = ?1")
    public int limpiaProvincia(Long provinciaId);
}
