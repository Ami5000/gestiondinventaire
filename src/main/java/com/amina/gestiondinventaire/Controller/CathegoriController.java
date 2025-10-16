package com.amina.gestiondinventaire.Controller;

import com.amina.gestiondinventaire.Services.CathegoriService;
import com.amina.gestiondinventaire.dto.cathegoriDTO.CathegoriDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cathegori")//Routes
@RequiredArgsConstructor
public class CathegoriController {
    private final CathegoriService cathegoriService;

    //Recuperation dune cathegorie par son id
    @GetMapping ("/{id}")
    public ResponseEntity <CathegoriDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(cathegoriService.getById(id));
    }
    //Recuperation de toute les cathegori
         @GetMapping
            public ResponseEntity<List<CathegoriDto>> getAll() {
         return ResponseEntity.ok(cathegoriService.getAll());
    }
         @PostMapping("/create")
         // creation dune cathegorie a partir dun Dto
             public CathegoriDto create(@RequestBody CathegoriDto dto) {
        return cathegoriService.create(dto);
    }
         //Modification dune cathegorie a partir de son id et son Dto
             @PutMapping("/update/{id}")
           public ResponseEntity <CathegoriDto> update(@PathVariable String id, @RequestBody CathegoriDto dto) {
             return ResponseEntity.ok(cathegoriService.update(id, dto));
    }

    //Supprimer une catheori a partir de son id et de son Dto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable String id, @RequestBody CathegoriDto dto) {
        cathegoriService.delete(id);
        return ResponseEntity.ok("Cathegori supprimé avec succès");
    }


}