package com.pfa.BackEnd.PFA.Projet.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")

public class Produit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private float prixUnitaire;
    private int stock;
    private String description;
    private String image;
    private Date createdAt;
    private Date updatedAt;

    // Pour categorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    @JsonBackReference
    private Categorie categorie;

    // Pour panier
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Produit_Panier",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "panier_id"))
    private List<Panier> paniers = new ArrayList<>();

    // Pour commande
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Produit_Commande",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "commande_id"))
    private List<Commande> commandes = new ArrayList<>();

    public Produit(Long id, String nom, float prixUnitaire, int stock, String description, String image) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.stock = stock;
        this.description = description;
        this.image = image;
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

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
}