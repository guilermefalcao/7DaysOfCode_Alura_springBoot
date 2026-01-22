# 🦸‍♂️ API de Super-Heróis - #7DaysOfCode

Projeto desenvolvido durante o desafio **#7DaysOfCode** da Alura para criar uma API REST completa de gerenciamento de super-heróis usando Spring Boot.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 4.0.1**
- **Spring Data JPA**
- **Spring Validation**
- **H2 Database** (banco em memória)
- **Lombok**
- **Maven**

## 📋 Funcionalidades

### ✅ Dias Implementados:

**Dia 1**: Configuração inicial do projeto
- Configuração do Spring Initializr
- Dependências Maven
- Banco H2

**Dia 2**: Modelo e Repositório
- Entidade SuperHeroi com JPA
- Repository com Spring Data

**Dia 3**: Controller REST
- CRUD completo (GET, POST, PUT, DELETE)
- Endpoints REST

**Dia 4**: Dados Iniciais
- DataLoader com super-heróis pré-cadastrados
- Testes com Postman

**Dia 5**: Busca por Poderes
- Endpoint de busca case-insensitive
- Query personalizada com JPQL

**Dia 6**: Validações
- Bean Validation com mensagens personalizadas
- Tratamento global de exceções
- Respostas de erro amigáveis

## 🛠️ Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+

### Executando o projeto
```bash
# Clone o repositório
git clone https://github.com/guilermefalcao/7DaysOfCode_Alura_springBoot.git

# Entre na pasta
cd 7DaysOfCode_desafioSpringBoot

# Execute o projeto
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📊 H2 Console

Acesse o banco de dados em: `http://localhost:8080/h2-console`

**Configurações:**
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: (vazio)

## 🔗 Endpoints da API

### Super-Heróis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/super-herois` | Lista todos os super-heróis |
| GET | `/api/super-herois/{id}` | Busca super-herói por ID |
| GET | `/api/super-herois/buscar?poder=voo` | Busca por poderes |
| POST | `/api/super-herois` | Cria novo super-herói |
| PUT | `/api/super-herois/{id}` | Atualiza super-herói |
| DELETE | `/api/super-herois/{id}` | Remove super-herói |

### Exemplo de JSON (POST/PUT):
```json
{
    "nome": "Batman",
    "poderes": "Inteligência genial, artes marciais, gadgets tecnológicos",
    "identidadeSecreta": "Bruce Wayne",
    "origem": "Gotham City",
    "universo": "DC Comics",
    "nivelForca": 8
}
```

## ✅ Validações Implementadas

- **nome**: Obrigatório, 2-100 caracteres
- **poderes**: Obrigatório, 5-1000 caracteres
- **identidadeSecreta**: Obrigatório, 2-100 caracteres
- **nivelForca**: Entre 1 e 10

## 🧪 Testando com Postman

1. Importe a collection ou crie requests manualmente
2. Use `Content-Type: application/json` para POST/PUT
3. Teste validações enviando dados inválidos

## 📝 Super-Heróis Pré-cadastrados

- Superman (Clark Kent)
- Homem-Aranha (Peter Parker)
- Mulher Maravilha (Diana Prince)
- Homem de Ferro (Tony Stark)

## 🏗️ Estrutura do Projeto

```
src/main/java/com/_DaysOfCode/_DaysOfCode/
├── config/          # Configurações e DataLoader
├── controller/      # Controllers REST
├── exception/       # Tratamento de exceções
├── model/          # Entidades JPA
└── repository/     # Repositórios Spring Data
```

## 🎯 Próximos Passos

- [ ] Dia 7: Interface web ou documentação Swagger
- [ ] Testes unitários
- [ ] Deploy na nuvem
- [ ] Autenticação JWT

---

**#7DaysOfCode** | **Alura** | **Spring Boot**