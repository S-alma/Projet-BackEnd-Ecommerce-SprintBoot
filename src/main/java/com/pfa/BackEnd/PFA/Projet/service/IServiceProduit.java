package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.domaine.ProduitVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Produit;

import java.util.List;

public interface IServiceProduit
{
    List<ProduitVo> getProduits();

    void save(ProduitVo produit);

    ProduitVo getProduitById(Long id);

    void delete(Long id);

    List<ProduitVo> findAll(int pageId, int size);

    List<ProduitVo> sortBy(String fieldName);

    List<ProduitVo> findByCategorie(Long categorie);

    void deleteAll();
}
