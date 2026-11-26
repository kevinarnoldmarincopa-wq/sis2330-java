# API de Empleados

Proyecto desarrollado para la Semana 15 de SIS2330.

## Objetivo

Desarrollar una API REST para gestionar empleados utilizando Java,
Spring Boot, Maven y una base de datos H2.

## Arquitectura

- Domain: entidades Employee y Salary, e interfaz del repositorio.
- Application: DTOs y servicio de empleados.
- Infrastructure: persistencia mediante Spring Data JPA.
- Presentation: controlador REST.

## Funcionalidades

- Registrar empleados.
- Listar empleados.
- Buscar empleados por ID.
- Actualizar empleados.
- Eliminar empleados.

## Endpoints

| Método | Ruta | Función |
|---|---|---|
| POST | /api/employees | Registrar |
| GET | /api/employees | Listar |
| GET | /api/employees/{id} | Buscar |
| PUT | /api/employees/{id} | Actualizar |
| DELETE | /api/employees/{id} | Eliminar |

## Tecnologías

- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- H2 Database
- JUnit
- Mockito

## Ejecutar pruebas

```bash
bash mvnw clean test
