package com.pfa.BackEnd.PFA.Projet.dao;

import com.pfa.BackEnd.PFA.Projet.service.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long>
{

}
