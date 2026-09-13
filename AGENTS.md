# Base44 Dev Environment

## Project
Spring Boot 4.1 REST API — student management system (students, courses, teachers, enrollments).
Java 21, Maven, MySQL 8, Spring Data JPA, Lombok, Bean Validation.

## Setup
- `docker compose -f docker-compose.base44.yml up -d --build`
- MySQL runs as a compose service (`db`); DB credentials are inline in compose (local infra, not secrets).
- No `application.properties` in the repo (gitignored). All config is via environment variables in compose:
  `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME/PASSWORD`, `SPRING_JPA_HIBERNATE_DDL_AUTO=update`, `SERVER_PORT=3000`.
- `spring-boot-devtools` added to pom for live reload (auto-restart on classpath change).

## Verify
- `curl http://localhost:3000/students` → `[]` (empty list, confirms app + DB are up).
- Create: `curl -X POST http://localhost:3000/students -H 'Content-Type: application/json' -d '{"firstName":"Test","lastName":"User","email":"t@t.com","phoneNumber":"1234567890","course":"CS","enrollmentDate":"2026-01-01"}'`

## Endpoints
- `/students` — CRUD (POST, GET, GET/{id}, PUT/{id}, DELETE/{id})
- `/courses` — CRUD (POST, GET, GET/{id}, DELETE, PUT)
- `/teachers` — CRUD (POST, GET, GET/{id}, DELETE, PUT)
- `/enrollments` — (POST, GET)

## Notes
- No frontend — this is a backend-only REST API. A `HomeController` provides a simple HTML landing page at `/` listing the endpoints (for the preview).
- The Course/Teacher/Enrollment controllers have empty stub method bodies (original code) — only Student CRUD is fully implemented.
- JPA `ddl-auto=update` auto-creates/updates tables on boot.
- Source is bind-mounted; edits recompile via devtools restart. Run `docker compose -f docker-compose.base44.yml restart app` after structural changes if devtools doesn't pick them up.
