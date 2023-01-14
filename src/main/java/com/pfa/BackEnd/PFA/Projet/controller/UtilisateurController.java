package com.pfa.BackEnd.PFA.Projet.controller;

import com.pfa.BackEnd.PFA.Projet.domaine.UtilisateurVo;
import com.pfa.BackEnd.PFA.Projet.service.IServiceUtilisateur;
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

public class UtilisateurController
{
    @Autowired
    private IServiceUtilisateur serviceUtilisateur;

    @GetMapping(value = "/rest/utilisateur", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<UtilisateurVo> getAll() {
        return serviceUtilisateur.getUtilisateurs();
    }

     // Pour chercher un utilisateur par son id
    @GetMapping(value = "/rest/utilisateur/{id}")
    public ResponseEntity<Object> getUtilisateurById(@PathVariable(value = "id") Long utilisateurVoId) {
        UtilisateurVo utilisateurVoFound = serviceUtilisateur.getUtilisateurById(utilisateurVoId);
        if (utilisateurVoFound == null)
            return new ResponseEntity<>("L'utilisateur n'existe pas", HttpStatus.OK);
        return new ResponseEntity<>(utilisateurVoFound, HttpStatus.OK);
    }

    // Pour créer un nouveau utilisateur
    @PostMapping(value = "/rest/utilisateur")
    public ResponseEntity<Object> createUtilisateur(@Validated @RequestBody UtilisateurVo utilisateurVo) {
        serviceUtilisateur.save(utilisateurVo);
        return new ResponseEntity<>("L'utilisateur est créer avec succés", HttpStatus.CREATED);
    }

    // Pour modifier un produit par son id
    @PutMapping(value = "/rest/utilisateur/{id}")
    public ResponseEntity<Object> updateUtilisateur(@PathVariable(name = "id") Long utilisateurVoId, @RequestBody UtilisateurVo utilisateurVo) {
        UtilisateurVo utilisateurVoFound = serviceUtilisateur.getUtilisateurById(utilisateurVoId);
        if (utilisateurVoFound == null)
            return new ResponseEntity<>("L'utilisateur n'existe pas", HttpStatus.OK);
        utilisateurVo.setId(utilisateurVoId);
        serviceUtilisateur.save(utilisateurVo);
        return new ResponseEntity<>("L'utilisateur est modifier avec succés", HttpStatus.OK);
    }

    // Pour supprimer un utilisateur par son id
    @DeleteMapping(value = "/rest/utilisateur/{id}")
    public ResponseEntity<Object> deleteUtilisateur(@PathVariable(name = "id") Long utilisateurVoId) {
        UtilisateurVo utilisateurVoFound = serviceUtilisateur.getUtilisateurById(utilisateurVoId);
        if (utilisateurVoFound == null)
            return new ResponseEntity<>("L'utilisateur n'existe pas", HttpStatus.OK);
        serviceUtilisateur.delete(utilisateurVoId);
        return new ResponseEntity<>("L'utilisateur est supprimer avec succés", HttpStatus.OK);
    }

    // Pour chercher tous les utilisateurs
    @GetMapping(value = "/rest/sort/utilisateur/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<UtilisateurVo> sortBy(@PathVariable String fieldName) {
        return serviceUtilisateur.sortBy(fieldName);
    }

    // Afficher la liste des utilisateurs en utilisant la pagination
    @GetMapping("/rest/pagination/utilisateur/{pageid}/{size}")
    public List<UtilisateurVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return serviceUtilisateur.findAll(pageid, size);
    }
}
