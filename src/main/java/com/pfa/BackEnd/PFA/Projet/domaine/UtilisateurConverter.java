package com.pfa.BackEnd.PFA.Projet.domaine;

import com.pfa.BackEnd.PFA.Projet.service.model.Utilisateur;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurConverter
{
    public static List<UtilisateurVo> toListVo(List<Utilisateur> listBo)
    {
        List<UtilisateurVo> listVo = new ArrayList<>();
        for (Utilisateur utilisateur : listBo) {
            listVo.add(toVo(utilisateur));
        }
        return listVo;
    }

    public static UtilisateurVo toVo(Utilisateur bo)
    {
        if (bo == null || bo.getId() ==null)
            return null;
        UtilisateurVo vo = new UtilisateurVo();
        vo.setId(bo.getId());
        vo.setNom(bo.getNom());
        vo.setPrenom(bo.getPrenom());
        vo.setCin(bo.getCin());
        vo.setDateNaissance(bo.getDateNaissance());
        vo.setAdresse(bo.getAdresse());
        vo.setNumeroTelephone(bo.getNumeroTelephone());
        vo.setRib(bo.getRib());
        vo.setEmail(bo.getEmail());
        vo.setMotDePasse(bo.getMotDePasse());
        vo.setRole(bo.getRole());
        return vo;
    }

    public static Utilisateur toBo(UtilisateurVo vo) {
        Utilisateur bo = new Utilisateur();
        bo.setId(vo.getId());
        bo.setNom(vo.getNom());
        bo.setPrenom(vo.getPrenom());
        bo.setCin(vo.getCin());
        bo.setDateNaissance(vo.getDateNaissance());
        bo.setAdresse(vo.getAdresse());
        bo.setNumeroTelephone(vo.getNumeroTelephone());
        bo.setRib(vo.getRib());
        bo.setEmail(vo.getEmail());
        bo.setMotDePasse(vo.getMotDePasse());
        bo.setRole(vo.getRole());
        return bo;
    }
}