# spring-boot + dubbo + zipkin example

dubbo
> http://dubbo.apache.org/

dubbo-spring-boot-starter
> https://github.com/apache/incubator-dubbo-spring-boot-project/tree/0.1.x 

brave-instrumentation-dubbo-rpc
> https://github.com/openzipkin/brave/tree/master/instrumentation/dubbo-rpc

other instrumentations
> https://github.com/openzipkin/brave/tree/master/instrumentation

zipkin-server 及相关说明
> https://github.com/openzipkin/zipkin/tree/master/zipkin-server

本示例中如果同时配置了`zipkin`地址和`kafka`地址，优先使用`kafka`收集器。
```
zipkin:
  tracing:
    endpoint: http://devhost:8411/api/v2/spans
    kafka:
      bootstrap-servers: devhost:8092
      topic: zipkin
```

启动`zipkin-server`，地址、端口、路径根据实际情况调整
```
KAFKA_BOOTSTRAP_SERVERS=devhost:8092 QUERY_PORT=8411 java -jar zipkin.jar
```
