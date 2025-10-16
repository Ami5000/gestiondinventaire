package com.amina.gestiondinventaire.Services;

import com.amina.gestiondinventaire.dto.utilisateurDTO.ConnectionDto;
import com.amina.gestiondinventaire.dto.utilisateurDTO.UtilisateurDto;
import com.amina.gestiondinventaire.mapper.UtilisateurMapper;
import com.amina.gestiondinventaire.modelEntity.utilisateur.Utilisateur;
import com.amina.gestiondinventaire.modelEntity.utilisateur.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UtilisateurService {


    private  final UtilisateurRepository utilisateurRepository;
    private  final UtilisateurMapper mapper;


    public UtilisateurDto getById(String id) {
        Utilisateur utilisateur = utilisateurRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        return mapper.toDto(utilisateur);
    }


    //creation dun utilisateur
    public UtilisateurDto create(UtilisateurDto dto){
        if (utilisateurRepository.existsByNom(dto.getNom())){
            throw new RuntimeException("Utilisateur already exists");
        }
        Utilisateur utilisateur = mapper.toEntity(dto);
        utilisateur = utilisateurRepository.save(utilisateur);
        return mapper.toDto (utilisateur);
    }


    //Recuperation dun utilisateur par son nom
    public UtilisateurDto getByNom(String nom) {
        Utilisateur utilisateur = utilisateurRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        return mapper.toDto(utilisateur);
    }

    //Recuperer la liste de tous les utilisateurs
    public  List<UtilisateurDto> getAll(){
        return utilisateurRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    //Supprimer un utilisateur
    @Transactional
    public  void delete(String id){
        Utilisateur Utilisateur = utilisateurRepository.findById(UUID.fromString(id))
                .orElseThrow(()-> new RuntimeException("Utilisateur not found"));
        utilisateurRepository.deleteById(UUID.fromString(id));
    }

    //creation de methode de connexion
    public UtilisateurDto connexion(ConnectionDto request) {
        Utilisateur utilisateur = utilisateurRepository.findByMail(request.getMail())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        if (utilisateur.getMot_de_passe().equals(request.getMot_de_passe())) {
            return mapper.toDto(utilisateur);
        }
         throw new RuntimeException("Invalid password");

        }


    //Mise a jour dun utilisateur
    public   UtilisateurDto update (String id, UtilisateurDto dto){
        Utilisateur utilisateur = utilisateurRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        if (dto.getNom() != null) {
            utilisateur.setNom(dto.getNom());
        }
        if (dto.getMot_de_passe() != null) {
            utilisateur.setMot_de_passe(dto.getMot_de_passe());
        }
        if (dto.getPrenom() != null) {
            utilisateur.setPrenom(dto.getPrenom());
        }
        if (dto.getNumTel() != null) {
            utilisateur.setNumTel(dto.getNumTel());
        }
        return mapper.toDto(utilisateur);
    }

}

