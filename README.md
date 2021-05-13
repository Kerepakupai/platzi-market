# platzi-market
App desarrollada con Spring Bot y PostgreSQL

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Deploy from Console

```
java -jar -Xmx2048m -Dspring.profiles.active=pdn -Dserver.port=8080 platzi-market-1.0.jar
```

### Deploy Database to Heroku

```
heroku login
heroku create platzimarket
heroku addons:create heroku-postgresql
heroku config
```

### Update application properties
```
server.port=${PORT}

# Database
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
```

### Tell Heroku to use JDK 11
Create a file at $HOME_PROJECT system.properties
```
java.runtime.version=11
```

### Update active profile
Create a file at $HOME_PROJECT Procfile
```
web: java -jar -Dspring.profiles.active=pdn target/platzi-market-1.0.jar
```

### Push to Heroku
```
git push heroku main
```
