/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.repository;
import edu.uha.miage.core.entity.Demande;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Quentin
 */
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    Optional<Demande> findById(Long id);
}
