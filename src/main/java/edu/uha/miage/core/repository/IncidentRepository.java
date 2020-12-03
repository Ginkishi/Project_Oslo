package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Incident;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Quentin
 */
public interface IncidentRepository extends JpaRepository<Incident, Long>{
    Optional<Incident> findByLibelle(String libelle);
    Optional<Incident> findById(Long id);
}
