## Customers Service
A service was created to retreive data from customers, in this case phone numbers, and display it in a single page application. <br>
This project was developed using Angular 13.1.2 for the front-end and Java 11 with Spring Boot 2.6.2 for the back-end.

## Installing / Getting started
To run this application you will need Docker and Docker-compose. Go to the root directory of the project (where docker-compose.yml is) and execute the command:
```shell
docker-compose up -d --build
```

The docker-compose file will do all the job and start the application at the url http://localhost:4200.

To stop the application just execute the following command:
```shell
docker-compose stop
```