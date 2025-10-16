package com.amina.gestiondinventaire.dto.produitDTO;

import com.amina.gestiondinventaire.dto.cathegoriDTO.CathegoriDto;
import com.amina.gestiondinventaire.dto.fournisseurDTO.FournisseurDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {
    private UUID id;
    private String nom;
    private String description;
    private double prix;
    private CathegoriDto cathegori;
    private FournisseurDto fournisseur;




}
