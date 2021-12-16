![Capture](https://user-images.githubusercontent.com/21150740/146417761-b3551433-8ac5-4b09-ad99-6128ed40a7ff.JPG)
![Capture](https://user-images.githubusercontent.com/21150740/146417802-e00019ec-50f5-40c5-ad0e-d2e84c04c797.JPG)
# Springboot-Microservice
Springboot-Microservice

1. build each microservice and copy the snapshot jars in the same directory
2. to keep the sequence of services start execute startAll
3. run request bat file to create user and accounts.
4. analyze request response using client of your choice like Insomnia.


# Spring Boot with GraphQL Query Example

Update: Upgraded to Java 11 and Graph QL to 5+ version dependency

## Book Store
- `/rest/books` is the REST resource which can fetch Books information
- DataFetchers are Interfaces for RuntimeWiring of GraphQL with JpaRepository

## Sample GraphQL Scalar Queries
- Accessible under `http://localhost:8091/rest/books`
- Usage for `allBooks`
```
{
   allBooks {
     isn
     title
     authors
     publisher
   }
 }
```
- Usage for `book`
```
  {
   book(id: "123") {
     title
     authors
     publisher
   }
```
- Combination of both `allBooks` and `book`
```
{
   allBooks {
     title
     authors
   }
   book(id: "124") {
     title
     authors
     publisher
   }
 }
```

![Capture](https://user-images.githubusercontent.com/21150740/146417905-093df906-e9c2-4880-867f-65314e432bca.JPG)

