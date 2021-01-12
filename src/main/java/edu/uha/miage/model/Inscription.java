/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.model;

import edu.uha.miage.core.entity.Role;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.passay.PasswordData;

/**
 *
 * @author victo
 */
public class Inscription implements Serializable {

    @NotNull
    @Size(min = 2, max = 25, message ="Le nom d'utilisateur doit être entre 2 et 25 caractères")
    private String username;

    @NotNull
    @Size(min = 8, message ="Le mot de passe doit être de minimum 8 caractères")
    private String password;

    @NotNull
    @Size(min = 8, message ="Le mot de passe doit être pareil")

    private String confirmPassword;

    private PasswordData passwordData;

    @NotNull
    @Size(min = 2, max = 50)
    // Nom de la Personne
    private String nom;

    @NotNull
    @Size(min = 2, max = 50)
    // Prénom de la Personne
    private String prenom;

    @NotNull
    @Size(min = 2, max = 50)
    // Adresse de la Personne
    private String adresse;

    @Email
    @NotNull
    @Size(min = 2, max = 50)
    // Email de la Personne
    private String email;

    public boolean isSafe() {
        passwordData = new PasswordData(username, password);
        return true;
    }

    public boolean isSame() {
        return password.equals(confirmPassword);
    }

    public Inscription() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

}
