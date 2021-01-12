/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"libelle"})})
public class Services implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    // Nom de la Fonction
    private String libelle;
    
    @NotNull
    @Min(1)
    @Max(10)
    private int priorite;
    
    //private String image;
    
    @NotNull
    private String placeholder;

    @OneToOne(mappedBy = "service")
    private DemandeServices demande_service;
    
    @ManyToOne
    private Categorie categorie;

    @ManyToMany
    @JoinTable(
        name = "fonction_occupe_service", 
        joinColumns = @JoinColumn(name = "services_id"), 
        inverseJoinColumns = @JoinColumn(name = "fonction_id"))
    private List<Fonction> fonctionOccupe;
    
    public Services() {
    }

    public Services(String libelle, int priorite, String placeholder, Categorie categorie) {
        this.libelle = libelle;
        this.priorite = priorite;
        this.placeholder = placeholder;
        this.categorie = categorie;
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

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Fonction> getFonctionOccupe() {
        return fonctionOccupe;
    }

    public void setFonctionOccupe(List<Fonction> fonctionOccupe) {
        this.fonctionOccupe = fonctionOccupe;
    }

    public DemandeServices getDemande_service() {
        return demande_service;
    }

    public void setDemande_service(DemandeServices demande_service) {
        this.demande_service = demande_service;
    }
    
    

    @Override
    public String toString() {
        return libelle;
    }
    
    
    
    
}
