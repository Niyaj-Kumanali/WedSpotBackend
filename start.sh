#!/bin/sh

# Set memory and startup optimizations for Render's free tier
# TieredStopAtLevel=1 speeds up startup significantly in constrained environments
JAVA_OPTS="-Xmx128m -Xms64m -XX:TieredStopAtLevel=1"

echo "Starting API Gateway on port ${PORT:-8080}..."
# Start Gateway FIRST to satisfy Render's health check ASAP
java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar api-gateway.jar &

# Very short delay to let Gateway start its listener
sleep 2

echo "Starting Service Registry on port 8761..."
java $JAVA_OPTS -jar service-registry.jar &

# Wait for registry to start initialized phase
sleep 5

echo "Starting Auth Service on port 8081..."
java $JAVA_OPTS -jar auth-service.jar &

wait