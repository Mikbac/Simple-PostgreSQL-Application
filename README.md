# Simple PostgresSQL Application

## Table of contents
* [API Endpoints](#api-endpoints)
* [Building](#building)
* [Running](#running)
* [Access](#access)
* [Technologies](#technologies)



### Building

```sh
    $ mvn install
```

### Running   

```sh 
    $ cd target
    $ java -jar artifact-0.0.1-SNAPSHOT.war
```

### Access
Open the browser and hit
```
http://localhost:8080/table
```
```
http://localhost:8080/swagger-ui.html#/
```

### API Endpoints
|Endpoints|Usage|Params|Example|
|---|---|---|---|
|```GET /tables ```|Get all tables.|---|```GET /tables ```|
|```GET /tables/uniqueTable/{column} ```|Get tables with the same column.|```{column}``` - column name|```GET /tables/uniqueTable/kolumna1```|
|```GET /tables/repeatedTable/{column} ```|Get tables with the unique column.|```{column}``` - column name|```GET /tables/repeatedTable/kolumna1```|

### Technologies

* [JDK 8](https://www.oracle.com/technetwork/java/index.html)

* [Spring Boot - 2.0.1.RELEASE](https://spring.io/projects/spring-boot) 

* [Maven](https://maven.apache.org/)

* [PostgreSQL](https://www.postgresql.org/)

* [Hibernate](https://hibernate.org/)

* [JUnit 4](https://junit.org/junit4/)

* [Lombok](https://projectlombok.org/)

* [Swagger](https://swagger.io/)

* [Thymeleaf](https://www.thymeleaf.org/) 
