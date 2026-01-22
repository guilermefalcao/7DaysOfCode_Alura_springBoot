package com._DaysOfCode._DaysOfCode.config;

import com._DaysOfCode._DaysOfCode.model.SuperHeroi;
import com._DaysOfCode._DaysOfCode.repository.SuperHeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Marca como componente Spring para ser executado automaticamente
public class DataLoader implements CommandLineRunner {

    @Autowired
    private SuperHeroiRepository superHeroiRepository;

    @Override
    public void run(String... args) throws Exception {
        // Carrega dados iniciais apenas se o banco estiver vazio
        if (superHeroiRepository.count() == 0) {
            carregarDadosIniciais();
        }
    }

    private void carregarDadosIniciais() {
        // Super-herói 1: Superman
        SuperHeroi superman = new SuperHeroi();
        superman.setNome("Superman");
        superman.setPoderes("Voo, super força, visão de raio-x, super velocidade, invulnerabilidade");
        superman.setIdentidadeSecreta("Clark Kent");
        superman.setOrigem("Krypton");
        superman.setUniverso("DC Comics");
        superman.setNivelForca(10);
        superHeroiRepository.save(superman);

        // Super-herói 2: Homem-Aranha
        SuperHeroi homemAranha = new SuperHeroi();
        homemAranha.setNome("Homem-Aranha");
        homemAranha.setPoderes("Agilidade sobre-humana, força proporcional de aranha, sentido aranha, teia");
        homemAranha.setIdentidadeSecreta("Peter Parker");
        homemAranha.setOrigem("Terra - Nova York");
        homemAranha.setUniverso("Marvel Comics");
        homemAranha.setNivelForca(7);
        superHeroiRepository.save(homemAranha);

        // Super-herói 3: Mulher Maravilha
        SuperHeroi mulherMaravilha = new SuperHeroi();
        mulherMaravilha.setNome("Mulher Maravilha");
        mulherMaravilha.setPoderes("Super força, voo, laço da verdade, bracelete indestrutível");
        mulherMaravilha.setIdentidadeSecreta("Diana Prince");
        mulherMaravilha.setOrigem("Themyscira");
        mulherMaravilha.setUniverso("DC Comics");
        mulherMaravilha.setNivelForca(9);
        superHeroiRepository.save(mulherMaravilha);

        // Super-herói 4: Homem de Ferro
        SuperHeroi homemDeFerro = new SuperHeroi();
        homemDeFerro.setNome("Homem de Ferro");
        homemDeFerro.setPoderes("Armadura tecnológica, voo, repulsores, inteligência genial");
        homemDeFerro.setIdentidadeSecreta("Tony Stark");
        homemDeFerro.setOrigem("Terra - Estados Unidos");
        homemDeFerro.setUniverso("Marvel Comics");
        homemDeFerro.setNivelForca(8);
        superHeroiRepository.save(homemDeFerro);

        System.out.println("Dados iniciais de super-heróis carregados com sucesso!");
    }
}