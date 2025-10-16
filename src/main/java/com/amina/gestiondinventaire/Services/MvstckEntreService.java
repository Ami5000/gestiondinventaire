package com.amina.gestiondinventaire.Services;

import com.amina.gestiondinventaire.dto.mvstckEntreDTO.MvstckEntreDto;
import com.amina.gestiondinventaire.mapper.MvstckEntreMapper;
import com.amina.gestiondinventaire.modelEntity.mvstckEntre.MvstckEntre;
import com.amina.gestiondinventaire.modelEntity.mvstckEntre.MvstckEntreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MvstckEntreService {
    private final MvstckEntreRepository  mvstckEntreRepository;
    private final MvstckEntreMapper mapper;

    public  MvstckEntreDto getById(String id) {
        MvstckEntre mvstckEntre = mvstckEntreRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Mouvement de stock d entree not found"));
        return mapper.toDto(mvstckEntre);
    }

    public List<MvstckEntreDto> getAll(){
        return mvstckEntreRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    //Creation
    public MvstckEntreDto create (MvstckEntreDto dto){
        MvstckEntre mvstckEntre = mapper.toEntity(dto);
        mvstckEntre = mvstckEntreRepository.save(mvstckEntre);
        return mapper.toDto(mvstckEntre);
    }

    //Suppression dun mouvement d entree
    @Transactional
    public Void delete (UUID id){
        MvstckEntre mvstckEntre = mvstckEntreRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Mouvement de stock d entree not found"));
        mvstckEntreRepository.deleteById(id);
        return null;
    }
    //Modifier un mouvement d entree
    @Transactional
    public MvstckEntreDto update (UUID id, MvstckEntreDto dto) {
        MvstckEntre mvstckEntre = mvstckEntreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mouvement de stock d entree not found"));
        if (dto.getDateEntre() != null) {
            mvstckEntre.setDateEntre(dto.getDateEntre());
        }
        if (dto.getQuantite() != 0) {
            mvstckEntre.setQuantite(dto.getQuantite());
        }
        return mapper.toDto(mvstckEntre);
    }
}
