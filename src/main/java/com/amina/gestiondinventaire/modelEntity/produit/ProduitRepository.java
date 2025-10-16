package com.amina.gestiondinventaire.modelEntity.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository < Produit , String> {
    Optional<Produit> findByNom(String nom);
    boolean existsByNom(String nom);
}
