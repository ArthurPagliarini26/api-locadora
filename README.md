# API Locadora

API REST desenvolvida em Java com Spring Boot para realizar operações de consulta e alteração de dados do banco de dados Sakila.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Swagger / OpenAPI
- Maven

## Banco de dados

O projeto utiliza o banco de dados **Sakila**, um banco de exemplo do MySQL.

As principais tabelas utilizadas neste projeto são:

- `pais`
- `cidade`

## Funcionalidades

A API permite:

- Listar países
- Buscar país por ID
- Cadastrar país
- Atualizar país
- Atualizar parcialmente um país
- Deletar país
- Listar cidades
- Buscar cidade por ID
- Cadastrar cidade
- Atualizar cidade
- Atualizar parcialmente uma cidade
- Deletar cidade

## Estrutura do projeto

O projeto segue uma estrutura baseada em camadas:

```text
src
└── main
    └── java
        └── br.com.ctw.api_locadora
            ├── controller
            ├── entity
            ├── exception
            ├── repository
            └── service
