package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.domaine.CategorieVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Categorie;

import java.util.List;

public interface IServiceCategorie
{
    List<CategorieVo> getCategories();

    void save(CategorieVo categorie);

    CategorieVo getCategorieById(Long id);

    void delete(Long id);

    List<CategorieVo> findAll(int pageId, int size);

    List<CategorieVo> sortBy(String fieldName);

    List<Categorie> findByNom(String nom);

    void deleteAll();
}
