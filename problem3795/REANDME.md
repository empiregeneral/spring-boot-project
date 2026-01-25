```bash
curl -X POST   -H "Content-Type: application/json"   http://localhost:8080/api/poker/generate
```

```bash
curl -X POST http://localhost:8081/api/poker/query \
  -H "Content-Type: application/json" \
  -d '{"hand": "AH KH QH JH TH"}'
```

vmtool --action referenceAnalyze --className cn.edu.hdu.acm.problem3795.service.PokerService --objectNum 5 --backtraceNum 5


```bash
curl -X POST http://localhost:8080/api/poker/compare \
  -H "Content-Type: application/json" \
  -d '{"hand1":"2H 3D 5S 9C KD", "hand2":"2C 3H 4S 8C KH"}'
```

vmtool --action heapAnalyze --classNum 5 --objectNum 3