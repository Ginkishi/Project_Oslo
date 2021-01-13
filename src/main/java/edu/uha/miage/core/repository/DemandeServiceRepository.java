/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.repository;
import edu.uha.miage.core.entity.DemandeServices;
import edu.uha.miage.core.entity.Personne;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Quentin
 */
public interface DemandeServiceRepository extends JpaRepository<DemandeServices, Long> {
    Optional<DemandeServices> findById(Long id);
    List<DemandeServices> findByCreateur(Personne p);
}
