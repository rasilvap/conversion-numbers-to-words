# conversion-numbers-to-words

This application converts a input number to its equivalent in English words.

## High-level project architecture:
<img src = "src/main/resources/images/GeneralOverview.png" />

## Tech Stack

-Java version 11

-Spring boot

-Junit v5

-Loombook

-spring-boot-starter-web

-maven

-Docker

-In this application, we do not need any database connectivity.

##  Classes Diagram


# Run the API Locally 🚀


To run it locally you must follow these three steps:

In the terminal, located in the root directory (conversion-numbers-to-words) run ```mvn clean install```

Make sure that the .jar file was generated in the target directory:

<img src = "src/main/resources/images/jarGenerated.png" />


In the same directory, run the command ```docker build -t numbers-conversion-to-words:1.0 .``` to create the APP image.

Make sure that the image was created with the ```docker images``` command: 

<img src = "src/main/resources/images/DockerImage.png" />

Then in the same terminal run the command:  ```docker run -p 8080:8080 numbers-conversion-to-words:1.0``` to run the app in local in the 8080 port.

Postman Collection 📢

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/34cd02999866616572f7)
