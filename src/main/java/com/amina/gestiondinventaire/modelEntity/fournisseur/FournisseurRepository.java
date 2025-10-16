package com.amina.gestiondinventaire.modelEntity.fournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FournisseurRepository extends JpaRepository <Fournisseur , UUID>{
    Optional< Fournisseur> findByNom(String nom);
    Fournisseur getById(UUID id);
    boolean existsByNom(String nom);

    boolean existsByContact(String contact);
}
