package com.pfa.BackEnd.PFA.Projet.domaine;

import com.pfa.BackEnd.PFA.Projet.service.model.Livraison;
import java.util.ArrayList;
import java.util.List;

public class LivraisonConverter
{
    public static List<LivraisonVo> toListVo(List<Livraison> listBo)
    {
        List<LivraisonVo> listVo = new ArrayList<>();
        for (Livraison livraison : listBo) {
            listVo.add(toVo(livraison));
        }
        return listVo;
    }

    public static LivraisonVo toVo(Livraison bo)
    {
        if (bo == null || bo.getId() ==null)
            return null;
        LivraisonVo vo = new LivraisonVo();
        vo.setId(bo.getId());
        vo.setDateLivraison(bo.getDateLivraison());
        return vo;
    }

    public static Livraison toBo(LivraisonVo vo)
    {
        Livraison bo = new Livraison();
        bo.setId(vo.getId());
        bo.setDateLivraison(vo.getDateLivraison());
        return bo;
    }
}
