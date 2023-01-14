package com.pfa.BackEnd.PFA.Projet.service;

import com.pfa.BackEnd.PFA.Projet.dao.UtilisateurRepository;
import com.pfa.BackEnd.PFA.Projet.domaine.UtilisateurConverter;
import com.pfa.BackEnd.PFA.Projet.domaine.UtilisateurVo;
import com.pfa.BackEnd.PFA.Projet.service.model.Utilisateur;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUtilisateur implements IServiceUtilisateur, CommandLineRunner
{
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<UtilisateurVo> getUtilisateurs()
    {
        List<Utilisateur> list = utilisateurRepository.findAll();
        return UtilisateurConverter.toListVo(list);
    }

    @Transactional
    @Override
    public void save(UtilisateurVo utilisateur)
    {
        utilisateurRepository.save(UtilisateurConverter.toBo(utilisateur));
    }

    @Override
    public UtilisateurVo getUtilisateurById(Long id)
    {
        boolean trouve = utilisateurRepository.existsById(id);
        if (!trouve)
            return null;
        return UtilisateurConverter.toVo(utilisateurRepository.getOne(id));
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<UtilisateurVo> findAll(int pageId, int size)
    {
        Page<Utilisateur> result = utilisateurRepository.findAll(PageRequest.of(pageId, size, Sort.by("name")));
        return UtilisateurConverter.toListVo(result.getContent());
    }

    @Override
    public List<UtilisateurVo> sortBy(String fieldName)
    {
        return UtilisateurConverter.toListVo(utilisateurRepository.findAll(Sort.by(fieldName)));
    }

    @Override
    public List<Utilisateur> findByRole(String role){
        List<Utilisateur> list = utilisateurRepository.findByRole(role);
        return list;
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        utilisateurRepository.deleteAll();
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.print("C'est ServiceUtilisateur.java dans la méthode run");
    }
}
