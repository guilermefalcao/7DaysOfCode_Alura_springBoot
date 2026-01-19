package com._DaysOfCode._DaysOfCode.controller;

import com._DaysOfCode._DaysOfCode.model.SuperHeroi;
import com._DaysOfCode._DaysOfCode.repository.SuperHeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Marca como controlador REST (retorna JSON automaticamente)
@RequestMapping("/api/super-herois") // Define a URL base para todas as rotas
public class SuperHeroiController {

    @Autowired // Injeção de dependência automática do Spring
    private SuperHeroiRepository superHeroiRepository;

    // GET - Listar todos os super-heróis
    @GetMapping // Mapeia requisições GET para /api/super-herois
    public List<SuperHeroi> listarTodos() {
        return superHeroiRepository.findAll();
    }

    // GET - Buscar super-herói por ID
    @GetMapping("/{id}") // Mapeia GET para /api/super-herois/{id}
    public ResponseEntity<SuperHeroi> buscarPorId(@PathVariable Long id) {
        Optional<SuperHeroi> superHeroi = superHeroiRepository.findById(id);
        
        if (superHeroi.isPresent()) {
            return ResponseEntity.ok(superHeroi.get()); // Retorna 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }

    // POST - Criar novo super-herói
    @PostMapping // Mapeia requisições POST para /api/super-herois
    public SuperHeroi criar(@RequestBody SuperHeroi superHeroi) {
        return superHeroiRepository.save(superHeroi);
    }

    // PUT - Atualizar super-herói existente
    @PutMapping("/{id}") // Mapeia PUT para /api/super-herois/{id}
    public ResponseEntity<SuperHeroi> atualizar(@PathVariable Long id, @RequestBody SuperHeroi superHeroiAtualizado) {
        Optional<SuperHeroi> superHeroiExistente = superHeroiRepository.findById(id);
        
        if (superHeroiExistente.isPresent()) {
            superHeroiAtualizado.setId(id); // Garante que o ID seja mantido
            SuperHeroi superHeroiSalvo = superHeroiRepository.save(superHeroiAtualizado);
            return ResponseEntity.ok(superHeroiSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Remover super-herói
    @DeleteMapping("/{id}") // Mapeia DELETE para /api/super-herois/{id}
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<SuperHeroi> superHeroi = superHeroiRepository.findById(id);
        
        if (superHeroi.isPresent()) {
            superHeroiRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}