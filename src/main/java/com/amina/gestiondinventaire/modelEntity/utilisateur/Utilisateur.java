package com.amina.gestiondinventaire.modelEntity.utilisateur;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "utilisateur ")

public class Utilisateur {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")

    private UUID id;
    @Column(nullable = false)
    private String nom;
    private String mail;
    private String mot_de_passe;
    private String prenom;
    private String numTel;


}
