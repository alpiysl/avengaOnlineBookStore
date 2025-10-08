# Multi-stage Dockerfile for API Automation Tests

# Stage 1: Build stage
FROM maven:3.9-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Compile the project
RUN mvn clean compile -DskipTests

# Stage 2: Runtime stage
FROM maven:3.9-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy compiled artifacts and dependencies from build stage
COPY --from=build /app /app
COPY --from=build /root/.m2 /root/.m2

# Environment variables for configuration
ENV BASE_URL="https://fakerestapi.azurewebsites.net"
ENV TEST_SUITE="src/test/test.xml"

# Create directory for reports
RUN mkdir -p extent-reports

# Default command to run tests
CMD ["sh", "-c", "mvn test -DsuiteXmlFile=${TEST_SUITE} && echo 'Tests completed. Reports available in extent-reports/'"]

# Alternative: To keep container running for report extraction
# ENTRYPOINT ["mvn", "test"]

