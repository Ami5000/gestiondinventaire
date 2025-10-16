package com.amina.gestiondinventaire.Services;

import com.amina.gestiondinventaire.dto.cathegoriDTO.CathegoriDto;
import com.amina.gestiondinventaire.mapper.CathegoriMapper;
import com.amina.gestiondinventaire.modelEntity.cathegori.Cathegori;
import com.amina.gestiondinventaire.modelEntity.cathegori.CathegoriRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CathegoriService {
    private final CathegoriRepository cathegoriRepository;
    private final CathegoriMapper mapper;

    //Creation dune cathegorie
    public CathegoriDto create(CathegoriDto dto){
        if (cathegoriRepository.existsByNom(dto.getNom())){
            throw new RuntimeException("Cathegori already exists");
        }
        Cathegori cathegori = mapper.toEntity(dto);
        cathegori = cathegoriRepository.save(cathegori);
        return mapper.toDto(cathegori);
    }


    //Recuperation dune cathegori par son id
    public CathegoriDto getById(String id){
        Cathegori cathegori = cathegoriRepository.findById(UUID.fromString(id))
                .orElseThrow(()-> new RuntimeException("Cathegori not found"));
        return mapper.toDto(cathegori);
    }

    //Recuperer toutes les cathegories

    public List<CathegoriDto> getAll(){
        return cathegoriRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    //Mise a jour dune cathegorie
    @Transactional
    public CathegoriDto update(String id, CathegoriDto dto){
        Cathegori cathegori = cathegoriRepository.findById(UUID.fromString(id))
                .orElseThrow(()-> new RuntimeException("Cathegori not found"));
        if (dto.getNom() != null){
            cathegori.setNom(dto.getNom());
        }
        if (dto.getDescription() != null){
            cathegori.setDescription(dto.getDescription());
        }
        return mapper.toDto(cathegori);
    }

    //Supprimer une cathegrorie
    @Transactional
    public void delete(String id){
        Cathegori cathegori = cathegoriRepository.findById(UUID.fromString(id))
                .orElseThrow(()-> new RuntimeException("Cathegori not found"));
        cathegoriRepository.delete(cathegori);
    }

}
