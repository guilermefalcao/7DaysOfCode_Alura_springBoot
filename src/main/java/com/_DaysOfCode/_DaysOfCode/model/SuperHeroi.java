package com._DaysOfCode._DaysOfCode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity // Marca a classe como uma entidade JPA
@Table(name = "super_herois") // Define o nome da tabela no banco
@Data // Lombok gera automaticamente getters, setters, toString, equals e hashCode
public class SuperHeroi {
    
    @Id // Marca como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório") // Não pode ser null, vazio ou só espaços
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    @Column(nullable = false) // Coluna obrigatória
    private String nome;
    
    @NotBlank(message = "Poderes são obrigatórios")
    @Size(min = 5, max = 1000, message = "Poderes devem ter entre 5 e 1000 caracteres")
    @Column(length = 1000) // Coluna com tamanho específico para textos longos
    private String poderes;
    
    @NotBlank(message = "Identidade secreta é obrigatória")
    @Size(min = 2, max = 100, message = "Identidade secreta deve ter entre 2 e 100 caracteres")
    @Column(name = "identidade_secreta", nullable = false)
    private String identidadeSecreta;
    
    private String origem;
    
    private String universo;
    
    @Min(value = 1, message = "Nível de força deve ser no mínimo 1")
    @Max(value = 10, message = "Nível de força deve ser no máximo 10")
    @Column(name = "nivel_forca")
    private Integer nivelForca;
}