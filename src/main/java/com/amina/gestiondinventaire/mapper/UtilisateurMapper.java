package com.amina.gestiondinventaire.mapper;

import com.amina.gestiondinventaire.dto.utilisateurDTO.UtilisateurDto;
import com.amina.gestiondinventaire.modelEntity.utilisateur.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {

    public UtilisateurDto toDto(Utilisateur utilisateur){
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setNom(utilisateur.getNom());
        utilisateurDto.setMail(utilisateur.getMail());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setMot_de_passe(utilisateur.getMot_de_passe());
        utilisateurDto.setNumTel(utilisateur.getNumTel());
        return utilisateurDto;

    }
    public Utilisateur toEntity(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setMail(utilisateurDto.getMail());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMot_de_passe(utilisateurDto.getMot_de_passe());
        utilisateur.setNumTel(utilisateurDto.getNumTel());
        return utilisateur;

    }
}
