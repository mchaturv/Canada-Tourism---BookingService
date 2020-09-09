

# Project Title

Canada Tourism - A tourism Application for booking the tickets for beaches, nataional parks etc. across canada

## Canada-Tourism - BookingService
Booking Service - API's service to handle booking, transaction and ticketing for Canada tourism application

## Getting Started

Clone the project to your local system.

### Prerequisites

An Editor where you can run Sprintboot project and MySQL

### Installing

Import the whole project on your editor.
Open the application.properties file and make change on below field to point it your own database

```
spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb?createDatabaseIfNotExist=true
spring.datasource.username=<your username>
spring.datasource.password=<your password>

```

Build the application.

Once build successfully, run it on your local system. 

After application runs successfully you see below in your console

```
2020-03-05 15:55:15.005  INFO 17656 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-03-05 15:55:15.005  INFO 17656 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.31]
2020-03-05 15:55:15.028  INFO 17656 --- [  restartedMain] o.a.c.c.C.[.[.[/canadatourism]           : Initializing Spring embedded WebApplicationContext
2020-03-05 15:55:15.028  INFO 17656 --- [  restartedMain] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 549 ms
2020-03-05 15:55:15.101  INFO 17656 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2020-03-05 15:55:15.110  INFO 17656 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-5 - Starting...
2020-03-05 15:55:15.121  INFO 17656 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-5 - Start completed.
```

- Deploying the application

```
Deploy on your preffered choice
```


Now Open MySQL Workbench and verify the database "springbootdb" is created or not.
Once verified that database is created, run the sql scripts given in "data.sql" file.


## Running the tests

To verify the system is working, Open postman and run the below API for user registeration with your Details provided in JSON body.
ALL API'S ARE SHARED on POSTMAN 

### ALL API'S ARE SHARED on POSTMAN [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/7ea30c0621b7756e8608)
### JOIN POSTMAN[![Join project](https://run.pstmn.io/button.svg)](https://app.getpostman.com/join-team?invite_code=31fd3f45f9ef5ef0a8093574dae30576&ws=1ea50b19-3661-47e0-b1e2-194833c7c220)

```
http://localhost:8080/canadatourism/api/customer/user/register
```

Your will get a success response "201 CREATED" with your user details



## Authors

* **Mayank Chaturvedi** - *Work* - [Cloud Project](https://github.com/mchaturv/Canada-Tourism---User-Sevice)


See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.
* **Nihir Shah** - *Initial work* - [Cloud Project](https://git.cs.dal.ca/npshah/cloud-project)
