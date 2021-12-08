#!/bin/bash
set -e
mvn clean package -DskipTests

docker build -t aldo/crypto-quarkus:1.0.0-SNAPSHOT -f src/main/docker/Dockerfile.jvm .
