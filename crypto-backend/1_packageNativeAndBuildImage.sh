#!/bin/bash
set -e
mvn clean package -Pnative -DskipTests -Dquarkus.native.container-build=true

docker build -t aldo/crypto-quarkus:1.0.0-SNAPSHOT -f src/main/docker/Dockerfile.native .
