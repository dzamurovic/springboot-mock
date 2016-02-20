# springboot-mock

A small SpringBoot web app made of simple REST service and small AngulaJS client.
Application offers REST services to manipulate on registry of companies as well as the simplistic UI with corresponding functionalities.

It consists of only web app module although in real life JS client project could be separated from the REST services project, built separately and deployed separately.

Web app can be accesses on this URL: http://shrouded-cliffs-80167.herokuapp.com/springbootmock

### Using cURL and REST services

1. create new company

  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{"name":"New company","address":"new address","city":"some sity","country":"some country","email":"email@newcompany.com","phone":"5134512341234","beneficialOwners":["Owner 1 new company","Owner 2 new company","Owner 3 new company"]}' http://shrouded-cliffs-80167.herokuapp.com/springbootmock/rest/companies
  ```
2. Get a list of all companies

  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://shrouded-cliffs-80167.herokuapp.com/springbootmock/rest/companies
  ```
  
3. Get details about a company

  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://shrouded-cliffs-80167.herokuapp.com/springbootmock/rest/companies/2
  ```
  
4. Able to update a company
5. Able to add beneficial owner(s) of the company
