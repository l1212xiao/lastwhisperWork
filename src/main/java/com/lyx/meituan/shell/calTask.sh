#!/bin/bash

echo "begin run task: "$1
curl 10.184.128.144:8080/test/ofwOrderSummary?taskName=calculateHistoryManual&date=$1 \
&& curl 10.184.128.144:8080/test/ofwOrderSummary?taskName=calculateTotalQuantityV1History&date=$1
echo "end run task: "$1