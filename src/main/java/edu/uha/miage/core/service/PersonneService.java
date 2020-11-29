package edu.uha.miage.core.service;

import java.util.List;
import java.util.Optional;

import edu.uha.miage.core.entity.Personne;

public interface PersonneService {
    Personne save(Personne entity);
    void delete(Long id);
    List<Personne> findAll();
    Optional<Personne> findById(Long id);
    Personne findByNom(String nom);
    Personne getOne(Long id);
}
