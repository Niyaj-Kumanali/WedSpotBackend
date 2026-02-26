#!/bin/sh

# Set memory limits to fit within Render's free tier (512MB)
JAVA_OPTS="-Xmx128m -Xms64m"

echo "Starting API Gateway on port ${PORT:-8080}..."
# Start Gateway FIRST to satisfy Render's health check immediately
java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar api-gateway.jar &

echo "Starting Service Registry on port 8761..."
java $JAVA_OPTS -jar service-registry.jar &

echo "Starting Auth Service on port 8081..."
java $JAVA_OPTS -jar auth-service.jar &

wait