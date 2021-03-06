package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Categorie;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    Categorie findByLibelle(String libelle);
    List<Categorie> findAllByOrderByParentAscLibelleAsc();

    Optional<Categorie> findById(Long id);

    List<Categorie> findAllByOrderByLibelle();

    public List<Categorie> findByParentOrderByLibelle(Categorie parent);
    public List<Categorie> findByEnfantsIsNull();
}
