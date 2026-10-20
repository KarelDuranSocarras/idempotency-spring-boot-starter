# AGENTS.md - Idempotency Spring Boot Starter

## Build & Test
- **Build tool**: Maven (no Maven wrapper; use system `mvn`). `.mvn/` is empty.
- **Java version**: 21 (set in `pom.xml` via `maven.compiler.source`/`maven.compiler.target`).
- **Compile**: `mvn compile` (outputs to `target/`).
- **Test**: `mvn test` (no tests exist yet; will run with 0 tests and succeed).
- **Full package**: `mvn clean package` (use `-DskipTests` if you want to skip tests).
- **Clean**: `mvn clean`.

## Project Structure
- **Group/Artifact**: `io.github.KarelDuranSocarras:idempotency-spring-boot-starter` (v1.0-SNAPSHOT). It's intended as a library/starter, not a runnable app.
- **Entrypoint**: `src/main/java/io.github.KarelDuranSocarras/Main.java` - currently a trivial empty `main()` (placeholder). No application bootstrap yet.
- **Tests**: `src/test/java/` exists but is empty; `src/test/resources/` does not exist.
- **Resources**: `src/main/resources/` is empty.

## Conventions & Notes
- **Target directory**: `target/` is generated (gitignored). Never commit build artifacts.
- **No codegen/migrations**: No visible codegen, annotation processors configured generically via Maven default profile (no specific processors declared).
- **Verification order**: If modifying code, run `mvn compile` then `mvn test`. For packaging, `mvn clean package` is the canonical check.
- **Stability**: Pom is minimal; adding Spring Boot/starters will require updating dependencies - verify against existing `pom.xml` before assuming deps exist.