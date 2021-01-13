/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.entity;

import edu.uha.miage.config.SecurityUser;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author victo
 */
@Entity
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 25)
    // Nom d'utilisateur
    private String username;

    @NotNull
    @Size(min = 8)
    // Mot de passe
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "personne_id")
    Personne personne;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    public Compte(String username, String password, Personne personne, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.personne = personne;
        this.role = role;
    }

    public Compte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserDetails currentDetails() {
        return SecurityUser.create(this);
    }
}
