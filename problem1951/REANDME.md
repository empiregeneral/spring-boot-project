# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.13/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.13/maven-plugin/reference/html/#build-image)


```bash
curl -X GET http://localhost:8080/api/goldbach/equation-first -H "Content-Type: application/json" -d '{"evenNum": 900000}'
  ```

## 代码优化 & ToDo
1. listEquationAll使用分页算法通过response展现出来
2. 分块处理goldbach.in中的读取数据问题
3. 减少启动的时间
3.1 通过maven插件线构建primes数组和bitset的二进制文件
3.2 比较欧拉筛和爱思托尼斯筛的性能取舍
3.2 BitSet sieve还需要封装
3.3 异步获取序列化的数据