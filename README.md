# KaiburrTask1
## Java REST API for Managing Server Objects with MongoDB

This Java application provides a REST API for searching, creating, and deleting "server" objects using Spring Boot and MongoDB.

Check out the live demo: [TODO App](https://kaiburrtask1.netlify.app/)

## Table of Contents
- [Project Setup](#project-setup)
- [Configuration](#configuration)
- [Creating a Server Entity](#creating-a-server-entity)
- [Creating a Server Repository](#creating-a-server-repository)
- [Creating REST Endpoints](#creating-rest-endpoints)
- [Running the Application](#running-the-application)
- [Testing the API](#testing-the-api)

## Project Setup

### Step 1: Set Up the Project

Create a new Maven or Gradle project in your preferred IDE and add the necessary dependencies for Spring Boot and MongoDB.

For a Maven project, add the following dependencies to your `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
</dependencies>
```

### Step 1: Configure MongoDB

In your application.properties (or application.yml) file, configure the MongoDB connection properties. Replace the placeholders with your MongoDB server details.

```
spring.data.mongodb.host=your-mongodb-host
spring.data.mongodb.port=27017
spring.data.mongodb.database=your-database-name
```

### Step 3: Create a Server Entity

Create a Java class to represent the "Server" entity. This class will be used to map the server data to and from the MongoDB database.

java code:
```
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servers")
public class Server {
    @Id
    private String id;
    private String name;
    private String language;
    private String framework;

    // Constructors, getters, setters, and other methods
}
```

### Step 4: Create a Server Repository

Create a repository interface that extends MongoRepository to perform CRUD operations on the "Server" entity.

java code:
```
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, String> {
    // Custom query methods for searching by name
    List<Server> findByNameContaining(String name);
}
```

### Step 5: Create REST Controller

Create a REST controller to define the API endpoints for creating, retrieving, and deleting server objects.

java code:
```
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    // Define endpoint methods
    // ...
}
```

### Step 6: Run the Application

Create a main class with the @SpringBootApplication annotation to bootstrap the Spring Boot application.

java code:
```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApiApplication.class, args);
    }
}
```

### Step 7: Test the API

You can test the API using tools like Postman, curl, or any other HTTP client by sending requests to the defined endpoints:

```
GET /servers: Retrieve all servers.
GET /servers/{id}: Retrieve a server by ID.
POST /servers: Create a new server.
PUT /servers/{id}: Update a server by ID.
DELETE /servers/{id}: Delete a server by ID.
GET /servers/search?name={name}: Find servers by name.
Remember to replace {id} and {name} with the actual server ID and name when making requests.
```

### Configuration

Before running the application, ensure you have configured the MongoDB connection details in the application.properties file as mentioned in Step 2.

### Running the Application

To run the application, follow these steps:

1. Build the application:

bash code:
```
./mvnw clean install
```
2. Run the application:

bash code:
```
./mvnw spring-boot:run
The API will be accessible at http://localhost:8080.
```
### API Endpoints
```
GET /servers: Retrieve all servers.
GET /servers/{id}: Retrieve a server by ID.
POST /servers: Create a new server.
PUT /servers/{id}: Update a server by ID.
DELETE /servers/{id}: Delete a server by ID.
GET /servers/search?name={name}: Find servers by name.
```

### Example Requests

Here are examples of how to make requests to the API:

#### Create a Server

bash code
```
curl -X POST -H "Content-Type: application/json" -d '{
    "name": "my centos",
    "language": "java",
    "framework": "django"
}' http://localhost:8080/servers
```

#### Retrieve All Servers

bash code
```
curl http://localhost:8080/servers
Retrieve a Server by ID
```

bash code
```
curl http://localhost:8080/servers/{id}
Update a Server by ID
```

bash code
```
curl -X PUT -H "Content-Type: application/json" -d '{
    "name": "updated name",
    "language": "updated language",
    "framework": "updated framework"
}' http://localhost:8080/servers/{id}
```

#### Delete a Server by ID

bash code
```
curl -X DELETE http://localhost:8080/servers/{id}
```

#### Find Servers by Name

bash code
```
curl http://localhost:8080/servers/search?name={name}
```

Replace {id} and {name} with actual values when making requests.
