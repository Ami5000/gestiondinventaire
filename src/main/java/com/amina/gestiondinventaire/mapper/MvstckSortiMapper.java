package com.amina.gestiondinventaire.mapper;

import com.amina.gestiondinventaire.dto.mvstckSortiDTO.MvstckSortiDto;
import com.amina.gestiondinventaire.modelEntity.mvstckSorti.MvstckSorti;
import org.springframework.stereotype.Component;

@Component
public class MvstckSortiMapper {


     public  MvstckSortiDto toDto(MvstckSorti mvstckSorti){
         MvstckSortiDto mvstckSortiDto = new MvstckSortiDto();
         mvstckSortiDto.setQuantite(mvstckSortiDto.getQuantite());
            mvstckSortiDto.setDateSorti(mvstckSortiDto.getDateSorti());
            mvstckSortiDto.setProduitId( mvstckSortiDto.getProduitId());
            mvstckSortiDto.setProduitNom(mvstckSortiDto.getProduitNom());
            mvstckSortiDto.setId(mvstckSortiDto.getId());
            return mvstckSortiDto;

     }

        public MvstckSorti toEntity(MvstckSortiDto mvstckSortiDto){
            MvstckSorti mvstckSorti =  new MvstckSorti();
            mvstckSorti.setQuantite(mvstckSortiDto.getQuantite());
            mvstckSorti.setDateSorti(mvstckSortiDto.getDateSorti());
            return  mvstckSorti;
        }
}
