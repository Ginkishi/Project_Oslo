/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Lilian
 */
@Entity
public class DemandeIncident extends Demande implements Serializable {

    @NotNull
    private String localisation;



    @ManyToOne
    @JoinColumn(name = "incident_id", referencedColumnName = "id")
    private Incident incident;

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public DemandeIncident(String localisation, String sujet, String description, Date date_creation) {
        super(sujet, description, date_creation);
        this.localisation = localisation;
    }

    public DemandeIncident() {
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }


    
}
