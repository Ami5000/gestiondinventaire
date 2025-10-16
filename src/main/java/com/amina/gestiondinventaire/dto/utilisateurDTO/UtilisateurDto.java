package com.amina.gestiondinventaire.dto.utilisateurDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UtilisateurDto {

    private UUID id;
    private String nom;
    private String mail;
    private String mot_de_passe;
    private String prenom;
    private String numTel;

}