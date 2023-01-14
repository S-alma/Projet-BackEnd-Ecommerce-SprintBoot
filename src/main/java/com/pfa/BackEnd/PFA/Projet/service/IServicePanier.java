package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.domaine.PanierVo;

import java.util.List;

public interface IServicePanier
{
    List<PanierVo> getPaniers();
    PanierVo getPanierById(Long panierVoId);

    void save(PanierVo panierVo);

    void delete(Long panierVoId);

    List<PanierVo> sortBy(String fieldName);

    List<PanierVo> findAll(int pageid, int size);

    List<PanierVo> findById(Long id);

    void deleteAll();
}
