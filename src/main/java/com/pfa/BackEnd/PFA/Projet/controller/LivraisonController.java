package com.pfa.BackEnd.PFA.Projet.controller;

import com.pfa.BackEnd.PFA.Projet.domaine.LivraisonVo;
import com.pfa.BackEnd.PFA.Projet.service.IServiceLivraison;
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

public class LivraisonController
{
    @Autowired
    private IServiceLivraison serviceLivraison;

    @GetMapping(value = "/rest/livraison", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LivraisonVo> getAll() {
        return serviceLivraison.getLivraisons();
    }

    // Pour chercher une livraison par son id
    @GetMapping(value = "/rest/livraison/{id}")
    public ResponseEntity<Object> getLivraisonById(@PathVariable(value = "id") Long livraisonVoId) {
        LivraisonVo livraisonVoFound = serviceLivraison.getLivraisonById(livraisonVoId);
        if (livraisonVoFound == null)
            return new ResponseEntity<>("La livraison n'existe pas", HttpStatus.OK);
        return new ResponseEntity<>(livraisonVoFound, HttpStatus.OK);
    }

    // Pour créer une nouvelle livraison
    @PostMapping(value = "/rest/livraison")
    public ResponseEntity<Object> createLivraison(@Validated @RequestBody LivraisonVo livraisonVo) {
        serviceLivraison.save(livraisonVo);
        return new ResponseEntity<>("La livraison est créer avec succés", HttpStatus.CREATED);
    }

    // Pour modifier une livraison par son id
    @PutMapping(value = "/rest/livraison/{id}")
    public ResponseEntity<Object> updateLivraison(@PathVariable(name = "id") Long livraisonVoId, @RequestBody LivraisonVo livraisonVo) {
        LivraisonVo livraisonVoFound = serviceLivraison.getLivraisonById(livraisonVoId);
        if (livraisonVoFound == null)
            return new ResponseEntity<>("La livraison n'existe pas", HttpStatus.OK);
        livraisonVo.setId(livraisonVoId);
        serviceLivraison.save(livraisonVo);
        return new ResponseEntity<>("La livraison est modifier avec succés", HttpStatus.OK);
    }

    // Pour supprimer une livraison par son id
    @DeleteMapping(value = "/rest/livraison/{id}")
    public ResponseEntity<Object> deleteLivraison(@PathVariable(name = "id") Long livraisonVoId) {
        LivraisonVo livraisonVoFound = serviceLivraison.getLivraisonById(livraisonVoId);
        if (livraisonVoFound == null)
            return new ResponseEntity<>("La livraison n'existe pas", HttpStatus.OK);
        serviceLivraison.delete(livraisonVoId);
        return new ResponseEntity<>("La livraison est supprimer avec succés", HttpStatus.OK);
    }

    // Pour chercher tous les livraisons
    @GetMapping(value = "/rest/sort/livraison/{fieldName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LivraisonVo> sortBy(@PathVariable String fieldName) {
        return serviceLivraison.sortBy(fieldName);
    }

    // Afficher la liste des livraisons en utilisant la pagination
    @GetMapping("/rest/pagination/livraison/{pageid}/{size}")
    public List<LivraisonVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return serviceLivraison.findAll(pageid, size);
    }
}
