package com.amina.gestiondinventaire.Controller;

import com.amina.gestiondinventaire.Services.FournisseurService;
import com.amina.gestiondinventaire.dto.fournisseurDTO.FournisseurDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Fournisseur")//Routes
@RequiredArgsConstructor
public class FournisseurController {
    private final FournisseurService fournisseurService;

    //Modifier un Fournisseur par son id et son Dto
    @PutMapping("/update/{id}")
    public ResponseEntity <FournisseurDto> update(@PathVariable String id, @RequestBody FournisseurDto dto) {
        return ResponseEntity.ok(fournisseurService.update(UUID.fromString(id), dto));
    }

    //Creation dun Fournisseur a partir dun Dto
    @PostMapping("/create")
    public ResponseEntity<FournisseurDto> create(@RequestBody FournisseurDto dto) {
        return ResponseEntity.ok(fournisseurService.create(dto));
    }



    //Supprimer un fournisseur
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id, @RequestBody FournisseurDto dto) {
        fournisseurService.delete(id);
        return ResponseEntity.ok("Fournisseur  supprimé avec succès");
    }

        //Recuperation de la liste de tous les fournisseur
        @GetMapping
            public ResponseEntity<List<FournisseurDto>> getAll() {
                return ResponseEntity.ok(fournisseurService.getAll());
}

}







