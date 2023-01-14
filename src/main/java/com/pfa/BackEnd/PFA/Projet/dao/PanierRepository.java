package com.pfa.BackEnd.PFA.Projet.dao;

import com.pfa.BackEnd.PFA.Projet.service.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier, Long>
{

}
