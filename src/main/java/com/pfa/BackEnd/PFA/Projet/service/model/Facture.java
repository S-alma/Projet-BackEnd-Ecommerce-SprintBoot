package com.pfa.BackEnd.PFA.Projet.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor

public class Facture
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateFacture;
    private float totalFacture;
    private Date createdAt;
    private Date updatedAt;

    // Pour Commande
    @OneToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    public Facture(Long id, Date dateFacture, float totalFacture) {
        this.id = id;
        this.dateFacture = dateFacture;
        this.totalFacture = totalFacture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public float getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(float totalFacture) {
        this.totalFacture = totalFacture;
    }

    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
}
