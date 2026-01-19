## Running with Docker

This project includes a multi-stage Dockerfile and a Docker Compose setup for containerized development and deployment.

### Project-Specific Docker Requirements
- **Base Image:** Uses `eclipse-temurin:17-jdk` for building and `eclipse-temurin:17-jre` for running (Java 17 required).
- **Build Tool:** Uses the Maven Wrapper (`mvnw`) included in the project for building the application.
- **Ports:** The application exposes port **8080** (default for Spring Boot).

### Environment Variables
- No required environment variables are set by default in the Dockerfile or Compose file.
- If you need to provide environment variables, you can uncomment and use the `env_file` section in `docker-compose.yml`.

### Build and Run Instructions
1. **Build and start the application:**
   ```sh
   docker compose up --build
   ```
   This will build the image using the provided Dockerfile and start the `java-app` service.

2. **Access the application:**
   - The application will be available at [http://localhost:8080](http://localhost:8080)

### Special Configuration
- The Dockerfile creates a non-root user (`appuser`) for running the application securely.
- JVM options are set for container awareness: `JAVA_OPTS="-XX:MaxRAMPercentage=80.0"` (can be overridden if needed).
- If your application requires additional services (e.g., a database), you can extend the `docker-compose.yml` by uncommenting and configuring the relevant sections.

### Exposed Ports
- **java-app:** `8080` (host) → `8080` (container)

---

_If you add external dependencies (like a database), update the `docker-compose.yml` and this section accordingly._
