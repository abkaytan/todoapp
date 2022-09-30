# ToDo App Project with Spring Boot
***

![](https://img.shields.io/badge/java_17-✓-blue.svg)
![](https://img.shields.io/badge/spring_boot-✓-blue.svg)
![](https://img.shields.io/badge/H2Database-✓-blue.svg)
![](https://img.shields.io/badge/jwt-✓-blue.svg)
![](https://img.shields.io/badge/swagger-✓-blue.svg)
![](https://img.shields.io/badge/Thymeleaf-✓-blue.svg)

***
### Entities
- Customer, Todo, Login
***

### Controller
- CustomerController, TodoController, LoginController

***
### Services
- CustomerService, TodoService
- LoginService, UserDetailsImpl (for Jwt Authorization and Authentication)
***

Regiser :
```json
{
  "name": "abkode",
  "password": "123456",
  "email": "aasd@deneme.com",
  "phoneNumber": "555000"
}
```
Login :
```json
{
  "username": "abkode",
  "password": "123456"
}
```
* H2Database Screenshot:

![](src/main/resources/img/h2database.png)

* Swagger - Authorize Screenshot:
![](src/main/resources/img/swaggerjwtauthoizepanel.png)

* Still working on thymeleaf
![](src/main/resources/img/loginpage.png)