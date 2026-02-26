#!/bin/sh

echo "Starting Service Registry..."
java -jar service-registry.jar &

sleep 10

echo "Starting Auth Service..."
java -jar auth-service.jar &

sleep 10

echo "Starting API Gateway..."
java -jar api-gateway.jar &

wait