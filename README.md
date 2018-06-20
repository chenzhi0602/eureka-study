# eureka-study


## switch to the corresponding directory

###start eureka server
mvn spring-boot:run -Dspring.profiles.active=server1
mvn spring-boot:run -Dspring.profiles.active=server2

###start service provider
mvn spring-boot:run -Dspring.profiles.active=provider1
mvn spring-boot:run -Dspring.profiles.active=provider2
mvn spring-boot:run -Dspring.profiles.active=provider3
mvn spring-boot:run -Dspring.profiles.active=provider4

###start service consumer
mvn spring-boot:run