# Microservice blueprint project

This projects demonstrates the communication between multiple microservices.

This project consists of the following projects:

* Timeservice
* Helloservice

## Timeservice
A simple service providing a `/time` endpoint returning the current time.

## Helloservice
A service providing a `/hello` endpoint returning 'Hello world' and the current time, recieved from the `Timeservice` endpoint.

# Executive Summary

1. Create executable .jars using `mvn clean package`
2. Start `timeservice` on port 8082 using `java -jar demo-timeservice-0.0.1-SNAPSHOT.jar`
3. Start `helloservice` on port 8081 using `java -jar demo-helloservice-0.0.1-SNAPSHOT.jar`
4. Launch browser and open [http://localhost:8081/hello](http://localhost:8081/hello) and see that the service returns 'Hello World' and the current time recieved from the `timeservice`

# Microservice communication

The `Helloservice` uses [Feign](https://github.com/Netflix/feign) to communicate with the `Timeservice`.

    Feign abstracts the Rest Client and Unmarshalling of JSON objects.
    
See `Timeclient.java` for declaration (and hard wiring) and `HelloService.java` for usage. NOTE: Do not forget to add `@EnableFeignClients` to the application class.