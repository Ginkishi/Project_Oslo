/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity
public class Fonction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    // Nom de la Fonction
    private String libelle;

    @ManyToOne
    private Departement departement;

    

    @ManyToMany(mappedBy = "fonctionOccupe")
    private List<Services> occupeServices;

    @ManyToMany(mappedBy = "fonctionOccupe")
    private List<Incident> occupeIncident;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "personne_occupe_fonction",
            joinColumns = @JoinColumn(name = "fonction_id",referencedColumnName = "id",
                            nullable = false),
            inverseJoinColumns = @JoinColumn(name = "personne_id",referencedColumnName = "id",
                            nullable = false))
    private List<Personne> occupationDePersonne;

    public Fonction(String libelle) {
        this.libelle = libelle;
    }

    public Fonction(String libelle, Departement departement) {
        this.libelle = libelle;
        this.departement = departement;
    }

    public Fonction() {
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Services> getOccupeServices() {
        return occupeServices;
    }

    public void setOccupeServices(List<Services> occupeServices) {
        this.occupeServices = occupeServices;
    }

    public List<Incident> getOccupeIncident() {
        return occupeIncident;
    }

    public void setOccupeIncident(List<Incident> occupeIncident) {
        this.occupeIncident = occupeIncident;
    }

    public List<Personne> getOccupationDePersonne() {
        return occupationDePersonne;
    }

    public void setOccupationDePersonne(List<Personne> occupationDePersonne) {
        this.occupationDePersonne = occupationDePersonne;
    }

    @Override
    public String toString() {

        return libelle;

    }
    
    public String getFull(){
         return departement +" - "+ libelle;
    }

    public String toJson() {
        return "{\"id\":" + id + ", \"libelle\":" + "\"" + libelle + "\"}";
    }
}
