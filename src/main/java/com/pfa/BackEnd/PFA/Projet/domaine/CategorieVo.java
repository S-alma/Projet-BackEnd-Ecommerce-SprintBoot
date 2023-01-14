package com.pfa.BackEnd.PFA.Projet.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor

public class CategorieVo
{
    private Long id;
    private String nom;

    public CategorieVo(Long id, String nom)
    {
        this.id = id;
        this.nom = nom;
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
}
