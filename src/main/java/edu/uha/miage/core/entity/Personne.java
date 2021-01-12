package edu.uha.miage.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Personne implements Serializable {

    // #### V0.0 Pour définir l'identifiant de la table.
    @Id
    // #### V0.0 Pour laisser à Spring le soin de générer un identifiant unique.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    // Nom de la Personne
    private String nom;

    @NotNull
    @Size(min = 2, max = 50)
    // Prénom de la Personne
    private String prenom;


    // Adresse de la Personne
    private String adresse;

    // Email de la Personne
    private String email;

    @ManyToMany(mappedBy = "occupationDePersonne")
    private List<Fonction> occupations;
    
        @OneToMany(mappedBy = "createur")
    private List<Demande> demandes;
    
    public Personne(String nom, String prenom, String adresse, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
    }

    public Personne() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    


    @Override
    public String toString() {
        return nom + " " + prenom;
    }
    

    public List<Fonction> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<Fonction> occupations) {
        this.occupations = occupations;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    
    

}
