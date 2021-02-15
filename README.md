# parkingSystem

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Installation](#installation)
* [Usage](#usage)

## General info
This project is parking system on housing estate. Enables users to see free spaces as well as change state of their parking space. To change state of parking space user needs to be logged in. \
Users and parking spaces data is kept in MySQL Database.\
\
There are two branches in the project - master with backend only and thymeleaf with frontend implemented with Thymeleaf. \
\
Swagger UI was built to the project, so that it is easier to understand what endpoints are available.
  
## Technologies
Project is created with:
* Java 8
* Spring Boot
* Maven
* Spring Security
* MySQL database
* Thymeleaf
* Swagger
	
## Installation
To run this project, install it locally:

```
$ git clone git@github.com:hofman-iga/parkingSystem.git

Then run the following command in a terminal window (in the complete) directory:

$ mvnw spring-boot:run

```

## Usage

To access certain endpoins you need to be logged in. Basic authentication of Spring Security was used in the project.

 

GET
/parking/admin \
Endpoint available only for admin; displays all users data.

GET
/parking/all \
Displays all parking spaces and their owners; no authentication needed.

GET
/parking/user \
Displays all data of logged user.

PUT
/parking/edit \
Endpoint enabling logged user changing his parking space state.

To edit parking space json format is required: \
{\
            "state": "occupied",\
            "dateToWhen": "01-02-2021"\
        }\
        \
=====THYMELEAF BRANCH====== 
\
\
In Thymeleaf version of the project editing space is possible via form.

GET
/parking/admin \
Endpoint available only for admin; displays all users data.

GET
/parking/all \
Displays all parking spaces and their owners; no authentication needed.

GET
/parking/user \
Displays all data of logged user.

GET
/parking/editSpace \
Endpoint enabling logged user changing his parking space state via form.

GET
/parking/modify \
Endpoint to which user is redirected after changing parking space details.
