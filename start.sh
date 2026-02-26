#!/bin/sh

# Set memory limits to fit within Render's free tier (512MB)
# Registry: 96MB, Auth: 128MB, Gateway: 128MB. Total ~350MB + OS overhead.
JAVA_OPTS="-Xmx128m -Xms64m"

echo "Starting Service Registry on port 8761..."
java $JAVA_OPTS -jar service-registry.jar &

# Wait for registry to be ready
sleep 15

echo "Starting Auth Service on port 8081..."
java $JAVA_OPTS -jar auth-service.jar &

# Wait for auth service to be ready
sleep 10

echo "Starting API Gateway on port ${PORT:-8080}..."
# Render provides the PORT env var; we map it to the Gateway
java $JAVA_OPTS -Dserver.port=${PORT:-8080} -jar api-gateway.jar &

wait