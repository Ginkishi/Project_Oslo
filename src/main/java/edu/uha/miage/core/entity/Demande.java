/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Lilian
 */
@MappedSuperclass
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_creation;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_cloture;

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
    
    
    
}
