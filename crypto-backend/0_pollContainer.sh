#!/bin/bash
while :; do
  curl -XGET "http://localhost:8080/ping"
  printf "\n"
  sleep 1s
done
