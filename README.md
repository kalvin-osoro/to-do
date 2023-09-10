# to-do


# Spring Boot Application

This repository contains a Spring Boot application that you can run locally. Follow the instructions below to set up and run the application.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK):** Install a compatible version of JDK (Java 17 has been used for this project).
- **Maven:** Make sure you have Apache Maven installed.

## Clone the Repository

1. Clone this repository to your local machine using Git:

   ```shell
   git clone https://github.com/kalvin-osoro/to-do.git

## Set up a MySQL Database with the name items on you local machine and configure the applications.yml file to connect with it
edit the username and password fields in application.yml file to match your database credentials
Start the MySQL server

## Build and Run the application

1. Navigate to the project directory
2. Build the application using maven
   ```shell
   mvn clean install
3. Run the application
   ```shell
   mvn to-do:run

   
The application will start locally, and you can access it at http://localhost:8080.
You can test the APIs using Postman

#### Alternatively once you have cloned the application, you can open it in your preferred IDE i.e Intellij and run the application   



# testing the API endpoints:

### 1. Create a new to-do item with a title and description.
   http://localhost:8080/items/add-item
### 2.  Retrieve a list of all to-do items.
  http://localhost:8080/items/
### 3. Retrieve a single to-do item by its unique identifier.
   http://localhost:8080/items/update/2
### 4.  Update a to-do item's title and/or description.

### 5. Delete a to-do item.
   http://localhost:8080/items/delete/5
   
   





   
