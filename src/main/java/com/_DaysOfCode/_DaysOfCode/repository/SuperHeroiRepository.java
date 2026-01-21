package com._DaysOfCode._DaysOfCode.repository;

import com._DaysOfCode._DaysOfCode.model.SuperHeroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marca como componente de repositório do Spring
public interface SuperHeroiRepository extends JpaRepository<SuperHeroi, Long> {
    // JpaRepository já fornece métodos básicos como save, findAll, findById, delete
    
    // Busca por poderes ignorando maiúsculas/minúsculas
    @Query("SELECT s FROM SuperHeroi s WHERE LOWER(s.poderes) LIKE LOWER(CONCAT('%', :poder, '%'))")
    List<SuperHeroi> buscarPorPoderes(@Param("poder") String poder);
}