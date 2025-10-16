package com.amina.gestiondinventaire.Controller;

import com.amina.gestiondinventaire.Services.FournisseurService;
import com.amina.gestiondinventaire.Services.ProduitService;
import com.amina.gestiondinventaire.dto.produitDTO.ProduitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produit")//Routes

@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;
    private final FournisseurService fournisseurService;

    @PostMapping("/create")
    // creation dun Produit a partir dun Dto
    public ResponseEntity<ProduitDto>  create(@RequestBody ProduitDto dto) {
        return ResponseEntity.ok(produitService.create(dto));
    }
    //recuperer un produit par son id
    @GetMapping("/{id}")
    public ResponseEntity<ProduitDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(produitService.getById(id));

    }
     //Modifier un produit par son id et son Dto
     @PutMapping("/update/{id}")
     public ResponseEntity <ProduitDto> update(@PathVariable UUID id, @RequestBody ProduitDto dto) {
         return ResponseEntity.ok(produitService.update(id.toString(), dto));


     }
    //Supprimer un produit
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id, @RequestBody ProduitDto dto) {
        fournisseurService.delete(id);
        return ResponseEntity.ok("Fournisseur  supprimé avec succès");

    }

    //Recuperer la liste de tous les produits
    @GetMapping
    public ResponseEntity<List<ProduitDto>> getAll() {
        return ResponseEntity.ok(produitService.getAll());
    }



}
