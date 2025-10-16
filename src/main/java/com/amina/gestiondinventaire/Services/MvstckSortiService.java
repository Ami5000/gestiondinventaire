package com.amina.gestiondinventaire.Services;

import com.amina.gestiondinventaire.dto.mvstckSortiDTO.MvstckSortiDto;
import com.amina.gestiondinventaire.mapper.MvstckSortiMapper;
import com.amina.gestiondinventaire.modelEntity.mvstckSorti.MvstckSorti;
import com.amina.gestiondinventaire.modelEntity.mvstckSorti.MvstckSortiRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MvstckSortiService {
    private final MvstckSortiRepository mvstckSortiRepository;
    private final MvstckSortiMapper mapper;

    //Creation dun mouvement de stock de sortie
    public MvstckSortiDto create(MvstckSortiDto dto) {
        MvstckSorti mvstckSorti = mapper.toEntity(dto);
        mvstckSorti = mvstckSortiRepository.save(mvstckSorti);
        return mapper.toDto(mvstckSorti);
    }

    //Supprimer un mouvement de stock de sortie
    @Transactional
    public void delete(UUID id) {
        MvstckSorti mvstckSorti = mvstckSortiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mouvement de stock de sortie not found"));
        mvstckSortiRepository.deleteById(id);
    }

    //Modifier un mouvement de stock de sortie
    @Transactional
    public MvstckSortiDto update(UUID id, MvstckSortiDto dto) {
        MvstckSorti mvstckSorti = mvstckSortiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mouvement de stock de sortie not found"));
        if (dto.getDateSorti() != null) {
            mvstckSorti.setDateSorti(dto.getDateSorti());
        }
        if (dto.getQuantite() != 0) {
            mvstckSorti.setQuantite(dto.getQuantite());
        }
        return mapper.toDto(mvstckSorti);

    }

    public MvstckSortiDto getById(String id) {
        MvstckSorti mvstckSorti = mvstckSortiRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Mouvement de stock de sortie not found"));
        return mapper.toDto(mvstckSorti);
    }

    public List<MvstckSortiDto> getAll(){
        return mvstckSortiRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
