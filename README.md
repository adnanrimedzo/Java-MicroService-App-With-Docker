# BlueHarvest Case Study

Case Study for BlueHarvest

Features :
- Maven docker plugin
- build images without dockerfile
- Docker in a multi module project
- docker-compose definition

How to run this example :

```sh
## build docker images
mvn clean install

##should display three freshly built docker images
docker images

##start up all instances
docker-compose up

##starts a 2nd instance of echo-service
docker-compose scale account-service=2
```

## Useful docker commands
```sh
##Starting multiple echo services
docker-compose scale account-service=3

##Replace a running container with the latest version (during development)
mvn install
docker-compose stop echo-service
docker-compose up -d echo-service
```

Once all the services are up, the following URLs will be available 
(please wait until embedded mongodb download and services regitrations)

Address | Description
--- | ---
http://localhost:8761 | Eureka service.
http://localhost:9090/swagger-ui.html | Zuul api gateway route definitions


## Usage With Curl

**Create account with zero balance**
```sh
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:9090/api/account/?customer=1&balance=0&firstName=adnan&surname=ozdemir'
```
**Create account with nonzero balance**
```sh
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:9090/api/account/?customer=1&balance=20&firstName=adnan&surname=ozdemir'
```
**Check accounts and transactions**
```sh
curl -X GET --header 'Accept: application/json' 'http://localhost:9090/api/account/'
```

## Usage With Swagger UI:

**Create account:**
`http://localhost:9090/swagger-ui.html#!/account-controller/addUsingPOST
`

**Check account and transaction informations:**
`http://localhost:9090/swagger-ui.html#!/account-controller/findAllUsingGET
`

### References:
https://exampledriven.wordpress.com/2016/06/24/spring-boot-docker-example/

https://github.com/piomin/sample-spring-microservices-advanced

https://github.com/piomin/sample-spring-microservices