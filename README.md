# Task Manager (Spring Boot)

Simple Task Manager REST API built with Spring Boot, Spring Data JPA and an H2 in-memory database.


## Features
- Task entity with: `id`, `title`, `description`, `deadline`, `completed`
- REST endpoints under `/tasks` (GET list, POST create)
- OpenAPI / Swagger UI for interactive testing
- H2 in-memory database for quick local testing

## Prerequisites
- Java JDK 21 (or compatible Java 17+ runtime)
- Maven

## Run locally
From the project root directory run:

```powershell
mvn spring-boot:run
```

Or build and run the packaged jar:

```powershell
mvn package
java -jar target/taskmanager_spring_java-1.0.0.jar
```

## Useful URLs (when app is running on `http://localhost:8080`)
- API base: `http://localhost:8080/tasks`
  - GET `http://localhost:8080/tasks` — list all tasks
  - POST `http://localhost:8080/tasks` — create a new task (JSON body)

- Swagger UI (interactive API docs):
  - `http://localhost:8080/swagger-ui/index.html`

- OpenAPI JSON:
  - `http://localhost:8080/v3/api-docs`

- H2 Console (DB inspector):
  - `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:tasksdb`
  - User: `sa` (leave password blank)

## Example requests
Get all tasks:

```powershell
curl http://localhost:8080/tasks
```

Create a task:

```powershell
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Buy groceries","description":"Milk, eggs","deadline":"2024-12-01","completed":false}'
```

## Notes / Troubleshooting
- If you have a `src/main/resources/data.sql` and you see an error like `Table "TASKS" not found` during startup, you can either:
  - Add to `src/main/resources/application.properties`:

    ```properties
    spring.jpa.defer-datasource-initialization=true
    ```

  - Or rename `data.sql` to `import.sql` so Hibernate executes it after schema creation.

- Swagger UI is provided by `org.springdoc:springdoc-openapi-starter-webmvc-ui` in `pom.xml`.

- If your environment uses a different Java version, update the `<java.version>` property in `pom.xml` accordingly.

## Project structure (high level)
- `src/main/java/.../entities` — JPA entity
- `src/main/java/.../repositories` — Spring Data repositories
- `src/main/java/.../service` & `serviceImpl` — business logic
- `src/main/java/.../controllers` — REST endpoints
- `src/main/resources` — `application.properties`, optional `data.sql`

## License
Unlicensed / demo project

