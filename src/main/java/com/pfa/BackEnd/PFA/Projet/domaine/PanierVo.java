package com.pfa.BackEnd.PFA.Projet.domaine;

import com.pfa.BackEnd.PFA.Projet.service.model.Produit;
import com.pfa.BackEnd.PFA.Projet.service.model.Utilisateur;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class PanierVo
{
    private Long id;
    private int quantite;
    private float prixTotal;
    private Date dateCommande;
    private List<Produit> produits = new ArrayList<>();
    private Utilisateur utilisateur;

    public PanierVo(Long id, int quantite, float prixTotal, Date dateCommande, List<Produit> produits, Utilisateur utilisateur) {
        this.id = id;
        this.quantite = quantite;
        this.prixTotal = prixTotal;
        this.dateCommande = dateCommande;
        this.produits = produits;
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
