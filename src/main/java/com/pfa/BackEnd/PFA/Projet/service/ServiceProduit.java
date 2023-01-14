package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.dao.ProduitRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.ProduitConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.ProduitVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Produit;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduit implements IServiceProduit, CommandLineRunner
{
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<ProduitVo> getProduits()
    {
        List<Produit> list = produitRepository.findAll();
        return ProduitConverter.toListVo(list);
    }

    @Transactional
    @Override
    public void save(ProduitVo produit)
    {
        produitRepository.save(ProduitConverter.toBo(produit));
    }

    @Override
    public ProduitVo getProduitById(Long id)
    {
        boolean trouve = produitRepository.existsById(id);
        if (!trouve)
            return null;
        return ProduitConverter.toVo(produitRepository.getOne(id));
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        produitRepository.deleteById(id);
    }

    @Override
    public List<ProduitVo> findAll(int pageId, int size)
    {
        Page<Produit> result = produitRepository.findAll(PageRequest.of(pageId, size, Sort.by("name")));
        return ProduitConverter.toListVo(result.getContent());
    }

    @Override
    public List<ProduitVo> sortBy(String fieldName)
    {
        return ProduitConverter.toListVo(produitRepository.findAll(Sort.by(fieldName)));
    }

    @Override
    public List<ProduitVo> findByCategorie(Long categorie){
        List<Produit> list = produitRepository.findByCategorie(categorie);
        return ProduitConverter.toListVo(list);
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        produitRepository.deleteAll();
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.print("C'est ServiceProduit.java dans la méthode run");
    }
}
