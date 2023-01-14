package com.pfa.BackEnd.PFA.Projet.controller;

import com.pfa.BackEnd.PFA.Projet.domaine.ProduitVo;
import com.pfa.BackEnd.PFA.Projet.service.IServiceProduit;
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

public class ProduitController
{
    @Autowired
    private IServiceProduit serviceProduit;

    @GetMapping(value = "/rest/produit", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ProduitVo> getAll() {
        return serviceProduit.getProduits();
    }

    // Pour chercher un produit par son id
    @GetMapping(value = "/rest/produit/{id}")
    public ResponseEntity<Object> getProduitById(@PathVariable(value = "id") Long produitVoId) {
        ProduitVo produitVoFound = serviceProduit.getProduitById(produitVoId);
        if (produitVoFound == null)
            return new ResponseEntity<>("Le produit n'existe pas", HttpStatus.OK);
        return new ResponseEntity<>(produitVoFound, HttpStatus.OK);
    }

    // Pour créer un nouveau produit
    @PostMapping(value = "/rest/produit")
    public ResponseEntity<Object> createProduit(@Validated @RequestBody ProduitVo produitVo) {
        serviceProduit.save(produitVo);
        return new ResponseEntity<>("Le produit est créer avec succés", HttpStatus.CREATED);
    }

    // Pour modifier un produit par son id
    @PutMapping(value = "/rest/produit/{id}")
    public ResponseEntity<Object> updateProduit(@PathVariable(name = "id") Long produitVoId, @RequestBody ProduitVo produitVo) {
        ProduitVo produitVoFound = serviceProduit.getProduitById(produitVoId);
        if (produitVoFound == null)
            return new ResponseEntity<>("Le produit n'existe pas", HttpStatus.OK);
        produitVo.setId(produitVoId);
        serviceProduit.save(produitVo);
        return new ResponseEntity<>("Le produit est modifier avec succés", HttpStatus.OK);
    }

    // Pour supprimer un produit par son id
    @DeleteMapping(value = "/rest/produit/{id}")
    public ResponseEntity<Object> deleteProduit(@PathVariable(name = "id") Long produitVoId) {
        ProduitVo produitVoFound = serviceProduit.getProduitById(produitVoId);
        if (produitVoFound == null)
            return new ResponseEntity<>("Le produit n'existe pas", HttpStatus.OK);
        serviceProduit.delete(produitVoId);
        return new ResponseEntity<>("Le produit est supprimer avec succés", HttpStatus.OK);
    }

    // Pour chercher tous les produits
    @GetMapping(value = "/rest/sort/produit/{fieldName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ProduitVo> sortBy(@PathVariable String fieldName) {
        return serviceProduit.sortBy(fieldName);
    }

    // Afficher la liste des produits en utilisant la pagination
    @GetMapping("/rest/pagination/produit/{pageid}/{size}")
    public List<ProduitVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return serviceProduit.findAll(pageid, size);
    }

    // Afficher afficher la liste des produits par categorie
    @GetMapping(value = "/rest/produitbycategorie/{categorie}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ProduitVo> getByCategorie(@PathVariable(value = "id") Long produitVoCategorieId) {
        return serviceProduit.findByCategorie(produitVoCategorieId);
    }
}
