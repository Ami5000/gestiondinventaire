package com.amina.gestiondinventaire.Services;

import com.amina.gestiondinventaire.dto.produitDTO.ProduitDto;
import com.amina.gestiondinventaire.mapper.ProduitMapper;
import com.amina.gestiondinventaire.modelEntity.produit.Produit;
import com.amina.gestiondinventaire.modelEntity.produit.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private  final ProduitRepository produitRepository;
    private  final ProduitMapper mapper ;

    public static ProduitDto getById(String id) {
        return null;
    }

    //Creation dun produit
        public  ProduitDto create (ProduitDto dto){
            if ( produitRepository.existsByNom(dto .getNom())){
                throw new RuntimeException("Produit already exists");
            }
            Produit produit = mapper.toEntity(dto);
            produit = produitRepository.save(produit);
            return mapper.toDto(produit);
        }

        //Recuperation dun produit par son son nom
        public ProduitDto getByNom(String nom){
            Produit produit = produitRepository.findByNom(nom)
                    .orElseThrow(()-> new RuntimeException("Produit not found"));
            return mapper.toDto(produit);
        }

        //Recuperer la liste de tous produits
        public  List<ProduitDto> getAll(){
            return produitRepository.findAll()
                    .stream()
                    .map(mapper::toDto)
                    .collect(Collectors.toList());

        }

        //Mise a jour dun produit
        @Transactional
        public  ProduitDto update(String id, ProduitDto dto){
            Produit produit = produitRepository.findById(id)
                    .orElseThrow(()-> new RuntimeException("Produit not found"));
            if (dto.getNom() != null) {
                produit.setNom(dto.getNom());
            }
            if (dto.getDescription() != null) {
                produit.setDescreption(dto.getDescription());
            }
            if (dto.getPrix() != 0) {
                produit.setPrix(dto.getPrix());
            }
        return mapper.toDto(produit);
        }


    //Supprimer un produit
    @Transactional
    public void delete(String id){
        Produit produit = produitRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produit not found"));
        produitRepository.delete(produit);
    }


    }



