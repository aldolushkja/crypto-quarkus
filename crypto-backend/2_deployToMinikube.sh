#!/bin/bash

kubectl delete -f target/kubernetes/minikube.yml
kubectl apply -f target/kubernetes/minikube.yml
kubectl delete svc crypto-quarkus
kubectl expose deployment crypto-quarkus --type=LoadBalancer --port=8080