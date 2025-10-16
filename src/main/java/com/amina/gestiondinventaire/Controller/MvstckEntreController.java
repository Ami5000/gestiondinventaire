package com.amina.gestiondinventaire.Controller;

import com.amina.gestiondinventaire.Services.MvstckEntreService;
import com.amina.gestiondinventaire.dto.mvstckEntreDTO.MvstckEntreDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Transactional
@RestController
@RequestMapping("/api/mvstckentre")//Routes
@AllArgsConstructor
public class MvstckEntreController {

    private final MvstckEntreService  mvstckEntreService;

    //Ajouter un MvstckEntre par son id
    @GetMapping("/{id}")
    public ResponseEntity<MvstckEntreDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(mvstckEntreService.getById(id));

    }


    //Creation dun MvstckEntre a partir dun Dto
    @PostMapping("/create")
    public ResponseEntity<MvstckEntreDto> create(@RequestBody MvstckEntreDto   dto) {
        return ResponseEntity.ok(mvstckEntreService.create(dto));
    }




    //Modifier un MvstckEntre par son id et son Dto
    @PutMapping("/update/{id}")
    public ResponseEntity <MvstckEntreDto> update(@PathVariable UUID id, @RequestBody MvstckEntreDto dto) {
        return ResponseEntity.ok(mvstckEntreService.update(id, dto));

    }
    //Supprimer un MvstckEntre
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id, @RequestBody MvstckEntreDto dto) {
        mvstckEntreService.delete(id);
        return ResponseEntity.ok("Mouvement Dentree supprimer  supprimé avec succès");

    }

    //Recuperer la liste de tous les MvstckEntre
    @GetMapping
    public ResponseEntity<List<MvstckEntreDto>> getAll() {
        return ResponseEntity.ok(mvstckEntreService.getAll());
    }



}




