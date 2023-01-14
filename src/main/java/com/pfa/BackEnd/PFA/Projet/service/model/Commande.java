package com.pfa.BackEnd.PFA.Projet.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Commande
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float sommeTotal;
    private int quantite;
    private Date dateCommande;
    private Date createdAt;
    private Date updatedAt;

    // Pour facture
    @OneToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

    // Pour livraison
    @ManyToOne
    @JoinColumn(name = "livraison_id")
    private Livraison livraison;

    // Pour utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    // Pour produit
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Commande_Produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private List<Produit> produits = new ArrayList<>();

    public Commande(Long id, float sommeTotal, int quantite, Date dateCommande) {
        this.id = id;
        this.sommeTotal = sommeTotal;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSommeTotal() {
        return sommeTotal;
    }

    public void setSommeTotal(float sommeTotal) {
        this.sommeTotal = sommeTotal;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
}
