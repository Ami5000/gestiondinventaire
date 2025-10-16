package com.amina.gestiondinventaire.mapper;

import com.amina.gestiondinventaire.dto.mvstckEntreDTO.MvstckEntreDto;
import com.amina.gestiondinventaire.modelEntity.mvstckEntre.MvstckEntre;
import org.springframework.stereotype.Component;

@Component

public class MvstckEntreMapper {

    public MvstckEntreDto toDto(MvstckEntre mvstckEntre){

        MvstckEntreDto mvstckEntreDto = new MvstckEntreDto();
        mvstckEntreDto.setId(mvstckEntreDto.getId());
        mvstckEntreDto.setQuantite(mvstckEntreDto.getQuantite());
        mvstckEntreDto.setDateEntre(mvstckEntreDto.getDateEntre());
        mvstckEntreDto.setProduitId(mvstckEntreDto.getProduitId());
        mvstckEntreDto.setProduitNom(mvstckEntreDto.getProduitNom());
        return mvstckEntreDto;
    }

    public MvstckEntre toEntity(MvstckEntreDto mvstckEntreDto){
        MvstckEntre mvstckEntre = new MvstckEntre();
        mvstckEntre.setQuantite(mvstckEntreDto.getQuantite());
        mvstckEntre.setDateEntre(mvstckEntreDto.getDateEntre());
        return mvstckEntre;
    }
}
