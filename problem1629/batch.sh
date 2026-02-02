#!/usr/bin/env bash

# 生成 test_batch.sh
while read line; do
  echo "curl -s -X POST http://localhost:8080/api/poker/evaluate \\"
  echo "  -H 'Content-Type: application/json' \\"
  echo "  -d '{\"inputLine\": \"$line\"}'"
  echo ""
done < input.txt > test_batch.sh

chmod +x test_batch.sh