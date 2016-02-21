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

  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{"companyId":3,"name":"New company updated","address":"new address","city":"some sity","country":"some country","email":"email@newcompany.com","phone":"5134512341234","beneficialOwners":["Owner 1 new company","Owner 2 new company","Owner 3 new company"]}' https://shrouded-cliffs-80167.herokuapp.com/springbootmock/rest/companies
  ```
5. Able to add beneficial owner(s) of the company

  ```
  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '["First new owner", "Second new owner"]' https://shrouded-cliffs-80167.herokuapp.com/springbootmock/rest/companies/3/owners
  ```

## Security

Depending on the real use case, two solutions are on my mind.
If the use case is a public service, something like Yellow Pages, with HTTPS + basic auth.
In case it is something more private, a 3-legged OAUTH approach would be more approriate - token expiration could be set on some shorter inteval which would force system to generate it more frequently are thus reduce the chance of somebody stealing the identity of the user.

## Service redundancy
In order to make it redundant, number of web and/or worker dynos should be increased. Heroku offers that as one of basic features. Depending on the type of the app, the rations of web and worker dynos can be different - many HTTP requests demand more web dynos while long running computations would ask for more worker dynos.
Also, when scaling the app, it is always wise not to do it in the same region in order to avoid region black-outs or any kind of outages.
