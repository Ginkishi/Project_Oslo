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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author GreyFox
 */
@Entity
public class DemandeServices extends Demande implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "services_id", referencedColumnName = "id")
    private Services service;

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
}
