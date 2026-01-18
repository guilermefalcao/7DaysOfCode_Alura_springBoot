package com._DaysOfCode._DaysOfCode.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Marca a classe como uma entidade JPA
@Table(name = "super_herois") // Define o nome da tabela no banco
@Data // Lombok gera automaticamente getters, setters, toString, equals e hashCode
public class SuperHeroi {
    
    @Id // Marca como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;
    
    @Column(nullable = false) // Coluna obrigatória
    private String nome;
    
    @Column(length = 1000) // Coluna com tamanho específico para textos longos
    private String poderes;
    
    private String origem;
    
    private String universo;
    
    @Column(name = "nivel_forca") // Nome customizado da coluna
    private Integer nivelForca;
}