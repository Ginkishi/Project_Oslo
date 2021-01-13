package edu.uha.miage.core.repository;
import edu.uha.miage.core.entity.Demande;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Psyrkoz
 */
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    Optional<Demande> findById(Long id);
}
