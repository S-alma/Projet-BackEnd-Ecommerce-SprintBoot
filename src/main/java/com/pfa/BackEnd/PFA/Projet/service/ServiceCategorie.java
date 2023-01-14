package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.dao.CategorieRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.CategorieConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.CategorieVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Categorie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategorie implements IServiceCategorie, CommandLineRunner
{
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<CategorieVo> getCategories()
    {
        List<Categorie> list = categorieRepository.findAll();
        return CategorieConverter.toListVo(list);
    }

    @Transactional
    @Override
    public void save(CategorieVo categorie)
    {
        categorieRepository.save(CategorieConverter.toBo(categorie));
    }

    @Override
    public CategorieVo getCategorieById(Long id)
    {
        boolean trouve = categorieRepository.existsById(id);
        if (!trouve)
            return null;
        return CategorieConverter.toVo(categorieRepository.getOne(id));
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        categorieRepository.deleteById(id);
    }

    @Override
    public List<CategorieVo> findAll(int pageId, int size)
    {
        Page<Categorie> result = categorieRepository.findAll(PageRequest.of(pageId, size, Sort.by("name")));
        return CategorieConverter.toListVo(result.getContent());
    }

    @Override
    public List<CategorieVo> sortBy(String fieldName)
    {
        return CategorieConverter.toListVo(categorieRepository.findAll(Sort.by(fieldName)));
    }

    @Override
    public List<Categorie> findByNom(String nom){
        List<Categorie> list = categorieRepository.findByNom(nom);
        return list;
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        categorieRepository.deleteAll();
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.print("C'est ServiceCategorie.java dans la méthode run");
    }

}
