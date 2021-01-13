package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Domaine;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface DomaineRepository extends JpaRepository<Domaine, Long> {

    Domaine findByLibelle(String libelle);

    Optional<Domaine> findById(Long id);
    
}
