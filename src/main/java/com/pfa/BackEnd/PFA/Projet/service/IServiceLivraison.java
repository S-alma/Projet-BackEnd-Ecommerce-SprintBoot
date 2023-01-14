package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.domaine.LivraisonVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Livraison;

import java.sql.Date;
import java.util.List;

public interface IServiceLivraison
{
    List<LivraisonVo> getLivraisons();

    LivraisonVo getLivraisonById(Long id);

    void save(LivraisonVo livraisonVo);

    void delete(Long id);

    List<LivraisonVo> sortBy(String fieldName);

    List<LivraisonVo> findAll(int pageid, int size);

    List<Livraison> findByDateLivraison(Date dateLivraison);

    void deleteAll();
}
