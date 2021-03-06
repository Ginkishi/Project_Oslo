package edu.uha.miage.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity
public class Role implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
     @NotNull
    @Size(min = 2, max = 50)
    private String libelle;

    @OneToMany(mappedBy = "role")
    private List<Compte> comptes;

    
    public Role(String libelle) {
        this.libelle = libelle;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    

    @Override
    public String toString() {
        return libelle;
    }
     
     
    
}
