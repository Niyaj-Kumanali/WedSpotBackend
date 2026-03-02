# -------- Stage 1: Build --------
FROM eclipse-temurin:25-jdk-alpine AS build
WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# -------- Stage 2: Run --------
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# JVM Optimizations for Render Free Tier (512MB RAM)
# -XX:TieredStopAtLevel=1 improves startup time
ENTRYPOINT ["java", "-Xmx256m", "-XX:TieredStopAtLevel=1", "-jar", "app.jar"]