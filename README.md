# Bank Checking Transactions - IN PROGRESS
Bank Checking Transactions is a sample Spring Boot project that demonstrates how to leverage Spring Boot and Postgres to accomplish the task of storing transactions and checking balances. It uses a couple different interfaces, including REST, GraphQL, and Apache Kafka. There are also some management tools such as PgAdmin, Influx, and Kafka Admin Portal to manage the dependent infrastructure. Test Driven Development (TDD) was used to develop the application. Additoinal libries were used, including Lombok, Jakarta Bean Validation, Hibernate Validator, and JPA. 

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

## Setup Dev Env


### VS Code
Install the proper extenstions. Download jdk 17 and install. Install gradle. Update your `settings.json` to include your jdk classpath.

e.g. 
```
{
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-17",
      "path": "/home/husseinroot/jdk/amazon-corretto-17.0.8.8.1-linux-x64",
      "default": true
    },
  ],
  "java.configuration.updateBuildConfiguration": "automatic",
  "java.compile.nullAnalysis.mode": "automatic",
  "java.format.settings.url": "eclipse-formatter.xml",
  "[java]": {
    "editor.defaultFormatter": "redhat.java",
  },
  "editor.formatOnSave": true,
  "editor.codeActionsOnSave": {
    "source.organizeImports": true,
  },
}
```

<kbd>Alt</kbd> + <kbd>Shift</kbd> + <kbd>F</kbd> or save document to format your java file.
<kbd>Alt</kbd> + <kbd>Shift</kbd> + <kbd>O</kbd> or save document to optimize your imports for Windows.
<kbd>option</kbd> + <kbd>Shift</kbd> + <kbd>O</kbd> or save document to optimize your imports for Mac.

Note: You may have issues with Intellisence detecting static imports. 

### Influx
To get influx running, `cd influx` and `docker run -p 8086:8086 -v myInfluxVolume:/var/lib/influxdb2 influxdb:latest`. 

![](/pics/influx.png)

### Postgres
To start your database, run `docker-compose -f docker-compose.yml up`. Then login with user `postgres` and password `example`. Setup a username, password, organization name, and API Token. Then update the local `application.yml` with the credentials. You may have issues if you're running everything from within a WSL2 environement - try running `ip addr` and getting the eth0 IP, and using that as your host. 

![](/pics/pgadmin.png)
![](/pics/transactions.png)

### Kafka
To start Kafka, you first need to update the `docker-compose.yml` file under `./kafka/docker-compose.yml`. You need to update the volumes to a path where kafka can mount its data. You need to give kafka permission to access this folder. So run `sudo chown -R 1001:1001 /path/to/kafka-persistence`. In my case, it would be` /home/husseinroot/dev/bank-checking-transactions/kafka/dir`. Notice, in `application.yml` under `spring.kafak.bootstrap-servers` the value is `kafka:9092`. This is using the docker container networking, meaning you can use the container name as the hostname. 


### Additional Libraries
Using Jakarta Validatoin (the interface, previously known as javax) and Hibernate Validator for bean validation. Jackson does not support things like null checks on json fields (`TransactionRequest.java`).

### JSON Body for the requests

POST /transaction
```
{
    "transaction" : {
        "checkingAccountId" : "12345",
        "amount" : 1234,
        "createdAt" : "2023-09-04T14:30:00.123+03:00"
    }
}
```

### Building your project 
You may need to make your gradle file executable, so `sudo chmod +x ./gradlew`. Set your `JAVA_HOME` by `export JAVA_HOME=/home/husseinroot/jdk/amazon-corretto-17.0.8.8.1-linux-x64`. 