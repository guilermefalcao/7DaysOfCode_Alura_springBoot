package com._DaysOfCode._DaysOfCode.controller;

import com._DaysOfCode._DaysOfCode.model.SuperHeroi;
import com._DaysOfCode._DaysOfCode.repository.SuperHeroiRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Marca como controlador REST (retorna JSON automaticamente)
@RequestMapping("/api/super-herois") // Define a URL base para todas as rotas
@Tag(name = "Super-Heróis", description = "Endpoints para gerenciamento de super-heróis") // Agrupa endpoints no Swagger
public class SuperHeroiController {

    @Autowired // Injeção de dependência automática do Spring
    private SuperHeroiRepository superHeroiRepository;

    // GET - Listar todos os super-heróis
    @GetMapping // Mapeia requisições GET para /api/super-herois
    @Operation(summary = "Listar todos os super-heróis", description = "Retorna uma lista com todos os super-heróis cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public List<SuperHeroi> listarTodos() {
        return superHeroiRepository.findAll();
    }

    // GET - Buscar super-heróis por poderes
    @GetMapping("/buscar") // Mapeia GET para /api/super-herois/buscar?poder=voo
    @Operation(summary = "Buscar por poderes", description = "Busca super-heróis que possuem um poder específico (case-insensitive)")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public List<SuperHeroi> buscarPorPoderes(@RequestParam String poder) {
        return superHeroiRepository.buscarPorPoderes(poder);
    }

    // GET - Buscar super-herói por ID
    @GetMapping("/{id}") // Mapeia GET para /api/super-herois/{id}
    @Operation(summary = "Buscar por ID", description = "Retorna um super-herói específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Super-herói encontrado"),
        @ApiResponse(responseCode = "404", description = "Super-herói não encontrado")
    })
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
    @Operation(summary = "Criar super-herói", description = "Cria um novo super-herói no banco de dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Super-herói criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public SuperHeroi criar(@Valid @RequestBody SuperHeroi superHeroi) {
        return superHeroiRepository.save(superHeroi);
    }

    // PUT - Atualizar super-herói existente
    @PutMapping("/{id}") // Mapeia PUT para /api/super-herois/{id}
    @Operation(summary = "Atualizar super-herói", description = "Atualiza os dados de um super-herói existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Super-herói atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Super-herói não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<SuperHeroi> atualizar(@PathVariable Long id, @Valid @RequestBody SuperHeroi superHeroiAtualizado) {
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
    @Operation(summary = "Deletar super-herói", description = "Remove um super-herói do banco de dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Super-herói deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Super-herói não encontrado")
    })
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