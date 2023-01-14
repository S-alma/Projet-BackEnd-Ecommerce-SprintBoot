package com.pfa.BackEnd.PFA.Projet.domaine;

import com.pfa.BackEnd.PFA.Projet.service.model.Categorie;
import com.pfa.BackEnd.PFA.Projet.service.model.Commande;
import com.pfa.BackEnd.PFA.Projet.service.model.Panier;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class ProduitVo
{
    private Long id;
    private String nom;
    private float prixUnitaire;
    private int stock;
    private String description;
    private String image;

    private Categorie categorie;
    private List<Panier> paniers = new ArrayList<>();
    private List<Commande> commandes = new ArrayList<>();

    public ProduitVo(Long id, String nom, float prixUnitaire, int stock, String description, String image, Categorie categorie, List<Panier> paniers, List<Commande> commandes) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.stock = stock;
        this.description = description;
        this.image = image;
        this.categorie = categorie;
        this.paniers = paniers;
        this.commandes = commandes;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<Panier> paniers) {
        this.paniers = paniers;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
