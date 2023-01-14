package com.pfa.BackEnd.PFA.Projet.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor

public class LivraisonVo
{
    private Long id;
    private Date dateLivraison;

    public LivraisonVo(Long id, Date dateLivraison) {
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
}
