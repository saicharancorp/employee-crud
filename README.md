
## Run Spring Boot application
```
mvn spring-boot:run
```
https://github.com/iamvickyav/spring-boot-data-H2-embedded

curl --location --request POST 'http://localhost:8080/employee' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=' \
--data-raw '{
	"id":111,
    "name":"test"
}'

Basic Auth : username , password
