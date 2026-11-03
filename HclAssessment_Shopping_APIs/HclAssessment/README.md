# HCL Assessment - Online Shopping REST APIs

Java 17, Spring Boot 3.3.5, MySQL.

## Setup
1. Install Java 17, Maven, and MySQL.
2. Run `CREATE DATABASE shopping_db;` in MySQL (or let the JDBC URL create it).
3. Edit `src/main/resources/application.properties` or set `DB_USER` and `DB_PASSWORD` environment variables.
4. Run `mvn spring-boot:run`.
5. Test at `http://localhost:8080` with Postman, using `Content-Type: application/json`.

## API endpoints
- POST /api/customers/register, GET /api/customers, GET/PUT/DELETE /api/customers/{id}
- POST/GET /api/products, GET/PUT/DELETE /api/products/{id}
- GET /api/products/category/{category}, GET /api/products/search?name=phone
- POST /api/cart/add/{customerId}/{productId} with `{ "quantity": 2 }`
- GET /api/cart/{customerId}
- PUT /api/cart/update/{cartItemId} with `{ "quantity": 3 }`
- DELETE /api/cart/remove/{cartItemId}, DELETE /api/cart/clear/{customerId}

## Sample bodies
Customer: `{ "name":"Rahul", "email":"rahul@example.com", "mobile":"9876543210" }`
Product: `{ "name":"Phone", "category":"Electronics", "price":15000, "quantity":10 }`

Cart quantities are checked against available stock; adding an item again increases its quantity. Cart item price is read from the product when added or updated. Cart total is the sum of price times quantity. No checkout/stock deduction is included.

## Note
Package folders are capitalized (Controller, Entity, Exception, Repository, Service) to match the supplied screenshot. Do not include the generated `target` folder in GitHub.
