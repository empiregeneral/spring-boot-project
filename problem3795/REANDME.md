```bash
curl -X POST   -H "Content-Type: application/json"   http://localhost:8080/api/poker/generate
```

```bash
curl -X POST http://localhost:8080/api/poker/query \
  -H "Content-Type: application/json" \
  -d '{"hand": "AH KH QH JH TH"}'
```