package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonneRepository extends JpaRepository<Personne, Long> {

    Personne findByNom(String nom);
    Personne findByNomAndPrenomAndEmailAndAdresse(String Nom, String prenom, String email, String adresse);
}
