package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Compte;
import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface CompteRepository extends JpaRepository<Compte, Long>{

    Optional<Compte> findById(Long id);
    List<Compte> findAll();
    Compte findByUsername(String username);
}
