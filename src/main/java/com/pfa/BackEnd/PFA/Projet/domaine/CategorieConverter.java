package com.pfa.BackEnd.PFA.Projet.domaine;

import com.pfa.BackEnd.PFA.Projet.service.model.Categorie;
import java.util.ArrayList;
import java.util.List;

public class CategorieConverter
{
    public static List<CategorieVo> toListVo(List<Categorie> listBo)
    {
        List<CategorieVo> listVo = new ArrayList<>();
        for (Categorie categorie : listBo) {
            listVo.add(toVo(categorie));
        }
        return listVo;
    }

    public static CategorieVo toVo(Categorie bo)
    {
        if (bo == null || bo.getId() ==null)
            return null;
        CategorieVo vo = new CategorieVo();
        vo.setId(bo.getId());
        vo.setNom(bo.getNom());
        return vo;
    }

    public static Categorie toBo(CategorieVo vo)
    {
        Categorie bo = new Categorie();
        bo.setId(vo.getId());
        bo.setNom(vo.getNom());
        return bo;
    }

}
