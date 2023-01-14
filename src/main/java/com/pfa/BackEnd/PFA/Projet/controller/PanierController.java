package com.pfa.BackEnd.PFA.Projet.controller;

import com.pfa.BackEnd.PFA.Projet.domaine.PanierVo;
import com.pfa.BackEnd.PFA.Projet.service.IServicePanier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class PanierController
{
    @Autowired
    private IServicePanier servicePanier;

    @GetMapping(value = "/rest/panier", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<PanierVo> getAll() {
        return servicePanier.getPaniers();
    }

    // Pour chercher un panier par son id
    @GetMapping(value = "/rest/panier/{id}")
    public ResponseEntity<Object> getPanierById(@PathVariable(value = "id") Long panierVoId) {
        PanierVo panierVoFound = servicePanier.getPanierById(panierVoId);
        if (panierVoFound == null)
            return new ResponseEntity<>("Le panier n'existe pas", HttpStatus.OK);
        return new ResponseEntity<>(panierVoFound, HttpStatus.OK);
    }

    // Pour créer un nouveau panier
    @PostMapping(value = "/rest/panier")
    public ResponseEntity<Object> createPanier(@Validated @RequestBody PanierVo panierVo) {
        servicePanier.save(panierVo);
        return new ResponseEntity<>("Le panier est créer avec succés", HttpStatus.CREATED);
    }

    // Pour modifier un panier par son id
    @PutMapping(value = "/rest/panier/{id}")
    public ResponseEntity<Object> updatePanier(@PathVariable(name = "id") Long panierVoId, @RequestBody PanierVo panierVo) {
        PanierVo panierVoFound = servicePanier.getPanierById(panierVoId);
        if (panierVoFound == null)
            return new ResponseEntity<>("Le panier n'existe pas", HttpStatus.OK);
        panierVo.setId(panierVoId);
        servicePanier.save(panierVo);
        return new ResponseEntity<>("Le panier est modifier avec succés", HttpStatus.OK);
    }

    // Pour supprimer un panier par son id
    @DeleteMapping(value = "/rest/panier/{id}")
    public ResponseEntity<Object> deletePanier(@PathVariable(name = "id") Long panierVoId) {
        PanierVo panierVoFound = servicePanier.getPanierById(panierVoId);
        if (panierVoFound == null)
            return new ResponseEntity<>("Le panier n'existe pas", HttpStatus.OK);
        servicePanier.delete(panierVoId);
        return new ResponseEntity<>("Le panier est supprimer avec succés", HttpStatus.OK);
    }

    // Pour chercher tous les paniers
    @GetMapping(value = "/rest/sort/panier/{fieldName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<PanierVo> sortBy(@PathVariable String fieldName) {
        return servicePanier.sortBy(fieldName);
    }

    // Afficher la liste des paniers en utilisant la pagination
    @GetMapping("/rest/pagination/panier/{pageid}/{size}")
    public List<PanierVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return servicePanier.findAll(pageid, size);
    }
}
