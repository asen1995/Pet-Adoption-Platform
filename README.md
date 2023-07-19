This application is a back-end of Pet adoption platform. 

It uses Java 17, Spring Boot and MongoDB.


To start mongo db locally, run:
```
docker pull mongo

docker run -d -p 27017:27017 --name petadoption-mongodb mongo
```



Sonarqube analysis

```console


mvn clean verify sonar:sonar \
  -Dsonar.projectKey=Pet-Adoption-Platform \
  -Dsonar.projectName='Pet-Adoption-Platform' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_5475ace107283d0d7ce22f0e0fd316452cd9ba48

```


