package com.amina.gestiondinventaire.Controller;

import com.amina.gestiondinventaire.Services.MvstckSortiService;
import com.amina.gestiondinventaire.dto.mvstckSortiDTO.MvstckSortiDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/mvstckSorti")//Routes
@RestController
public class MvstckSortiController {

    private final MvstckSortiService  mvstckSortiService;

    //Ajouter un MvstckSortipar son id
    @GetMapping("/{id}")
    public ResponseEntity<MvstckSortiDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mvstckSortiService.getById(id));

    }
    //Modifier un MvstckSorti par son id et son Dto
    @PutMapping("/update/{id}")
    public ResponseEntity <MvstckSortiDto> update(@PathVariable UUID id, @RequestBody MvstckSortiDto dto) {
        return ResponseEntity.ok(mvstckSortiService.update(id, dto));

    }

    //Creation dun MvstckSorti a partir dun Dto
    @PostMapping("/create")
    public ResponseEntity<MvstckSortiDto> create(@RequestBody MvstckSortiDto   dto) {
        return ResponseEntity.ok(mvstckSortiService.create(dto));
    }









    //Supprimer un MvstckSorti
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id, @RequestBody MvstckSortiDto dto) {
        mvstckSortiService.delete(id);
        return ResponseEntity.ok("Mouvement de sorti est   supprimé avec succès");

    }

    //Recuperer la liste de tous les MvstckSorti
    @GetMapping
    public ResponseEntity<List<MvstckSortiDto>> getAll() {
        return ResponseEntity.ok(mvstckSortiService.getAll());
    }



}



