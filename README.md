<h1 align="center">Cities API REST</h1>

<p align="center">
<img src="./java-developer.png" height="150px" />
<img src="https://raw.githubusercontent.com/spring-projects/spring-framework/main/src/docs/spring-framework.png" height="150px" />
</p>

## About

Cities API is an application to show Brazil cities and distances between them.

This Project was developed for Java Developer Bootcamp in Digital Innovation One.

- Layers Separation
- CRUD Operations
- Communication via REST

## Technologies

- Java 11
- Spring Boot
- Lombok

## Run Project

### Clone Project

```git
git clone https://github.com/thiagotrs/cities-api.git
```

### RUN POSTGRES

```shell
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### POPULATE DATA

```shell
cd postgresql-data

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql
```

### API

```shell
mvn spring-boot:run
```

### URL

```
http://localhost:8080/cities
```

## Author

Thiago Rotondo Sampaio - [GitHub](https://github.com/thiagotrs) / [Linkedin](https://www.linkedin.com/in/thiago-rotondo-sampaio) / [Email](mailto:thiagorot@gmail.com)

## License

This project use MIT license, see the file [LICENSE](./LICENSE.md) for more details

---

<p align="center">Develop by <a href="https://github.com/thiagotrs">Thiago Rotondo Sampaio</a></p>