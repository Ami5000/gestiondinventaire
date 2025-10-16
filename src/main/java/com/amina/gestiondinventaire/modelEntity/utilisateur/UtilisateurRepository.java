package com.amina.gestiondinventaire.modelEntity.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtilisateurRepository extends JpaRepository <Utilisateur, UUID> {
    Optional<Utilisateur> findByNom(String nom);
    Optional<Utilisateur> findById(UUID id);

    boolean existsByNom(String nom);

    Optional<Utilisateur> findByMail(String mail);
}