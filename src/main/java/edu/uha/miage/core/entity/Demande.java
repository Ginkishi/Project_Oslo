package edu.uha.miage.core.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author GreyFox
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String sujet;

    @NotNull
    private String description;

    @NotNull
    @Min(1)
    @Max(10)
    private int importance;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_creation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_cloture;

    @ManyToOne
    private StatutDemande statut_demande;
    
    @ManyToOne
    private Personne createur;
    
    @ManyToMany
    @JoinTable(
            name = "intervient",
            joinColumns = @JoinColumn(name = "demande_id"),
            inverseJoinColumns = @JoinColumn(name = "personne_id"))
    List<Personne> intervenants;

    
    
    public Demande() {
    }

    public Demande(String sujet, String description, Date date_creation) {
        this.sujet = sujet;
        this.description = description;
        this.date_creation = date_creation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_cloture() {
        return date_cloture;
    }

    public void setDate_cloture(Date date_cloture) {
        this.date_cloture = date_cloture;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public StatutDemande getStatut_demande() {
        return statut_demande;
    }

    public void setStatut_demande(StatutDemande statut_demande) {
        this.statut_demande = statut_demande;
    }

    public Personne getCreateur() {
        return createur;
    }

    public void setCreateur(Personne createur) {
        this.createur = createur;
    }

    public List<Personne> getIntervenants() {
        return intervenants;
    }

    public void setIntervenants(List<Personne> intervenants) {
        this.intervenants = intervenants;
    }
    
    

}
