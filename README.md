# dogphotosfetchersaverapi
Spring Boot REST API app with Lombok, Spring Web, Spring Security, Validation, JPA, PostgreSQL, OpenFeign, CORS. This app will fetch data from external API and save it into database.

EXPLANATION and How to use:



First of all, when you will run the application, Spring Security will automatically generate password for security. You can see that generated password in logs. Use `user` as username and your `generated password` for password. You have to use the password and username to be able to send requests. 



I am going to explain all in detail because I had all these issues and I have tried to search and find a solution by my own side.
All programmers can have these kinds of issues. That's why I am explaining everything in depth.

If you need any help, do not hesitate to reach out to me: `albendemu@gmail.com`.
We all are learning new things every day from life experience or from the work and we all can teach what we think that can be valuable to the society.

While creating Spring Boot application it is important to declare application.properties file according your application:

`spring.datasource.url=jdbc:postgresql://localhost:5432/postgres` 

`spring.datasource.username=root`

`spring.datasource.password=root`

`spring.jpa.hibernate.ddl-auto=update`

`spring.jpa.show-sql=true`

`spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect`

`spring.jpa.properties.hibernate.format_sql=true`


For spring.datasource.url=jdbc:postgresql://localhost:5432/postgres you can change postgres at the end to your own database name:
For example: spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabasename

For spring.datasource.username=root you have to change `root` and set to the username which you have created it during the creation of your database. For example: spring.datasource.username=mydatabaseusername

For spring.datasource.password=root you have to change `root` and set to the password which you have created it during the creation of your database. For example: spring.datasource.username=mydatabasepassword

When it comes to `spring.jpa.hibernate.ddl-auto=update`, we are adding that property to our application to create table and save data there. Instead of `update` if we use `create-drop` it will create database in each run of Spring Boot Application and will delete it when we stop the app. You can use the `validate` feature as well. The main DIFFERENCE between validate and update is:
Update feature will update the database schema if there is any new field or propery added to our entity but validate feature will make sure that the database schema matches the entities in the application but will not make any change to that.
If we use `validate` and we have some new entities, then our application will fail to start due to database schema mismatch.



It has following methods: 

`getAllDogs()`; you can use `GET` request `localhost:8080/alldogs` to get all dogs from database.


`getOneDogById()`; you can use `GET` request `localhost:8080/alldogs/{id}` to get dog by `ID`.


`saveDogs()`; you can use `GET` request to get data from `URL`, save it into database and show it in the request.
use GET request with `localhost:8080/{dogtype}/savedogs/{count}`. You can declare `dogtype` variable as "hound" and `count` as integer. For example: GET `localhost:8080/hound/savedogs/5` -> this request will fetch data from the following `URL`: `https://dog.ceo/api/breed/hound/images/random/5` and will save it to the database.


`saveOneDog()`; you can use `GET` request `localhost:8080/{dogtype}/saveonedog` to fetch one dog from the following url: `https://dog.ceo/api/breed/hound/images/random` and save it into database. I have declared `dogtype` as hound(`localhost:8080/hound/saveonedog`). You can check the official documentation and can see what you can use as dogtype in the following link: `https://dog.ceo/dog-api/documentation`


`updateDog()`; you can use `PUT` request `localhost:8080/update-dog/{id}` to update the data in database. For example: Use postman and send `PUT` request with the following body {"message":"testing","status":"failed"} to the following API: PUT `localhost:8080/update-dogs/1`. If you have dog with id `1` in your database, it will change its message and status accordingly.


`deleteDog()`; you can use `DELETE` request `localhost:8080/delete-dog/{id}` and delete dog with id. For example: DELETE `localhost:8080/delete-dogs/1`. It will delete dog with id `1`.
