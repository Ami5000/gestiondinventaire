package com.amina.gestiondinventaire.Controller;

import com.amina.gestiondinventaire.Services.UtilisateurService;
import com.amina.gestiondinventaire.dto.utilisateurDTO.ConnectionDto;
import com.amina.gestiondinventaire.dto.utilisateurDTO.UtilisateurDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/utilisateur")//Routes
@RestController
@RequiredArgsConstructor
@Slf4j
public class UtilisateurController {
    private final UtilisateurService utilisateurService;


    // creation dun Utilisateur a partir dun Dto
    @PostMapping("/create")
    public UtilisateurDto create(@RequestBody UtilisateurDto dto) {
        log.info("Creation d'un utilisateur {}", dto);
        return utilisateurService.create(dto);
    }

    //Modifier un Utilisateur par son id et son Dto
    @PutMapping("/update/{id}")
    public ResponseEntity<UtilisateurDto> update(@PathVariable String id, @RequestBody UtilisateurDto dto) {
        return ResponseEntity.ok(utilisateurService.update(String.valueOf(UUID.fromString(id)), dto));
    }

    //Supprimer un Uilisateur
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        utilisateurService.delete(id);
        return ResponseEntity.ok("Utilisateur a ete supprimé avec succès");
    }

    //Recuperation dun utilisateur par son id
    @GetMapping ("/{id}")
    public ResponseEntity<UtilisateurDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(utilisateurService.getById(id));
    }

    //Recuperation de la liste de tous les Utilisateur
    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAll() {
        return ResponseEntity.ok(utilisateurService.getAll());
    }

    // 🔹 Connexion d’un utilisateur
    @PostMapping("/login")
    public ResponseEntity<?> connexion(@RequestBody ConnectionDto request) {
        try {
            UtilisateurDto utilisateurDto = utilisateurService.connexion(request);
            return ResponseEntity.ok(utilisateurDto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}




