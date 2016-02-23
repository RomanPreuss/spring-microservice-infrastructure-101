# Microservice blueprint project

This projects demonstrates the communication between multiple microservices.

This project consists of the following projects:

* Timeservice
* Helloservice
* Eureka
* Hystrix Monitor
* Zuul Routing

**Further information:**

* https://github.com/kbastani/spring-cloud-microservice-example
* https://github.com/livelessons-spring/building-microservices
* https://github.com/rohitghatol/spring-boot-microservices
* [Monitoring Microservices](http://www.informit.com/articles/article.aspx?p=2437436)
* [Zuul at Netflix](https://github.com/Netflix/zuul/wiki/How-We-Use-Zuul-At-Netflix)

## Timeservice
A simple service providing a `/time` endpoint returning the current time.

## Helloservice
A service providing a `/hello` endpoint returning 'Hello world' and the current time, recieved from the `Timeservice` endpoint.

## Eureka
[Eureka](https://github.com/Netflix/eureka) is a service registry for resilient mid-tier load balancing and failover and used to discover services in a microservice environment.

# Executive Summary

1. Create executable .jars using `mvn clean package`
2. Start `timeservice` on port 8082 using `java -jar demo-timeservice-0.0.1-SNAPSHOT.jar`
3. Start `helloservice` on port 8081 using `java -jar demo-helloservice-0.0.1-SNAPSHOT.jar`
3. Start `eureka` service registry on port 8761 using `java -jar demo-helloservice-0.0.1-SNAPSHOT.jar`
4. Launch browser and open [http://localhost:8081/hello](http://localhost:8081/hello) and see that the service returns 'Hello World' and the current time recieved from the `timeservice`

# Microservice communication

The `Helloservice` uses [Feign](https://github.com/Netflix/feign) to communicate with the `Timeservice`.

    Feign abstracts the Rest Client and Unmarshalling of JSON objects.
    
See `Timeclient.java` for declaration and `HelloService.java` for usage. NOTE: Do not forget to add `@EnableFeignClients` and `@EnableEurekaClient` to the application class. To determine the correct service in the `Timeclient` class Eureka is used to discover the `time-service` (the `spring.application.name` name of the `timeservice`)

# Latency and fault tolerance + Monitoring
Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable.

# Configuration
There are two configuration files:

* `application.yml` default application properties file used to configure common properties of the application
* `bootstrap.yml` this properties file is used for the Eureka configuration