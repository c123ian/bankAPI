# bankAPI
REST API for banking app. Built with Java, connects to MySQL database using Hibernate

LocalHost: 8081

POSTMAN: 

GET http://localhost:8081 <- check if local server running

GET http://localhost:8081/api/customers <- get current customers (name, cust_id, address, email)

POST http://localhost:8081/api/customers/save <- add customer 

  * Content-Type: application/json
  * Body > raw > then enter:
  
    {
	  "name": "Jack"
     }
