package com.pfa.BackEnd.PFA.Projet.dao;

import com.pfa.BackEnd.PFA.Projet.service.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison, Long>
{
    List<Livraison> findByDateLivraison(Date dateLivraison);
}
