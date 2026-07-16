# Demo — Spring Boot 4 / Clean Architecture + DDD

## Requisitos

- Java 25
- (El wrapper de Gradle está incluido; no hace falta instalarlo)

## Correr la aplicación

```bash
./gradlew bootRun
```

## Ejecutar tests

```bash
./gradlew test
```

## Estructura de paquetes

```
src/main/java/com/org/demo/
├── domain/
│   ├── model/        # Entidades, value objects, agregados
│   └── port/         # Interfaces (puertos) de repositorios y servicios
├── application/      # Casos de uso (sufijo UseCase)
├── infrastructure/   # Adaptadores (implementaciones de puertos)
└── interfaces/
    └── rest/         # Controllers REST, DTOs, exception handlers
```

Regla de dependencia: `domain` no importa nada de Spring, JPA ni HTTP.
