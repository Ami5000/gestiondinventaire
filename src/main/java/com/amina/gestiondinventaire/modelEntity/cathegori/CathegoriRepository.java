package com.amina.gestiondinventaire.modelEntity.cathegori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CathegoriRepository extends JpaRepository<Cathegori , UUID> {
    Optional<Cathegori>findById(UUID id);
    boolean existsByNom(String nom);
}
