package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.dao.PanierRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.PanierConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.PanierVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Panier;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePanier implements IServicePanier, CommandLineRunner
{
    @Autowired
    private PanierRepository panierRepository;

    @Override
    public List<PanierVo> getPaniers()
    {
        List<Panier> list = panierRepository.findAll();
        return PanierConverter.toListVo(list);
    }

    @Override
    public PanierVo getPanierById(Long panierVoId)
    {
        boolean trouve = panierRepository.existsById(panierVoId);
        if (!trouve)
            return null;
        return PanierConverter.toVo(panierRepository.getOne(panierVoId));
    }

    @Transactional
    @Override
    public void save(PanierVo panier)
    {
        panierRepository.save(PanierConverter.toBo(panier));
    }

    public PanierVo getProduitById(Long id)
    {
        boolean trouve = panierRepository.existsById(id);
        if (!trouve)
            return null;
        return PanierConverter.toVo(panierRepository.getOne(id));
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        panierRepository.deleteById(id);
    }

    @Override
    public List<PanierVo> findAll(int pageId, int size)
    {
        Page<Panier> result = panierRepository.findAll(PageRequest.of(pageId, size, Sort.by("name")));
        return PanierConverter.toListVo(result.getContent());
    }

    @Override
    public List<PanierVo> findById(Long id) {
        return null;
    }

    @Override
    public List<PanierVo> sortBy(String fieldName)
    {
        return PanierConverter.toListVo(panierRepository.findAll(Sort.by(fieldName)));
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        panierRepository.deleteAll();
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.print("C'est ServicePanier.java dans la méthode run");
    }
}
