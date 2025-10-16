package com.amina.gestiondinventaire.Services;

import com.amina.gestiondinventaire.dto.fournisseurDTO.FournisseurDto;
import com.amina.gestiondinventaire.mapper.FournisseurMapper;
import com.amina.gestiondinventaire.modelEntity.fournisseur.Fournisseur;
import com.amina.gestiondinventaire.modelEntity.fournisseur.FournisseurRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FournisseurService {

    private final FournisseurRepository fournisseurRepository;
    private final FournisseurMapper mapper;

    public FournisseurDto getById(UUID id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur not found"));
        return mapper.toDto(fournisseur);
    }



    //creatiion dun fournisseur
    public FournisseurDto create (FournisseurDto dto){
        if (fournisseurRepository.existsByContact(dto.getContact())){
            throw new RuntimeException("Fournisseur already exists");
        }
        Fournisseur fournisseur = mapper.toEntity(dto);
        fournisseur = fournisseurRepository.save(fournisseur);
        return mapper.toDto(fournisseur);

    }

    //Recuperation dun fournisseur par son son nom
    public FournisseurDto findByNom(String nom){
        Fournisseur fournisseur = fournisseurRepository.findByNom(nom)
                .orElseThrow(()-> new RuntimeException("Fournisseur not found"));
        return mapper.toDto(fournisseur);
    }
//Recuperer la liste de tous fournisseurs
    public  java.util.List<FournisseurDto> getAll(){
        return fournisseurRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
    //Mise a jour dun fournisseur
    public FournisseurDto update(UUID id, FournisseurDto dto){
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Fournisseur not found"));
        if (dto.getNom() != null) {
            fournisseur.setNom(dto.getNom());

        }
        if (dto.getContact() != null) {
            fournisseur.setContact(dto.getContact());
        }
        if (dto.getPrenom() != null) {
            fournisseur.setPrenom(dto.getPrenom());
        }
        return mapper.toDto(fournisseur);
    }


    //Supprimer un fournisseur
    @Transactional
    public  void delete(UUID id){
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Fournisseur not found"));
        fournisseurRepository.delete(fournisseur);
    }
}
