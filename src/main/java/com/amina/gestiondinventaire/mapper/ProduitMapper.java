package com.amina.gestiondinventaire.mapper;

import com.amina.gestiondinventaire.dto.produitDTO.ProduitDto;
import com.amina.gestiondinventaire.modelEntity.produit.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class ProduitMapper {

    private final CathegoriMapper cathegoriMapper;
    private final FournisseurMapper fournisseurMapper;

    public ProduitDto toDto(Produit produit){
        ProduitDto produitDto = new ProduitDto();
        produitDto.setId(produit.getId());
        produitDto.setNom(produit.getNom());
        produitDto.setDescription(produit.getDescreption());
        produitDto.setPrix(produit.getPrix());
        if(produit.getCathegori() != null){
            produitDto.setCathegori(cathegoriMapper.toDto(produit.getCathegori()));

        }
        if(produit.getFournisseur() != null){
            produitDto.setFournisseur(fournisseurMapper.toDto(produit.getFournisseur()));

        }
        return produitDto;

    }
    public Produit toEntity(ProduitDto produitDto){
        Produit produit= new Produit();
        produit.setId(produitDto.getId());
        produit.setNom(produitDto.getNom());
        produit.setDescreption(produitDto.getDescription());
        produit.setPrix(produitDto.getPrix());
        if(produitDto.getCathegori() != null){
            produit.setCathegori(cathegoriMapper.toEntity(produitDto.getCathegori()));

        }
        if(produitDto.getFournisseur() != null){
            produit.setFournisseur(fournisseurMapper.toEntity(produitDto.getFournisseur()));

        }
        return produit;
    }


}
