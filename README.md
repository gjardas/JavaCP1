# Catálogo de Carros - API REST com Spring Boot

Este projeto é uma Web API desenvolvida em Java com Spring Boot para gerenciar um catálogo de carros. Ele permite realizar operações de consulta, cadastro, atualização e remoção de veículos, com filtros por potência, economia e tipo de combustível.

## Participantes

- Guilherme Ferreira Jardim - RM556814
- Fernando Fontes - RM555317

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (banco de dados em memória)
- Swagger (documentação automática)
- JUnit e MockMvc (testes)

## Requisitos da API

A API gerencia um banco de dados de carros com os seguintes atributos:

- **Marca**: Fabricante do veículo
- **Modelo**: Nome do modelo
- **Ano**: Ano de fabricação
- **Potência**: Em cavalos (HP)
- **Economia**:
  - Para veículos a combustão: km/litro
  - Para veículos elétricos: km/kWh
- **Tipo**: combustão, híbrido ou elétrico
- **Preço**: Valor de mercado

## Endpoints da API

### Consultas

- `GET /carros/potencia`: Retorna os 10 carros com maior potência.
- `GET /carros/economia`: Retorna os 10 carros mais econômicos.
- `GET /carros/eletricos`: Retorna todos os carros do tipo elétrico.
- `GET /carros/{id}`: Retorna os dados de um carro específico.

### Manutenção

- `POST /carros`: Adiciona um novo carro ao catálogo.
- `PUT /carros/{id}`: Atualiza os dados de um carro.
- `DELETE /carros/{id}`: Remove um carro do catálogo.

## Instruções para Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/gjardas/CP1Java.git
   cd CP1Java
   
2. Execute o projeto com o Maven:
./mvnw spring-boot:run

3. Acesse a API no navegador ou via ferramentas
http://localhost:8080

4. Acesse a documentação Swagger:
   http://localhost:8080/swagger-ui/index.html

## Testes
Os testes automatizados dos principais endpoints estão localizados em: src/test/java/com/example/CP1/CarroControllerTest.java

Eles cobrem:

Inserção de carro

Listagem por potência

Listagem por economia

Consulta por tipo

Atualização e exclusão

Para executar os testes: ./mvnw test