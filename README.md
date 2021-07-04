# Movie Review System
Web based application to add reviews for the latest movies and events

## Technologies  
* Kotlin 
* Spring boot
* Couchbase
* OpenApi 3

## Dockerization Steps 
	* gradlew build
	* docker network create persistentStore
	* docker build -t couchbase-custom .
	* docker build -t spring-boot-custom .
	* docker container run --network persistentStore --name simplecurdapp -p 8080:8080 -d simplecurdapp
	* docker-compose run -d --service-ports --name couchbase couchbase
	* docker-compose run -d --service-ports --name spring-boot spring-boot