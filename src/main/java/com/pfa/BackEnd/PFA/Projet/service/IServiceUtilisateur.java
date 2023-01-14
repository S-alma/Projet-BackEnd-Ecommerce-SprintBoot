package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.domaine.UtilisateurVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Utilisateur;

import java.util.List;

public interface IServiceUtilisateur
{
    List<UtilisateurVo> getUtilisateurs();

    void save(UtilisateurVo utilisateur);

    UtilisateurVo getUtilisateurById(Long id);

    void delete(Long id);

    List<UtilisateurVo> findAll(int pageId, int size);

    List<UtilisateurVo> sortBy(String fieldName);

    List<Utilisateur> findByRole(String role);

    void deleteAll();
}
