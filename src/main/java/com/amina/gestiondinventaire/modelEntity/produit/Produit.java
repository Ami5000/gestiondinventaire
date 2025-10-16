package com.amina.gestiondinventaire.modelEntity.produit;

import com.amina.gestiondinventaire.modelEntity.cathegori.Cathegori;
import com.amina.gestiondinventaire.modelEntity.fournisseur.Fournisseur;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="Produit")

public class Produit {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)

    private String nom;
    private String descreption;
    private double prix;

    @ManyToOne
    @JoinColumn(name = "cathegori_id", referencedColumnName = "id")
    private Cathegori cathegori;


    @ManyToOne
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "id")
    private Fournisseur fournisseur;


}
