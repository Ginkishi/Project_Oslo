package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Departement;
import edu.uha.miage.core.entity.Fonction;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface FonctionRepository extends JpaRepository<Fonction, Long> {

    Fonction findByLibelle(String libelle);

    Optional<Fonction> findById(Long id);

    List<Fonction> findAllByOrderByLibelle();
    List<Fonction> findAllByOrderByDepartementAscLibelleAsc();

    public List<Fonction> findByDepartementOrderByLibelle(Departement departement);
                                      
}
