package com.amina.gestiondinventaire.modelEntity.mvstckSorti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface MvstckSortiRepository extends JpaRepository< MvstckSorti , UUID> {
    List<MvstckSorti>findBydateSorti(LocalDate dateSorti);
}
