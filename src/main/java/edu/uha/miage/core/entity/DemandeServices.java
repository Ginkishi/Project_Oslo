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
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lilian
 */
@Entity
public class DemandeServices extends Demande implements Serializable{
    
    @OneToOne
    @JoinColumn(name = "services_id", referencedColumnName = "id")
    private Services service;
    
    @Min(0)
    @Max(10)
    @NotNull
    int priorite;

    public DemandeServices() {
    }

    public DemandeServices(String sujet, String description, Date date_creation) {
        super(sujet, description, date_creation);
    }
    
    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
    
    public void setPriorite(int v) {
        this.priorite = v;
    }
    
    public int getPriorite() {
        return this.priorite;
    }
}
