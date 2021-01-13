package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Categorie;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */

public interface CategorieService{
Categorie save(Categorie entity);

    void delete(Long id);

    List<Categorie> findAll();

    Optional<Categorie> findById(Long id);

    Categorie findByLibelle(String libelle);

    Categorie getOne(Long id);
    

    
    public List<Categorie> findByParent(Categorie parent);
    public List<Categorie> findByEnfantsIsNull();
}
