package com.pfa.BackEnd.PFA.Projet.dao;

import com.pfa.BackEnd.PFA.Projet.service.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long>
{
    List<Produit> findByCategorie(Long categorie);
}
