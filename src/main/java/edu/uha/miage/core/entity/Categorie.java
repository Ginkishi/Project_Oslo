/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity

@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"libelle"})})
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    // Nom du Département
    private String libelle;

    @ManyToOne
    private Categorie parent;

    @OneToMany(mappedBy = "parent")
    private List<Categorie> enfants;

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

    @Override
    public String toString() {
        if (parent == null) {
            return libelle;
        }
        return parent+" - "+libelle;
    }

}
