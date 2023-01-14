package com.pfa.BackEnd.PFA.Projet.controller;

import com.pfa.BackEnd.PFA.Projet.domaine.CategorieVo;
import com.pfa.BackEnd.PFA.Projet.service.IServiceCategorie;
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

public class CategorieController
{
    @Autowired
    private IServiceCategorie serviceCategorie;

    @GetMapping(value = "/rest/categorie", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<CategorieVo> getAll() {
        return serviceCategorie.getCategories();
    }

    // Pour chercher un categorie par son id
    @GetMapping(value = "/rest/categorie/{id}")
    public ResponseEntity<Object> getCategorieById(@PathVariable(value = "id") Long categorieVoId) {
        CategorieVo categorieVoFound = serviceCategorie.getCategorieById(categorieVoId);
        if (categorieVoFound == null)
            return new ResponseEntity<>("La categorie n'existe pas", HttpStatus.OK);
        return new ResponseEntity<>(categorieVoFound, HttpStatus.OK);
    }

    // Pour créer un nouveau categorie
    @PostMapping(value = "/rest/categorie")
    public ResponseEntity<Object> createCategorie(@Validated @RequestBody CategorieVo categorieVo) {
        serviceCategorie.save(categorieVo);
        return new ResponseEntity<>("La categorie est créer avec succés", HttpStatus.CREATED);
    }

    // Pour modifier un produit par son id
    @PutMapping(value = "/rest/categorie/{id}")
    public ResponseEntity<Object> updateCategorie(@PathVariable(name = "id") Long categorieVoId, @RequestBody CategorieVo categorieVo) {
        CategorieVo categorieVoFound = serviceCategorie.getCategorieById(categorieVoId);
        if (categorieVoFound == null)
            return new ResponseEntity<>("La categorie n'existe pas", HttpStatus.OK);
        categorieVo.setId(categorieVoId);
        serviceCategorie.save(categorieVo);
        return new ResponseEntity<>("La categorie est modifier avec succés", HttpStatus.OK);
    }

    // Pour supprimer un categorie par son id
    @DeleteMapping(value = "/rest/categorie/{id}")
    public ResponseEntity<Object> deleteCategorie(@PathVariable(name = "id") Long categorieVoId) {
        CategorieVo categorieVoFound = serviceCategorie.getCategorieById(categorieVoId);
        if (categorieVoFound == null)
            return new ResponseEntity<>("La categorie n'existe pas", HttpStatus.OK);
        serviceCategorie.delete(categorieVoId);
        return new ResponseEntity<>("La categorie est supprimer avec succés", HttpStatus.OK);
    }

    // Pour chercher tous les categories
    @GetMapping(value = "/rest/sort/categorie/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<CategorieVo> sortBy(@PathVariable String fieldName) {
        return serviceCategorie.sortBy(fieldName);
    }

    // Afficher la liste des categories en utilisant la pagination
    @GetMapping("/rest/pagination/categorie/{pageid}/{size}")
    public List<CategorieVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return serviceCategorie.findAll(pageid, size);
    }
}
