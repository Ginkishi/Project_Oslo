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
    PersonneRepository customerRepository;

    @Override
    public Personne save(Personne entity) {
        return customerRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Personne> findAll() {
        return (List<Personne>) customerRepository.findAll();
    }

    @Override
    public Optional<Personne> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Personne findByNom(String nom) {
        return customerRepository.findByNom(nom);
    }

    @Override
    public Personne getOne(Long id) {
        return customerRepository.getOne(id);
    }
}
