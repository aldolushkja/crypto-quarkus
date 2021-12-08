#!/bin/bash
set -e

kubectl scale --replicas=10 deployment/crypto-quarkus