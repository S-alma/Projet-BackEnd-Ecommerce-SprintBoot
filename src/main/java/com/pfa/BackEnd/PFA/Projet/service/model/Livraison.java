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

public class Livraison
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateLivraison;
    private Date createdAt;
    private Date updatedAt;

    // Pour commande
    @OneToMany(mappedBy = "livraison", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Commande> commandes = new ArrayList<>();

    public Livraison(Long id, Date dateLivraison) {
        this.id = id;
        this.dateLivraison = dateLivraison;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
}
