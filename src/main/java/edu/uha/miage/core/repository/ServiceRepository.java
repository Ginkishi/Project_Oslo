package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Categorie;

import edu.uha.miage.core.entity.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface ServiceRepository extends JpaRepository<Services, Long>{
        Services findByLibelle(String libelle);

    Optional<Services> findById(Long id);

    List<Services> findAllByOrderByLibelle();

    public List<Services> findByCategorieOrderByLibelle(Categorie categorie);
}
