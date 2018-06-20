# eureka-study


## switch to the corresponding directory

###start eureka server<br>
mvn spring-boot:run -Dspring.profiles.active=server1<br>
mvn spring-boot:run -Dspring.profiles.active=server2<br>

###start service provider<br>
mvn spring-boot:run -Dspring.profiles.active=provider1<br>
mvn spring-boot:run -Dspring.profiles.active=provider2<br>
mvn spring-boot:run -Dspring.profiles.active=provider3<br>
mvn spring-boot:run -Dspring.profiles.active=provider4<br>

###start service consumer<br>
mvn spring-boot:run<br>