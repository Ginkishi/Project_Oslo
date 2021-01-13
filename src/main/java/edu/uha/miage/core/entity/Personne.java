package edu.uha.miage.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nom;

    @NotNull
    @Size(min = 2, max = 50)
    private String prenom;


    private String adresse;

    private String email;

    @ManyToMany(mappedBy = "occupationDePersonne")
    private List<Fonction> occupations;
    
        @OneToMany(mappedBy = "createur")
    private List<Demande> demandes;
    
        
    @ManyToMany(mappedBy = "intervenants")
    List<Demande> demandeIntervenu;
        
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

    public List<Demande> getDemandeIntervenu() {
        return demandeIntervenu;
    }

    public void setDemandeIntervenu(List<Demande> demandeIntervenu) {
        this.demandeIntervenu = demandeIntervenu;
    }

    
    

}
