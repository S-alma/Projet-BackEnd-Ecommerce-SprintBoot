package com.pfa.BackEnd.PFA.Projet.controller;

import com.pfa.BackEnd.PFA.Projet.dao.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FactureController
{
    @Autowired
    private FactureRepository factureRepository;
}
