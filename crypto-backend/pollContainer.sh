#!/bin/bash
while :
do
    curl -XGET "http://localhost:8080/ping"
    sleep 3s
done