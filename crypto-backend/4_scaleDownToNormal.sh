#!/bin/bash
set -e

kubectl scale --replicas=1 deployment/crypto-quarkus