# -------- Build Stage --------
FROM maven:3.9.12-eclipse-temurin-25-alpine AS build
WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests

# -------- Run Stage --------
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app

# Copy the built JARs
COPY --from=build /app/service-registry/target/*.jar service-registry.jar
COPY --from=build /app/auth-service/target/*.jar auth-service.jar
COPY --from=build /app/api-gateway/target/*.jar api-gateway.jar

# Copy and prepare the startup script
COPY start.sh start.sh
RUN chmod +x start.sh

# Render injects PORT env var; start.sh will handle mapping it to Gateway
EXPOSE 8080

ENTRYPOINT ["./start.sh"]