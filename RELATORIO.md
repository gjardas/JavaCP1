O objetivo deste projeto foi criar uma API em Java com Spring Boot para gerenciar um catálogo de carros. A API permite cadastrar, atualizar, excluir e buscar carros por critérios como potência, economia e tipo de veículo.

A estrutura do projeto foi organizada em pacotes:

model: contém a classe Carro, com os atributos marca, modelo, ano, potência, economia, tipo e preço.

repository: interface CarroRepository que estende JpaRepository para facilitar as consultas.

service: classe CarroService com a lógica de negócio.

controller: classe CarroController com os endpoints.

exception: tratamento de erro com ResourceNotFoundException.

A API possui os seguintes endpoints:

GET /carros/potencia: retorna os 10 carros mais potentes.

GET /carros/economia: retorna os 10 carros mais econômicos.

GET /carros/eletricos: retorna todos os carros elétricos.

GET /carros/{id}: retorna os dados de um carro pelo ID.

POST /carros: adiciona um novo carro.

PUT /carros/{id}: atualiza um carro existente.

DELETE /carros/{id}: remove um carro.

Os testes foram feitos com JUnit e @SpringBootTest, usando MockMvc. Testamos os principais endpoints e o comportamento esperado em situações normais e de erro.

O projeto foi versionado com Git, tem documentação simples no README e pode ser executado com o comando mvn spring-boot:run.

A aplicação está funcionando corretamente e cumpre todos os requisitos.