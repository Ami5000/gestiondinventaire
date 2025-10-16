package com.amina.gestiondinventaire.dto.fournisseurDTO;

import lombok.Data;

import java.util.UUID;

@Data

public class FournisseurDto {

    private UUID id;
    private String nom;
    private String contact;
    private String prenom;

    public static void delete(String id) {

    }
}