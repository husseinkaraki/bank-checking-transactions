# Bank Checking Transactions


## Documentation

### Project Management
You can find the task board [here](https://trello.com/b/n5qkiS16/proton-forest-banking-checking-transactions). 

### Database Diagram
You can find the database diagram [here](https://dbdiagram.io/d/64d3b91d02bd1c4a5e835f39) or [here](https://lucid.app/lucidchart/2a4ee6ad-df96-48ea-a5fb-3074eb21ea90/edit?invitationId=inv_0b4dcdfc-76e2-475a-9b3c-5a75d87969d7&page=0_0#).


## Features

### Integrations

#### RESTful API
This API consumes transactions with a RESTful interface. Visit the OpenAPI spec for integration details. 


## Dependencies 

### Spring Dependencies
Created with Spring Boot inilitizr, the following dependencies were added. 

- Lombok
- Spring Boot Dev Tools
- Spring Configuration Processor
- Docker Compose Support
- Spring Web
- Spring for GraphQL
- PostgreSQL Driver
- Spring Boot Actuator
- Influx
- Spring for Apache Kafka

### Database Dependdncies

## Build

- Java 17
- Spring Boot 3.1.2 
- Gradle 

## Setup

### Influx
To get influx running, `cd influx` and `docker run -p 8086:8086 -v myInfluxVolume:/var/lib/influxdb2 influxdb:latest`. 

![](/pics/influx.png)

