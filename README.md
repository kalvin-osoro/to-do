# to-do


# Spring Boot Application

This repository contains a Spring Boot application that you can run locally. Follow the instructions below to set up and run the application.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK):** Install a compatible version of JDK (Java 17 has been used for this project).
- **Git:** Install Git on your local machine.
- **Maven:** Make sure you have Apache Maven installed.

## Clone the Repository

1. Clone this repository to your local machine using Git:


   ```shell
   git clone https://github.com/kalvin-osoro/to-do.git

## Build and Run the application

1. Navigate to the project directory
2. Build the application using maven
   ```shell
   mvn clean install
3. Run the application
   ```shell
   mvn to-do:run


The application will start locally, and you can access it at http://localhost:8080.

# testing the API endpoints:

## 1. Create a new to-do item with a title and description.
   http://localhost:8080/items/add-item
## 2.  Retrieve a list of all to-do items.
  http://localhost:8080/items/
## 3. Retrieve a single to-do item by its unique identifier.
   





   
