# Participantes
- Guilherme Ferreira Jardim - RM556814
- Fernando Fontes - RM555317

# API de Catálogo de Carros

Este projeto é uma API REST desenvolvida com Java e Spring Boot para gerenciar um catálogo de carros. A aplicação permite realizar consultas específicas relacionadas a desempenho, economia e tipo de veículo, bem como operações de manutenção (CRUD).

## Enunciado do Problema

Desenvolver uma Web API para gerenciar um catálogo de carros, fornecendo endpoints específicos para diferentes tipos de consultas relacionadas a desempenho, economia e tipo de veículo.

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

## Endpoints Obrigatórios

### Consulta

- `GET /carros/potencia`  
  Retorna os 10 carros com maior potência (ordem decrescente)

- `GET /carros/economia`  
  Retorna os 10 carros com maior economia (ordem decrescente)

- `GET /carros/eletricos`  
  Retorna todos os carros elétricos

- `GET /carros/{id}`  
  Retorna detalhes de um carro específico

### Manutenção

- `POST /carros`  
  Adiciona um novo carro ao catálogo

- `PUT /carros/{id}`  
  Atualiza os dados de um carro existente

- `DELETE /carros/{id}`  
  Remove um carro do catálogo

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Swagger (documentação)
- JUnit (testes)
- Maven

