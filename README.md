# Person Resource
This ia a Java Spring Boot API application to handle CRUD operations for a Person resource.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Clone the Repository](#clone-the-repository)
    - [Database Configuration](#configure-the-database)
    - [Build and Run](#build-and-run-the-application)
- [Schemas and Diagrams](#uml-diagrams)
- [Testing](#testing)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)


### Features
* `Create Person`
* `Find person by name`
* `Find all persons`
* `Update person details`
* `Delete person`

### Technologies used:
* `Java`
* `Springboot`
* `mySQL`
* `Swagger Docs`
* `JUnit`
* `Mockito`

### Prerequisites:
* `Java 8 or higher`
* `Maven`
* `mySQL Database`
* `Port ${SERVER_PORT} open and free`

[![My Skills](https://skillicons.dev/icons?i=java,spring,mysql,postgresql,postman)](https://skillicons.dev)

# Getting Started
### Clone the Repository
```
git clone https://github.com/BlackTechyGirl/person-Api.git 
```

### Configure the database
Create a mySQL database and update the database configuration in the `application-{profile}.properties` file. The default active profile is "dev"
```properties
SERVER_PORT=
db.host=
db.name=
db.username=
db.password=
db.port=
```

### Build and Run the Application
Navigate to the project directory and build the application using Maven:
```
cd url-shortener
mvn clean install
```
Run the application using Maven:
```
mvn spring-boot:run
```
The application will start running on `http://localhost:8080`.

## UML Diagrams
* [UML Diagram](https://drive.google.com/file/d/1tJ1UUtCb9O2cGmNkxJj8hqnG9mKPjgdi/view?usp=drive_link)

## Testing
You can run automated tests for the API using the provided test scripts. Make sure you have followed the [Getting Started](#getting-started) steps before running the tests.
```
mvn test
```

## Documentation
The API documentation is available through Swagger UI. You can access it using the following link:
* [Swagger Docs](https://zuri-task-production.up.railway.app/swagger-ui.html)
* [Postman Documentation](https://documenter.getpostman.com/view/24879226/2s9YC1XF51)
* [Landing Page](https://zuri-task-production.up.railway.app/api/info)

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these guidelines:

* Fork the repository
* Create a new branch for your feature or bug fix
* Make your changes and submit a pull request
* Provide a clear description of your changes

## Developer & Engineer
Martha Danladi
* [GitHub (BlackTechyGirl)](https://github.com/BlackTechyGirl)
* [LinkedIn (Martha Danladi)](https://www.linkedin.com/in/martha-danladi-018088227/)
* [Email(Martha Danladi)](mailto:marthadanladi653@gmail.com)

## License
This project is licensed under the [MIT license](https://opensource.org/license/mit/)