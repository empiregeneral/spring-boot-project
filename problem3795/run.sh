#! /bin/bash

#java -javaagent:/Users/empiregeneral/Desktop/arthas-bin/arthas-agent.jar  \
#     -Darthas.agent-id=problem3795 \
#     -Darthas.app-name=spring-boot-problem3795 \
#         -Darthas.tunnel-server=ws://0.0.0.0:7777/ws
java -jar -Xms512m \
  -Xmx512m \
  -XX:MetaspaceSize=256m \
  -XX:MaxMetaspaceSize=512m \
  -XX:MaxDirectMemorySize=256m \
  -XX:ReservedCodeCacheSize=240m \
  -XX:MaxRAMPercentage=90.0 \
  -jar target/problem3795-0.0.1-SNAPSHOT.jar --server.port=8083
