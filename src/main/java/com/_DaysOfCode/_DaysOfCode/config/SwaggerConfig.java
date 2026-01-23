package com._DaysOfCode._DaysOfCode.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marca como classe de configuração do Spring
public class SwaggerConfig {

    @Bean // Define um bean gerenciado pelo Spring
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Super-Heróis") // Título da API
                        .version("1.0") // Versão da API
                        .description("API REST para gerenciamento de super-heróis desenvolvida no desafio #7DaysOfCode da Alura") // Descrição
                        .contact(new Contact()
                                .name("Guilherme Falcão") // Nome do desenvolvedor
                                .url("https://github.com/guilermefalcao/7DaysOfCode_Alura_springBoot") // URL do projeto
                        )
                );
    }
}