## Participantes

- Guilherme Ferreira Jardim - RM556814
- Fernando Fontes - RM555317

# API Catálogo de Carros
Esta API foi desenvolvida com Java e Spring Boot para gerenciar um catálogo de carros.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- JUnit 5

## Como executar

1. Clone o repositório
2. Execute o comando:
   ./mvnw spring-boot:run
3. A API estará disponível em: http://localhost:8080

## Endpoints

### Consultas
- GET /carros/potencia
- GET /carros/economia
- GET /carros/eletricos
- GET /carros/{id}

### CRUD
- POST /carros
- PUT /carros/{id}
- DELETE /carros/{id}

## Banco de dados H2

- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Usuário: sa
- Senha: (deixe em branco)
