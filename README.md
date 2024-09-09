## Welcome task for 5DHub internship

---

### Application have *2 business microservices*:
- User service, which responsibility is managing users. It has two endpoints:
    1) **/api/v1/users/{lastname}**, where *'lastname'* is path variable. This endpoint performs search for user with 
  specific lastname. If user not found, returns 404 status.
    2)  **/api/v1/users?id=...**, where *'id'* is request parameter, which can contain one or multiple values. Returns
  list of users according to id values.


- Company service, which responsibility is managing companies. It has two endpoints:
    1) **/api/v1/companies/{companyId}**, where *'companyId'* is path variable. This endpoint performs search for 
    company with specific id. If company not found, returns 404 status.
    2) **/api/v1/companies/search**. This endpoint have search filter, consisting of two request parameters: companyId 
      and companyName. Both of them are optional. This endpoint performs search for
          company with provided id or name. If company not found, returns 404 status.
---

### Application also contains *3 Spring Cloud microservices*:
- Config server
- Eureka discovery server
- API gateway
---
### How to run application
To run application you need to perform these steps:
- Install and run Docker 
- Download this project
- Run `mvn clean install` for each microservice
- Run `docker compose up` to start all containers
- Application will be available on *https:/localhost:8282* (API gateway port)