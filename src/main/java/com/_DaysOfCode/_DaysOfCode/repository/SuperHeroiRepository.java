package com._DaysOfCode._DaysOfCode.repository;

import com._DaysOfCode._DaysOfCode.model.SuperHeroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca como componente de repositório do Spring
public interface SuperHeroiRepository extends JpaRepository<SuperHeroi, Long> {
    // JpaRepository já fornece métodos básicos como save, findAll, findById, delete
    // Aqui você pode adicionar métodos customizados se necessário
}