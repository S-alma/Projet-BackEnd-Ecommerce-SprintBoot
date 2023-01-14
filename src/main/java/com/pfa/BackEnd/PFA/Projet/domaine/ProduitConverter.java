package com.pfa.BackEnd.PFA.Projet.domaine;

import com.pfa.BackEnd.PFA.Projet.service.model.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitConverter
{
    public static List<ProduitVo> toListVo(List<Produit> listBo)
    {
        List<ProduitVo> listVo = new ArrayList<>();
        for (Produit produit : listBo) {
            listVo.add(toVo(produit));
        }
        return listVo;
    }

    public static ProduitVo toVo(Produit bo)
    {
        if (bo == null || bo.getId() ==null)
            return null;
        ProduitVo vo = new ProduitVo();
        vo.setId(bo.getId());
        vo.setNom(bo.getNom());
        vo.setPrixUnitaire(bo.getPrixUnitaire());
        vo.setStock(bo.getStock());
        vo.setDescription(bo.getDescription());
        vo.setImage(bo.getImage());
        vo.setCategorie(bo.getCategorie());
        vo.setPaniers(bo.getPaniers());
        vo.setCommandes(bo.getCommandes());
        return vo;
    }

    public static Produit toBo(ProduitVo vo)
    {
        Produit bo = new Produit();
        bo.setId(vo.getId());
        bo.setNom(vo.getNom());
        bo.setPrixUnitaire(vo.getPrixUnitaire());
        bo.setStock(vo.getStock());
        bo.setDescription(vo.getDescription());
        bo.setImage(vo.getImage());
        bo.setCategorie(vo.getCategorie());
        bo.setPaniers(vo.getPaniers());
        bo.setCommandes(vo.getCommandes());
        return bo;
    }
}
