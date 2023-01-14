package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.dao.LivraisonRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.LivraisonConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.LivraisonVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Livraison;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ServiceLivraison implements IServiceLivraison, CommandLineRunner
{
    @Autowired
    private LivraisonRepository livraisonRepository;

    @Override
    public List<LivraisonVo> getLivraisons()
    {
        List<Livraison> list = livraisonRepository.findAll();
        return LivraisonConverter.toListVo(list);
    }

    @Transactional
    @Override
    public void save(LivraisonVo livraison)
    {
        livraisonRepository.save(LivraisonConverter.toBo(livraison));
    }

    @Override
    public LivraisonVo getLivraisonById(Long id)
    {
        boolean trouve = livraisonRepository.existsById(id);
        if (!trouve)
            return null;
        return LivraisonConverter.toVo(livraisonRepository.getOne(id));
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        livraisonRepository.deleteById(id);
    }

    @Override
    public List<LivraisonVo> findAll(int pageId, int size)
    {
        Page<Livraison> result = livraisonRepository.findAll(PageRequest.of(pageId, size, Sort.by("name")));
        return LivraisonConverter.toListVo(result.getContent());
    }

    @Override
    public List<LivraisonVo> sortBy(String fieldName)
    {
        return LivraisonConverter.toListVo(livraisonRepository.findAll(Sort.by(fieldName)));
    }

    @Override
    public List<Livraison> findByDateLivraison(Date dateLivraison){
        List<Livraison> list = livraisonRepository.findByDateLivraison(dateLivraison);
        return list;
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        livraisonRepository.deleteAll();
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.print("C'est ServiceLivraison.java dans la méthode run");
    }
}
