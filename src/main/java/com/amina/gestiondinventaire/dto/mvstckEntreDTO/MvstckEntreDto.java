package com.amina.gestiondinventaire.dto.mvstckEntreDTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class MvstckEntreDto {

    private UUID id;
    private int quantite;
    private LocalDate dateEntre;
    private UUID produitId;
    private String produitNom;
}
