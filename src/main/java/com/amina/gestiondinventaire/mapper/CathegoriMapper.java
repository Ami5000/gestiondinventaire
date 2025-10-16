package com.amina.gestiondinventaire.mapper;

import com.amina.gestiondinventaire.dto.cathegoriDTO.CathegoriDto;
import com.amina.gestiondinventaire.modelEntity.cathegori.Cathegori;
import org.springframework.stereotype.Component;

@Component
public class CathegoriMapper {

    public CathegoriDto toDto(Cathegori cathegori) {
        CathegoriDto cathegoriDto = new CathegoriDto();
        cathegoriDto.setId(cathegori.getId());
        cathegoriDto.setNom(cathegori.getNom());
        cathegoriDto.setDescription(cathegori.getDescription());
        return cathegoriDto;
    }

    public Cathegori toEntity(CathegoriDto cathegoriDto) {
        Cathegori cathegori = new Cathegori();
        cathegori.setId(cathegoriDto.getId());
        cathegori.setNom(cathegoriDto.getNom());
        cathegori.setDescription(cathegoriDto.getDescription());
        return cathegori;
    }

}