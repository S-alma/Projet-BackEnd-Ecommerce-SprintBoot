package com.pfa.BackEnd.PFA.Projet.dao;

import com.pfa.BackEnd.PFA.Projet.service.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Long>
{
    List<Utilisateur> findByRole(String role);
}
