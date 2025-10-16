package com.amina.gestiondinventaire.modelEntity.mvstckSorti;


import com.amina.gestiondinventaire.modelEntity.produit.Produit;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mvstck_sorti")

public class MvstckSorti {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    private int quantite;

    private LocalDate dateSorti;

    @ManyToOne
    @JoinColumn( name= "produitId")
    private Produit produit;
}
