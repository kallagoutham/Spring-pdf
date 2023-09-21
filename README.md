# SPRING-PDF 

## Table of Contents

- Getting Started
- Prerequisites
- Installation
- Usage
- Acknowledgments

## Getting Started

This is a spring boot project which has a User and each and every user has different 
fields like username, firstName, lastName, phoneNumber and a myCv.
Here myCv is a @Lob(Large Object) which can store the files like .png, .pdf, .jpeg, .docx etc..

## Prerequisites

This project is configured to use jdk-11 and it is a maven project. To run this project you must 
ensure the postgres is running on http://localhost:5432 in your local environment. 
In order to run this project intially you have to update maven project and run maven clean, maven install.
Only then you can run it as a Spring Boot Application.
Install postman in order to test your endpoints.

To run maven clean and install from the command line use the below commands:

To build 						              : ``` mvn package -DskipTests```
To perform clean+install          : ```mvn clean package```
To run the spring boot application: ``` mvn spring-boot:run``` 

## Installation

To run this application make sure the jdk-11 is installed in your system and there is maven also 
installed in your application. Follow the official jdk and maven docs to install them in your local 
system.

## Usage

After running the application in your local system

To upload a user details use this endpoint. This endpoint is of POST type.
  ``` http://localhost:8080/api/v1/users/upload```
To view the cv uploaded by the particular User. This a GET type endpoint. This accepts a parameter id.
  ``` http://localhost:8080/api/v1/users/get/cv```
To download the cv uploaded the by the particular user. This is GET type endpoint. This accepts a parameter id.
  ``` http://localhost:8080/api/v1/users/download/cv```

## Acknowledgments

To develop this application I used the Spring Tool Suite 4, I also used some famous dependencies like 
lombok, spring-data-jpa.
