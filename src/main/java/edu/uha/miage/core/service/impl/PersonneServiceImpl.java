package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import edu.uha.miage.core.repository.PersonneRepository;
import edu.uha.miage.core.service.PersonneService;


@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    @Override
    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        personneRepository.deleteById(id);
    }

    @Override
    public List<Personne> findAll() {
        return (List<Personne>) personneRepository.findAll();
    }

    @Override
    public Optional<Personne> findById(Long id) {
        return personneRepository.findById(id);
    }

    @Override
    public Personne findByNom(String nom) {
        return personneRepository.findByNom(nom);
    }

    @Override
    public Personne getOne(Long id) {
        return personneRepository.getOne(id);
    }
    
    @Override
    public Personne findByNomAndPrenomAndEmailAndAdresse(String Nom, String prenom, String email, String adresse) {
        return personneRepository.findByNomAndPrenomAndEmailAndAdresse(Nom, prenom, email, adresse);
    }
}
