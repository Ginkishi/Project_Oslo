package edu.uha.miage.core.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String libelle;

    @ManyToOne
    private Categorie parent;

    @OneToMany(mappedBy = "parent")
    private List<Categorie> enfants;

    @OneToMany(mappedBy = "categorie")
    private List<Services> services;

    public Categorie(String libelle, Categorie parent) {
        this.libelle = libelle;
        this.parent = parent;
    }

    public Categorie() {
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

    public Categorie getParent() {
        return parent;
    }

    public void setParent(Categorie parent) {
        this.parent = parent;
    }

    public List<Categorie> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Categorie> enfants) {
        this.enfants = enfants;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    @Override
    public String toString() {

        return libelle;
    }

    public String toJson() {

        if (enfants.size() <= 0) {
            return "{\"id\":" + id + ", \"libelle\":" + "\"" + libelle + "\", \"leaf\":true" + "}";
        } else {
            return "{\"id\":" + id + ", \"libelle\":" + "\"" + libelle + "\", \"leaf\":false" + "}";
        }

    }
    public boolean isLeaf(){
        return enfants.size() <= 0;
    }

}
