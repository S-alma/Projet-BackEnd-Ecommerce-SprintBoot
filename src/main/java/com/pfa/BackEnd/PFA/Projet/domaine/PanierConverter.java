package com.pfa.BackEnd.PFA.Projet.domaine;

import com.pfa.BackEnd.PFA.Projet.service.model.Panier;
import java.util.ArrayList;
import java.util.List;

public class PanierConverter
{
    public static List<PanierVo> toListVo(List<Panier> listBo)
    {
        List<PanierVo> listVo = new ArrayList<>();
        for (Panier panier : listBo) {
            listVo.add(toVo(panier));
        }
        return listVo;
    }

    public static PanierVo toVo(Panier bo)
    {
        if (bo == null || bo.getId() ==null)
            return null;
        PanierVo vo = new PanierVo();
        vo.setId(bo.getId());
        vo.setQuantite(bo.getQuantite());
        vo.setPrixTotal(bo.getPrixTotal());
        vo.setDateCommande(bo.getDateCommande());
        vo.setProduits(bo.getProduits());
        vo.setUtilisateur(bo.getUtilisateur());
        return vo;
    }

    public static Panier toBo(PanierVo vo)
    {
        Panier bo = new Panier();
        bo.setId(vo.getId());
        bo.setQuantite(vo.getQuantite());
        bo.setPrixTotal(vo.getPrixTotal());
        bo.setDateCommande(vo.getDateCommande());
        bo.setProduits(vo.getProduits());
        bo.setUtilisateur(vo.getUtilisateur());
        return bo;
    }
}
