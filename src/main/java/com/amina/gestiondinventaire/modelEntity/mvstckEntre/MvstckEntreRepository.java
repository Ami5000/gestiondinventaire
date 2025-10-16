package com.amina.gestiondinventaire.modelEntity.mvstckEntre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface MvstckEntreRepository extends JpaRepository<MvstckEntre, UUID>{
    List< MvstckEntre>findByDateEntre(LocalDate dateEntre);
}
