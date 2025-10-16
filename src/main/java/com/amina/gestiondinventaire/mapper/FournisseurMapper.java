package com.amina.gestiondinventaire.mapper;

import com.amina.gestiondinventaire.dto.fournisseurDTO.FournisseurDto;
import com.amina.gestiondinventaire.modelEntity.fournisseur.Fournisseur;
import org.springframework.stereotype.Component;

@Component
public class FournisseurMapper {

    public FournisseurDto toDto(Fournisseur fournisseur) {
        FournisseurDto fournisseurDto = new FournisseurDto();
        fournisseurDto.setId(fournisseur.getId());
        fournisseurDto.setNom(fournisseur.getNom());
        fournisseurDto.setContact(fournisseur.getContact());
        fournisseurDto.setPrenom(fournisseur.getPrenom());
        return fournisseurDto;
    }

    public Fournisseur toEntity(FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setContact(fournisseurDto.getContact());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        return fournisseur;
    }
}
