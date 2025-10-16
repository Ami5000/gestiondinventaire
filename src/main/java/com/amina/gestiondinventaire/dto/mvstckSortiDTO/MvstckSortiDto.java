package com.amina.gestiondinventaire.dto.mvstckSortiDTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class MvstckSortiDto {

    private UUID id;
    private int quantite;
    private LocalDate dateSorti;
    private UUID produitId;
    private String ProduitNom;



}
